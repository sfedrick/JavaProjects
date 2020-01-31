package lab3.LinkedList;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		City[] us= new City[5];
		CityDLL list= new CityDLL();
		CityDLL listpop= new CityDLL();
		
		
		us[0]=new City("Philadelphia", 1567442);
		us[1]=new City("NewYork", 8550405);
		us[2]=new City("Houston",2296224);
		us[3]=new City("Chicago", 2720546);
		us[4]=new City("LosAngeles",3971883);
		
		
		
		
		for(City c:us) {
			
			list.insertsorted(c);
			
			
			
		 	
		}
		for(City c:us) {
			
			listpop.insertsortedpop(c);
			
			
			
		 	
		}
		
		System.out.println(list);
		System.out.println(listpop);
		
		

		 
	}

}
