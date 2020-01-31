package lab2.ArrayList;
import java.util.*;

public class makeArray {
	ArrayList<Integer> list1;
	
	public static ArrayList<Integer> make(int length){
		ArrayList<Integer> list1= new ArrayList<Integer>();
		int size=length;
		for (int i=1;i<=size;i++) {
			list1.add(i);
			
		}
		return list1;
		
	}
	public static ArrayList<Integer> reverse(ArrayList<Integer> nums){
		ArrayList<Integer> list1= nums;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int size=list1.size();
		for (int i=size-1;i>=0;i--) {
			temp.add(list1.get(i));
			
		}
		return temp;
		
	}
	public static double average(ArrayList<Integer> list) {
		ArrayList<Integer> numbers= list;
		double sum=0;
		for(int num:list) {
			sum=sum+num;
		}
		double length= numbers.size();
		double average=sum/length;
		return average;
	}
	public static ArrayList<Integer> evenout(ArrayList<Integer> nums){
		int size= nums.size();
		ArrayList<Integer> temp= new ArrayList<Integer>();
		for (int i=0;i<size;i++) {
			if (nums.get(i)%2==0) {
				temp.add(nums.get(i));
			}
			
		}
	
		return temp;
	}
	public static ArrayList<Integer> add(int first,int mid, int last,ArrayList<Integer> nums){
		int size= nums.size();
		ArrayList<Integer> temp= new ArrayList<Integer>();
		int center=size/2;
		temp=nums;
		temp.set(0,first);
		temp.set(center-1,mid);
		temp.set(size-1,last);
		
	
		return temp;
	}

}




