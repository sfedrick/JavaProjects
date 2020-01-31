package homework4.stacks;

public class ArrayDeque<E> implements Deque<E>{
	 /** Default array capacity. */
	  public static int CAPACITY = 1000;      // default array capacity

	  /** Generics  used for storage of queue elements. */
	  private E[] circular;                             // generic array used for storage
	  
	  /** Current number of elements in the queue. */
	  private int  size;                           // current number of elements
	  private int  front; 
	  private int  rear; 
	 
	      
	  
	  // constructors
	  /** Constructs an empty queue using the default array capacity. */
	  public ArrayDeque() {this(CAPACITY);}         // constructs queue with default capacity

	  /**
	   * Constructs and empty queue with the given array capacity.
	   * @param capacity length of the underlying array
	   */
	 
	  public ArrayDeque(int capacity) {             
		// constructs queue with given capacity
		CAPACITY=capacity;
		circular= (E[]) new Object[capacity];
		front = -1; 
        rear = 0;
        size=capacity;
	 
	  }
	  /**
	   * Returns the number of elements in the deque.
	   * @return number of elements in the deque
	   */
	  public int size() {
		  return size;
	  }
	  public boolean full() {
		  return ((front == 0 && rear == size-1)|| 
		            front == rear+1); 
	  }

	  /**
	   * Tests whether the deque is empty.
	   * @return true if the deque is empty, false otherwise
	   */
	  public boolean isEmpty() {
		  return size+1==0;
	  }

	  /**
	   * Returns (but does not remove) the first element of the deque.
	   * @return first element of the deque (or null if empty)
	   */
	  public E first(){
		 if (isEmpty()|| front < 0) 
	        { 
	             
	            return null ; 
	        } 
	     return circular[front];
		 
	  }

	  /**
	   * Returns (but does not remove) the last element of the deque.
	   * @return last element of the deque (or null if empty)
	   */
	  public E last() {
		  if(isEmpty() || rear < 0) 
	        { 
	            System.out.println(" Underflow\n"); 
	            return null ; 
	        } 
	        return circular[rear];
	  }

	  /**
	   * Inserts an element at the front of the deque.
	   * @param e   the new element
	   */
	  public void addFirst(E e) throws IllegalStateException{
		  if (full()) 
	        { 
			  	throw new IllegalStateException("Deque is full");
	            
	            
	        } 
		  if (front == -1) { 
	            front = 0; 
	            rear = 0; 
	        } 
		  else if (front == 0){
	            front = size - 1 ; 
		  }
		  else {
	            front = front-1; 
		  }
		  
		  circular[front] = e ;
	  }

	  /**
	   * Inserts an element at the back of the deque.
	   * @param e   the new element
	   */
	  public void addLast(E e) throws IllegalStateException{
		  if (full()) 
	        { 
			  throw new IllegalStateException("Deque is full");
	           
	        } 
	   
	        // If queue is initially empty 
	        if (front == -1) 
	        { 
	            front = 0; 
	            rear = 0; 
	        } 
	   
	        // rear is at last position of queue 
	        else if (rear == size-1) 
	            rear = 0;
	        else
	            rear = rear+1;
	        circular[rear] = e ; 
		  
	  }

	  /**
	   * Removes and returns the first element of the deque.
	   * @return element removed (or null if empty)
	   */
	  public E removeFirst() {
		  E x;
		  if (isEmpty()) 
	        { 
	            
	            return null; 
	        } 
		  if (front == rear) 
	        { 	
			  	x= circular[front];
	            front = -1; 
	            rear = -1; 
	            return x;
	        } 
		  else {
			  x= circular[front];
			  if (front == size -1) { 
	                front = 0; }
	   
	         else {
	                front = front+1; }
	       return x;
		  }
	            
	  }

	  /**
	   * Removes and returns the last element of the deque.
	   * @return element removed (or null if empty)
	   */
	  public E removeLast() {
		  E x;
	        if (isEmpty()) 
	        { 
	            
	            return null; 
	        } 
	   
	        // Deque has only one element 
	        if (front == rear) {   
	        	x=circular[rear];
	            front = -1; 
	            rear = -1; 
	            return x;
	        } 
	        else if (rear == 0) {
	        	x=circular[rear];
	            rear = size-1; 
	            return x;}
	        else{
	        	x=circular[rear];
	            rear = rear-1;
	        	return x;}
	  }
	  public String toString(){
		  String builder="(";
		  int index=front%(size);
		  
		  for(int i=0;i<size-1;i++) {
			  
			  
			  //once we reach the end of the array we loop around
			  if(index==size) {
				  index=index%(size);
			  }
			  E item=circular[index];
			  if(item!=null) {
				  if(i==0) {
				  builder=builder + " "+item.toString();}
				  else {
				  builder=builder + ","+item.toString();}  
				  
			  }
			  index++;
	  }
		  return builder+")";
	  }


}
