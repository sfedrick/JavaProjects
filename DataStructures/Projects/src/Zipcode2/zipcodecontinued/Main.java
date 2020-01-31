package homework2.zipcodecontinued;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// Main entry point into program
public class Main {
// Entry  into Main
	public static void main(String[] args) {
	//Reads in data from each file and loads them to places loc
		PopulatedPlace[] placesloc=LookupZip.readZipCodes("/Users/thedude/javaprograms/homework/A1/uszipcodes.csv","/Applications/notes/Classes/cs206/assignments/a2/ziplocs.csv");
	
		// Takes zipcode input from user
	    String zipinput= new String();
	    
	    Scanner object = new Scanner(System.in);
	    String stop="00000";
	    System.out.println("enter a zipcode");
		while(!(zipinput.equals(stop))){
				    zipinput = object.nextLine(); 
				    PopulatedPlace placex=LookupZip.lookupZip(placesloc,zipinput);
				    String latlong=placex.getLatitude()+placex.getLongitude();
				    if(!(placex.getZip()).equals("")){
				    	
				    	if(placex.getPopulationint()>0) {
							System.out.println(placex);
							
						}
				    	else if(latlong != null && !latlong.isEmpty()) {
				    	LocatedPlace locplace= new LocatedPlace(placex.getZip(),placex.getState(),placex.getTown(),placex.getLatitude(),placex.getLongitude());
				    		System.out.println(locplace);
				    	}
				    	else if(!(placex.getZip()).equals("")) {
				    		Place place= new Place(placex.getZip(),placex.getState(),placex.getTown());
				    		System.out.println(place);
				    	}
				    		
				    }
				   
				    else  {
						//prevents the system from printing 
						//zipcode: 00000
						//no such zipcode			  
				    if(!(zipinput.equals(stop))) {
					    System.out.println("zipcode: "+zipinput);
					    System.out.println("No such zipcode");
				    	}
					}
				   
				    
			  }
			    
	  
	    	System.out.println("zipcode: "+zipinput);
	    	System.out.println("Good Bye!");
	    
	}

}




