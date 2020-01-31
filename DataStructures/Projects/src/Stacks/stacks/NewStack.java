package homework4.stacks;

public class NewStack {
	/** Default array capacity. */
	  public static final int CAPACITY=1000;   // default array capacity
	  
	  /** Generic array used for storage of stack elements. */
	  private int[] data;                        // int array used for storage

	  /** Index of the top element of the stack in the array. */
	  private int t = -1;                      // index of the top element in stack
	  private int min;
	  /** Constructs an empty stack using the default array capacity. */
	  public NewStack() { this(CAPACITY); }  // constructs stack with default capacity

	  /**
	   * Constructs and empty stack with the given array capacity.
	   * @param capacity length of the underlying array
	   */
	 
	  public NewStack(int capacity) {        // constructs stack with given capacity
	    data = new int[capacity];     // safe cast; compiler may give warning
	  }

	  /**
	   * Returns the number of elements in the stack.
	   * @return number of elements in the stack
	   */
	  
	  public int size() { return (t + 1); }

	  /**
	   * Tests whether the stack is empty.
	   * @return true if the stack is empty, false otherwise
	   */
	 
	  public boolean isEmpty() { return (t == -1); }

	  /**
	   * Inserts an element at the top of the stack.
	   * @param e   the element to be inserted
	   * @throws IllegalStateException if the array storing the elements is full
	   */
	
	  public void push(int e) throws IllegalStateException {
	    if(isEmpty()) {
	    	min=e;
	    }
	    else if(e<min) {
	    	min=e;
	    }
	    if (size() == data.length) throw new IllegalStateException("Stack is full");
	    data[++t] = e;   // increment t before storing new item
	    
	  }

	  /**
	   * Returns, but does not remove, the element at the top of the stack.
	   * @return top element in the stack (or null if empty)
	   */
	  
	  public int top() {
	    if (isEmpty()) return (Integer)null;
	    return data[t];
	  }

	  /**
	   * Removes and returns the top element from the stack.
	   * @return element removed (or null if empty)
	   */
	  
	  public int pop(){
		int answer;
	    if (isEmpty()) return (Integer)null;
	    answer = data[t];
	    data[t] = (Integer)null;                        // dereference to help garbage collection
	    t--;
	    return answer;
	  }

	  /**
	   * Produces a string representation of the contents of the stack.
	   * (ordered from top to bottom). This exists for debugging purposes only.
	   *
	   * @return textual representation of the stack
	   */
	  public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    for (int i=0;i<t+1;i++) {
	    	
	    	if(i==0) {
	    		sb.append(data[i]);
	    	}
	    	else {
	    		sb.append(" ,"+data[i]);}
	    	}	
	    sb.append(")");
	    return sb.toString();
	  }
	  //returns the smallest element 
	  public int getMin() {
		  return min;
	  }

}
