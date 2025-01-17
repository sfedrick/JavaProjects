package homework6.trees;



public class BinaryTree<E extends Comparable<E>> implements BinaryTreeInterface<E> {

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
		public void setData(E data) {element=data;}
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
    	if (data.compareTo(rootin.getData()) < 0){
    		
    		heightchecker++;
    		rootin.setLeft(insertRec(rootin.getLeft(), data));
    	}
    	else {
    		heightchecker++;
    		rootin.setRight(insertRec(rootin.getRight(), data));}
    	return rootin;
    }
    
    public void update(E datainput){
    	update(root, datainput);
    	
    }
    /* this has not been tested come back and test it
     * 
     */
    public Node<E> update(Node<E>rootin,E datainput){
    	
    	
    	
    	
    		if (rootin.getData() instanceof Candidate && datainput instanceof Candidate) {
    			String name=((Candidate)rootin.getData()).getName();
    			String nameinput=((Candidate)datainput).getName();
    		
    		if (name.equals(nameinput)) {
        		rootin.setData(datainput);
        		return rootin;
        	}
        	else if(rootin.getData().compareTo(datainput)>0) {
        		return update(rootin.getLeft(), datainput);
        	}
        	else {
        		return update(rootin.getRight(), datainput);
        	}
    		
    		}
    		
    		return rootin;
    	
    	
    }
    public boolean contains(E element) {
    	return recContains(root,element);
    	
    }
    public E peek(E element) {
    	return recPeek(root,element);
    	
    }
    public E recPeek(Node<E>rootin, E data) {
    	if(rootin==null) {
    		
    		return null;
    	}
    	else if (rootin.getData().compareTo(data)==0) {
    		return rootin.getData();
    	}
    	else if(rootin.getData().compareTo(data)<0) {
    		
    		return recPeek(rootin.getRight(), data);
    	}
    	else {
    		
    		return recPeek(rootin.getLeft(), data);
    	}
    }
    
    public boolean recContains(Node<E>rootin, E data) {
    	if(rootin==null) {
    		
    		return false;
    	}
    	else if (rootin.getData().compareTo(data)==0) {
    		return true;
    	}
    	else if(rootin.getData().compareTo(data)<0) {
    		
    		return recContains(rootin.getRight(), data);
    	}
    	else {
    		
    		return recContains(rootin.getLeft(), data);
    	}
    }
    
    public int height() {
    	return height;
    }
    
    
    
    
    public boolean remove(E data){
    	if(contains(data)) {
    		root=removeRec(root, data);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    public E minKey(Node<E> rootin){
        if(rootin.getLeft() == null) {
        	return rootin.getData();
        }
        else {
        	return minKey(rootin.getLeft());
        }
        
    
    }
    
   
   public Node<E> removeRec(Node<E>rootin, E data) {
	   if (rootin == null) {
		   return null;
	   }
	   
	   else if (rootin.getData().compareTo(data)>0) {
		   rootin.setLeft(removeRec(rootin.getRight(), data));
	   }
	   else if (rootin.getData().compareTo(data)<0) {
		   rootin.setRight(removeRec(rootin.getRight(), data));
	   }
	   else {
		   if(rootin.left == null) {
			   return rootin.getRight();
		   }
		   else if (rootin.right == null) {
			   return rootin.getLeft();
		   }
		   else {
			   rootin.setData(minKey(rootin.getRight()));
			   rootin.setRight(removeRec(rootin.getRight(), rootin.getData()));
		   }

	   }
	   return rootin;  
	   
   }
   
   
   public String fileInOrder() {
   	return fileInOrder(root);
   }
	public String fileInOrder(Node<E> rootin) {
		if (rootin != null){
			
   		
   		if(rootin.getData() instanceof String) {
   		return (fileInOrder(rootin.left)+"$"+(String)rootin.getData()+"$"+fileInOrder(rootin.right));
   		}
   		
   		
   		
   	}
		return "$";
	}
    
    

    public void printInOrder() {
    	InOrder(root);
    }
	public void InOrder(Node<E> rootin) {
		if (rootin != null){
			
    		InOrder(rootin.left); 
    		System.out.print(rootin.getData()+" ");
    		InOrder(rootin.right);
    		
    		
    	}
	}
	public void printPreOrder() {
    	PreOrder(root);
    }
	public void PreOrder(Node<E> rootin) {
		if (rootin != null){
			System.out.print(rootin.getData()+" ");
    		InOrder(rootin.left); 
    		InOrder(rootin.right);
    		
    		
    	}
	}
	
	public void printPostOrder() {
    	PostOrder(root);
    }
	public void PostOrder(Node<E> rootin) {
		if (rootin != null){
			
    		InOrder(rootin.left); 
    		InOrder(rootin.right);
    		System.out.print(rootin.getData()+" ");
    		
    	}
	}
	
}
