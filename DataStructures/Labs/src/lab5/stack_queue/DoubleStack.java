package lab5.stack_queue;
import java.util.*;
public class DoubleStack<E> implements Stack<E> {
	private static final int capacity=1000;
	private int usersize;
	private int size=-1;
	private int topsize=-1;
	private int botsize=-1;
	private E[] stack1;
	
	

	public DoubleStack() {
		this(capacity);
	}
	public DoubleStack(int input) {
		if(input%2==0) {
			usersize=input;
			stack1=(E[])new Object[usersize];
			
		}
		else {
			usersize=input+1;
			stack1=(E[])new Object[(usersize)];
			
			
		}
	}
	public int size() {
		
		return size+1;
	}
	public boolean isEmpty() {
		return size+1==0;
		
	}
	public boolean isEmptytop() {
		return topsize+1==0;
		
	}
	public boolean isEmptybot() {
		return botsize+1==0;
		
	}
	
	public void push(int stackId,E e) throws IllegalStateException{
		if(topsize+botsize== stack1.length-2){
			//throw new IllegalStateException("top is full");	
			usersize=usersize*2;
			int count=0;
			
			E[] newstack1=(E[])new Object[usersize];
		
			for(int i=0;i<=topsize;i++) {
				newstack1[i]=stack1[i];
				
			}
			
			int back= newstack1.length-1;
			for(int i=stack1.length-1;i>botsize;i--) {

				newstack1[back]=stack1[i];
				back--;
				
			}
			
			stack1=newstack1;
			if(stackId==1) {
				stack1[++topsize]=e;
			}
			else {
				stack1[botsize]=e;
				botsize++;
			}
			
		}
		else if (stackId==1) {
			
		
			stack1[++topsize]=e;
			
		}
		else {
			int back=botsize+2;
			stack1[stack1.length-(back)]=e;
			++botsize;
		}
		
		
	}
	public E top() {
		E x=null;
		if(isEmptytop()) {
			
			return x;
		}
		else {
			
			x=stack1[topsize];
			return x;
		}
		
		
	}
	public E bot() {
		E x=null;
		if(isEmptybot()) {
			return x;
		}
		else {
			x=stack1[stack1.length-(botsize+1)];
			return x;
		}
		
		
	}
	public E pop() {
		E x=null;
		if(isEmptytop()) {
			return x;
		}
		else {
			x=stack1[topsize];
			stack1[topsize]=null;
			topsize--;
			return x;
		}
	}
	public E scoop() {
		E x=null;
		if(isEmptybot()) {
			return x;
		}
		else {
			int back=botsize+1;
			x=stack1[stack1.length-(back)];
			stack1[stack1.length-(back)]=null;
			botsize--;
			return x;
		}
	}
	public String toString(int id) {
		String badgift="";
		if(id==1) {
			for(int i=0; i<=topsize; i++) {
				E x =stack1[i];
				if(x!=null) {
					
					badgift=badgift+" "+x.toString();
				}
				
			}
			return badgift;
		}
		else {
			for(int i=stack1.length-1; i>botsize; i--) {
				
				E x =stack1[i];
				if(x!=null ) {
					badgift=badgift+" "+x.toString();
				}
				
			}
			return badgift;
			
		}
		
	}
	
	public int size(int id) {
		if (id==1) {
			return topsize+1;
		}
		else {
			return botsize+1;
		}
	}
}
