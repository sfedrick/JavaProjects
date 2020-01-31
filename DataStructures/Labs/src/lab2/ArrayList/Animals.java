package lab2.ArrayList;
import java.util.*;

public class Animals {
	public static void main(String[] args){
		 Mammal[] mammals = new Mammal[4];
		 mammals[0] = new Dolphin("billy","burrr");
		 mammals[1] = new Platypus("billy","burrr");
		 mammals[2] = new Human("billy","burrr");
		 mammals[3] = new CSStudent("billy","burrr");
		 for (int i=0; i< mammals.length; i++){
			 System.out.println("Generally, a " + mammals[i].getName());
			 System.out.println("can be found ");
		 if(mammals[i].livesInWater() == false){
			 System.out.println("on land, ");
		 }
		 else {
			 System.out.println("in water, ");
		 }
		 System.out.println("it can ");
		 	if(mammals[i].laysEggs() == false) {
		 		System.out.println("not ");
		 }
		 System.out.println("lay eggs, and is often overheard saying :");
		 	mammals[i].speak();
		 	
		 	System.out.println("							");
		 }
		}
}
