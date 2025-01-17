package homework7.heaps;

import java.util.*;


public class ArrayHeap<E extends Comparable<E>> extends ArrayBinaryTree<E>  implements PriorityQueue<E>{
	
	private static final int capacity = 50;
	
	protected ArrayHeap(E[] usertree,int size){
		super(usertree,size);
	   } 
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
	public E poll(){
		if(!isEmpty()) {
			E min=tree[0];
			remove(tree[0]);
			return min;
		}
		else {
			return null;
		}
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
	
	
	public ArrayList<Comparable> peekTopN(int n){
		ArrayList<Comparable> max= new ArrayList();
		
		
		
		ArrayHeap heapcopy= new ArrayHeap(tree,count);
		for(int i=n; i>0;i--) {
			
			max.add(heapcopy.poll());
		}
		return max;
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
    		return InOrder(left)+tree[index].toString()+","+InOrder(right);
    		
    		
    	}
		return "";
	}
	public void printPreOrder() {
		System.out.print(PreOrder(0));
    }
	public String PreOrder(int index) {
		if (index<count){
			int left=(index*2)+1;
			int right=(index*2)+2;
			return tree[index].toString()+","+PreOrder(left)+PreOrder(right);
    		
    		
    	}
		return "";
	}
	
	public void printPostOrder() {
		System.out.print(PostOrder(0));
    }
	public String PostOrder(int index) {
		if (index<count){
			int left=(index*2)+1;
			int right=(index*2)+2;
			
    		return PostOrder(left)+PostOrder(right)+tree[index].toString()+",";
    		
    	}
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		
		String printme="tree:"+"\n"+"("+InOrder(0).substring(0, InOrder(0).length() - 2)+")"+"\n"+"("+PostOrder(0).substring(0, PostOrder(0).length() - 2)+")"+"\n"+"("+PreOrder(0).substring(0, PreOrder(0).length() - 2)+")";
		
		return printme;
	}
}
