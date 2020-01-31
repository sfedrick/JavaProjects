package homework3.names;
import java.util.*;

public class NameDLL {
	private static class Node {
    	private Name data;
    	private Node next;
    	private Node previous;
    	private Node(Name data, Node next,Node previous) {
    		this.data = data;
    		this.next = next;
    		this.previous=previous;
    	}
    	public Name getData() {return data;}
    	public Node getNext() {return next;}
    	public Node getPrevious() {return previous;}
    	public void setNext(Node n) {next = n;}
    	public void setPrevious(Node n) {previous = n;}

	}
	private Node head = null;
    private Node tail = null;
    private int size = 0;
   
    public NameDLL() {};
    
   
    
    /*COMMON
     * 
     */
    public int size() {
		return size;
	}
    public boolean isEmpty() {
		return size == 0;
	}
    public Name first() {
		if (isEmpty()) {
			return null;
		}	
		else {
			return head.getData();
		}
	}
    
    public Name last() {
		if (isEmpty()) {
			return null;
		}
		else {
			return tail.getData();
		}
	}
    
    public Name find (String name) {
		for(Node n = head; n!=null; n=n.getNext()) {
		    Name data = n.getData();
		    if (data.getName().equals(name)) {
			return data;
		    }
		}
	        return null;
    }
    
    
    
    /*methods made for lab 3
     * 
     */
    public void addFirst(Name data) {
    	Node newest = new Node(data,head,null );
		if (isEmpty()) {
			tail = head;
		    head = newest;

		}
		else if (size==1){
			tail=head;
			tail.setNext(null);
			head = newest; 
			tail.setPrevious(head);
		}
		else {
			head.setPrevious(newest);
			head = newest;
		}
		 
		size++;
    }
    public void addLast(Name data) {
		Node newest = new Node(data, null, tail);
		if (isEmpty()) { 
			head = newest;
		}
		else if(size==1) {
			tail.setNext(newest);
			tail.setPrevious(head);
		}
		else {
			tail.setNext(newest);
		}
		tail = newest; 
		size++;
	}
    
    public void insertbefore(Name c,Node n) {
    	
    	if(n==head) {
    		addFirst(c);
    	}
    	else {
    	//Node before=null;		
    	Node before=n.getPrevious();
    	Node add=new Node(c,n,before);
    	n.setPrevious(add);
    	before.setNext(add);
		size++;
		
    	}   
		   
		
	}
    
    public void insertsorted(Name c) {
    	
		if (isEmpty()) {
			addLast(c);
		}
		else if (size==1) {
			String name=c.getName();
		    String nodename=head.getData().getName();
			if (name.compareToIgnoreCase(nodename)<0) {
				addFirst(c);
			
			}
			else {
				addLast(c);
			}
			
		}
		else {
			for (Node n=head; n!=null; n=n.getNext()){
			    String name=c.getName();
			    String nodename=n.getData().getName();
			    
			 	
			    if (name.compareToIgnoreCase(nodename)<0) {
			    	
			    	insertbefore(c,n);
			    	return;
				
			    }
			      
			}
			addLast(c); 
		}
	
		
    }
    //Methods to calculate
    public int Rank(int reference) {
    	int rank=0;
    	for(Node n=head; n!=null; n=n.getNext()) {
    		int yeartotal=n.getData().getTotalYearlytotal().getData();
    		if(reference>yeartotal) {
    			rank=rank+1;
    		}
    		
    	}
    	rank=size-rank;
    	return rank;
    }
    
    
    public String toString() {
		String s = new String();
		for (Node n=head; n!=null; n=n.getNext()){
		    s = s + n.getData();
		    if (n != tail) {
			s = s+", ";
		    }
		}
		return s; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
