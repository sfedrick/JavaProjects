package lab7.Binarytrees;
import java.util.*;







public class BinaryTree<E extends Comparable<E>> implements LabBinaryTree<E>{
	
	
	private class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right; //constructors, getters, setters public boolean isLeaf(){
		public Node(E data, Node<E> left,Node<E> right) {
			this.element = data;
			this.left = left;
			this.right=right;
		}
		public E getData() {return element;}
		public Node<E> getLeft() {return left;}
		public Node<E> getRight() {return right;}
		public void setLeft(Node n) {left = n;}
		public void setRight(Node n) {right= n;}
	}
	private Node<E> root = null;
	private int size=0;
	private int heightchecker=-1;
	private int height;
	public BinaryTree() {};
	
	public BinaryTree(Node<E> root) {
		this.root=root;
		
	};
 	public int size() {
 		return size;
 	}
 	
 	
    public boolean isEmpty() {
    	return size==0;
    }
    
    
    public void insert(E element) {
    	heightchecker=0;
    	root=insertRec(root,element);
    	if(height==-1)
    		height=heightchecker;
    	else if (height<heightchecker) {
    		height=heightchecker;
    	}
    	else {
    		height=height;
    	}
    	
    }
    
    public Node<E> insertRec(Node<E>rootin,E data){
    	
    	if(rootin == null) {
    		size++;
    		heightchecker++;
    		return new Node<E>(data,null,null);
    		
    	}
    	if ( (int)data < (int)rootin.getData()){
    		//data.compareTo(root.getData()) < 0
    		heightchecker++;
    		rootin.setLeft(insertRec(rootin.getLeft(), data));
    	}
    	else {
    		heightchecker++;
    		rootin.setRight(insertRec(rootin.getRight(), data));}
    	return rootin;
    }
    
    public boolean contains(E element) {
    	return recContains(root,element);
    	
    }
    public boolean recContains(Node<E>rootin, E data) {
    	if(rootin==null) {
    		return false;
    	}
    	else if (rootin.getData()==data) {
    		return true;
    	}
    	else if((int)rootin.getData()>(int)data) {
    		return recContains(rootin.getLeft(), data);
    	}
    	else {
    		return recContains(rootin.getRight(), data);
    	}
    }
    
    public int height() {
    	return height;
    }

    public void printInOrder() {
    	InOrder(root);
    }
	public void InOrder(Node<E> root) {
		if (root != null){
    		InOrder(root.left); 
    		System.out.print(root.getData()+" "); 
    		InOrder(root.right);
    	}
	}
}
