package lab8.Heaps;

public class ArrayHeap<E extends Comparable<E>> extends ArrayBinaryTree<E>  implements LabPriorityQueue<E>{
	
	private static final int capacity = 50;
	
	public ArrayHeap(){
		this(capacity);
	   } 
	public ArrayHeap(int treesize) 
	   {
		super(treesize);
	   }
	
	public E peek() {
		return null;
	}
	
	public int bubble(int index) {
		
		int parent=(index-1)/2;
		//min top if parent is bigger than child
		if(index<=0) {
			return index;
		}
		else if(tree[parent]!=null && tree[parent].compareTo(tree[index])>0) {
			
			return index;
		}
		else if(tree[parent].compareTo(tree[index])<0){
			
			//swap
			E temp=tree[parent];
			tree[parent]=tree[index];
			tree[index]=temp;
			bubble(parent);
			return index;
			
		}
		else {
			
			return index;
		}
			
		
	}
	public void insert(E element) {
			
			tree[count]=element;
			bubble(count);
			count++;
			
			
				
	}
	public E sink(int index) {
		
		E current=tree[index];
		int left=(2*index)+1;
		int right=(2*index)+2;
		E childL;
		E childR;
		if(left<=count) {
			childL=tree[left];
			}
		else {
			childL=null;
		}
		if(right<=count) {
			childR=tree[right];
			}
		else {
			childR=null;
		}
		
		if(childL==null && childR==null) {
			
			bubble(index);
			return tree[index];
			
			
		}
		else if(childR==null && childL.compareTo(tree[index])<0) {
			
			E temp=childL;
			tree[left]=tree[index];
			tree[index]=temp;
			sink(left);
			
		}
		else if(tree[index].compareTo(childR)>0 && tree[index].compareTo(childL)>0) {
			
			return tree[index];
		}
		else if(childL.compareTo(childR)>0 && childL.compareTo(tree[index])>0){
			
			E temp=childL;
			tree[left]=tree[index];
			tree[index]=temp;
			sink(left);
			
		}
		else if(childL.compareTo(childR)<0 && childR.compareTo(tree[index])>0) {
			
			E temp=childR;
			tree[right]=tree[index];
			tree[index]=temp;
			sink(right);
		}
		return null;
		
	}

	public boolean remove(E element) {
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				if(i==(count-1)) {
				tree[count-1]=null;
				count--;
				return true;
				}
				else {
					E temp=tree[count-1];
					tree[i]=temp;
					tree[count-1]=null;
					count--;
					sink(i);
					return true;
				}
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
}
