package lab2.ArrayList;
import java.util.*;
public class Main{
	
	public static void main(String[] args) {
		ArrayList<Integer> list1= new ArrayList<Integer>();
		ArrayList<Integer> reverse= new ArrayList<Integer>();
		list1=makeArray.make(100);
		reverse=makeArray.reverse(list1);
		System.out.println(list1);
		System.out.println(reverse);
		System.out.println(makeArray.average(list1));
		System.out.println(makeArray.evenout(list1));
		System.out.println(makeArray.add(200,400,300,list1));
		
	}

}
