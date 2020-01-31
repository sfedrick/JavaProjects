package lab8.Heaps;

public class ArrayBinaryTree<E extends Comparable<E>> implements LabBinaryTree<E> {
	protected int count;
	protected E[] tree; 
	private static final int capacity = 50;
	
	public ArrayBinaryTree(){
		this(capacity);
	   } 
	public ArrayBinaryTree(int treesize) 
	   {
		count = 0;
		tree = (E[])new Comparable[treesize];
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
	
	
	public int size() {
		return count;
	}
	public void insert(E element) {
		int parent=count;
		boolean increment=true;
		while(parent>=0) {
			if(count==0) {
				tree[count]=element;
				parent=-1;
			}
			else if(tree[(count-1)/2]!=null) {
				tree[count]=element;
				parent=-1;
				}
			else {
				increment=false;
				parent=(parent-1)/2;
			}
		}
		count++;
	}
	
	public boolean remove(E element) {
		for(int i=0;i<tree.length;i++) {
			if(tree[i]!=null && tree[i].compareTo(element)==0) {
				int j=i;
				while(j<tree.length && tree[j]!=null) {
					if(2*j<tree.length) {
						
						tree[j]=tree[2*j+1];
						j=2*j+1;
					}
					else if(2*j+1<tree.length) {
						
							tree[j]=tree[2*j+2];
							j=2*j+2;
						
					}
					else {
						tree[j]=null;
						
					}
				}
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
}
