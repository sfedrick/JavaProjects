package homework4.stacks;

import java.lang.Math;

public class Main {
	public static void main(String[] args) {
	//this is to test arraystack
		int n=0;
		ArrayQueue<String> quetest= new ArrayQueue<>(12);
		ArrayDeque<String> dequetest= new ArrayDeque<>(24);
		NewStack testnewstack = new NewStack(24); 
		
		//test array queue
		
		while(n<12) {
	    	 
	    	  
	    	  quetest.enqueue("qued:"+n);
	    	  n++;
	      }
		n=0;
		System.out.println(quetest);
		System.out.println("these are dequed:");
		while(n<12) {
			  n++;
	    	  System.out.print(quetest.dequeue()+" ");
	    	  
	      }
		
		System.out.println(" ");
		
		
	//this is to test Array Deque	
		n=0;
	
        
		while(n<10) {
	    	  
	    	  
			dequetest.addLast("added last deque: "+n);
	    	 n++;
	      }
		n=0;
		System.out.println(dequetest); 
		while(n<10) {
	    	  
	    	  
			dequetest.addLast("added first deque: "+n);
	    	 n++;
	      }
		System.out.println(dequetest);
		
		
		n=0;
		//this tests newstack
		while(n<12) {
			n++;
			int rand=(int)(Math.random()*200-100);
			System.out.print(rand+" ");
			
	    	  testnewstack.push(rand);
	    	  
	    	  
	      }
		System.out.println(" ");
		
   
		
        System.out.println(testnewstack); 
        System.out.println(testnewstack.getMin()); 
		
		
		
	}
}
