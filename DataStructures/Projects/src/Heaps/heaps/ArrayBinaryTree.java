package homework7.heaps;


public class ArrayBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
	protected int count;
	protected E[] tree; 
	protected static final int capacity = 50;
	
	protected ArrayBinaryTree(E[] usertree,int size){
		count=size;
		tree = (E[])new Comparable[size];
		
		
		for(int i=0; i<count;i++) {
			tree[i]=usertree[i];
		}
		
		
	} 
	public ArrayBinaryTree(){
		this(capacity);
	   } 
	public ArrayBinaryTree(int treesize) 
	   {
		count = 0;
		tree = (E[])new Comparable[treesize];
	   }
	
	public void update(E element) {
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				tree[i]=element;
			}
			
		}
		
		
		
	}
	public E peek(E element) {
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				return tree[i];
			}
			
		}
		return null;
	}
	public boolean isEmpty() {
		return count==0;
	}
	

	public E getRootElement() {
	if(!isEmpty())
		return tree[0];
	else
		return null;
	}
	
	public int height() {
		int base2=2;
		return count/base2;
	}
	public boolean contains(E element){
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public int size() {
		return count;
	}
	public void insert(E element) {
		int parent=count;
		boolean increment=true;
		tree[count]=element;
		count++;
	}
	
	public boolean remove(E element) {
		
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				E temp=tree[count-1];
				tree[i]=temp;
				tree[count-1]=null;
				count--;
				return true;
			}
		}
		return false;
	}
	public String toStringBreadthFirst() {
		String breadth="";
		for(int i=0;i<tree.length;i++) {
			if(tree[i]==null ) {
				if(i<count) {
					breadth=breadth+" ( ) ";
				}
			}
			else {
				breadth=breadth+tree[i].toString()+" ";
			}
		}
		return breadth;
	}
	public void printInOrder() {
    	System.out.print(InOrder(0));
    }
	public String InOrder(int index) {
		if (index<count){
			int left=(index*2)+1;
			int right=(index*2)+2;
    		return InOrder(left)+","+tree[index].toString()+","+InOrder(right);
    		
    		
    	}
		return "";
	}
}


