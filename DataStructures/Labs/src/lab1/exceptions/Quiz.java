package lab1.exceptions;
import java.util.*;

public class Quiz {
	public static boolean isPrime(int num) {
		int prime= num;
		int count=2;
		while (count<num) {
			if (prime%count==0) {
				return false;
			}
			else {
				count= count+1;
			}
		}
		return true;
	}
	public static double average(int [] list) {
		int [] numbers= list;
		double sum=0;
		for(int num:list) {
			sum=sum+num;
		}
		double length= numbers.length;
		double average=sum/length;
		return average;
	}
	public static int counta(String inputparent, String inputchild) {
		
		String child=inputchild;
		String parent=inputparent;
		int count=0;
		int start=0;
		int parentindex= parent.length();
		int childindex= child.length();
		while (childindex<=parentindex) {
			String split= parent.substring(start,childindex);
			 
			if (split.equals(child)) {
				count= count +1;
				start=start+1;
				childindex=childindex +1;
			}
			else {
				start=start+1;
				childindex=childindex +1;
				
			}
			
			
		}
		
		return count;
	}
	
public static int countb(String inputparent, String inputchild) {
		
		String child=inputchild;
		String parent=inputparent;
		String empty=parent.replaceAll(child,"");
		int count=0;
		while (!(empty.equals(parent))) {
				count= count +1;
				parent=parent.replaceFirst(child,"");
			
			}
		
		return count;
	}
	
	public static void main(String[] args) {
		int x=11;
		int [] list= {1,2,3,4,5,6,7,8,9,10};
		String parent="aaa";
		String child="aa";
		
		boolean prime=isPrime(x);
		System.out.println(prime);
		System.out.println(average(list));
		System.out.println(counta(parent,child));
		System.out.println(countb(parent,child));
		
	}
}
