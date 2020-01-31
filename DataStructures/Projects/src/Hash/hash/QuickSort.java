package homework8.hash;
import java.util.*;
public class QuickSort<E> {
	private int copies=0;
	private ArrayList<Comparable <E>> arr;
		public QuickSort(ArrayList<Comparable <E>> arr) {
			this.arr=arr;
		}
	public int getcopies() {
		return copies;
	}
	public ArrayList<Comparable <E>> getArray() {
		return arr;
	}
	public int partition(ArrayList<Comparable <E>> arr, int low, int high) 
	 { 
		 Comparable <E> pivot = arr.get(high);  
	     int i = (low-1); 
	     for (int j=low; j<high; j++) 
	     { 
	         
	    	 
	         if ((arr.get(j)!= null && (E)pivot!=null) && arr.get(j).compareTo((E)pivot)<0) 
	         { 
	             i++; 
	             Comparable <E> temp = arr.get(i); 
	             arr.set(i, arr.get(j));
	             arr.set(j,temp);
	         } 
	         else if((arr.get(j)!=null&& (E)pivot!=null) && arr.get(j).compareTo((E)pivot)==0) {
	        	 arr.set(j, null);
	        	 copies=copies+1;
	         }
	     } 
	
	     
	     Comparable <E> temp = arr.get(i+1); 
	     arr.set(i+1, arr.get(high)); 
	     arr.set(high,temp);
	
	     return i+1; 
	 } 
	
	public void sort(){
		sorthelper(this.arr, 0, this.arr.size()-1);
	}
	
	 private void sorthelper(ArrayList<Comparable <E>> arr, int low, int high) 
	 { 
	     if (low < high) 
	     { 
	         
	         int pi = partition(arr, low, high); 

	         sorthelper(arr, low, pi-1); 
	         sorthelper(arr, pi+1, high); 
	     } 
	 } 
	
	 
	 public void printArray() 
	 { 
	     int n = arr.size(); 
	     for (int i=0; i<n; ++i)
	    	 if(arr.get(i)!=null) {
	    		 System.out.print(arr.get(i)+" "); 
	    	 }
	    	 else {
	    		 
	    	 }
	     System.out.println(); 
	 } 
}
