package homework1.zipcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// Main entry point into program
public class Main {
// Entry  into Main
	public static void main(String[] args) {
		
		//produces an array of places with Zipcode,State, and town
		Place[] places= LookupZip.readZipCodes("/Users/thedude/javaprograms/homework/A1/uszipcodes.csv");
		
		// Takes zipcode input from user
	    String zipinput= new String();
	    
	    //outputs the zipcode if it's a zicode of a place, inputs nothing if not, and exits with "00000" input 
	    while(!(zipinput.equals("00000"))){
	    	Scanner object = new Scanner(System.in);
		    
		    zipinput = object.nextLine(); 
		    
		    if ((LookupZip.lookupZip(places,zipinput).getZip()).equals("")&&!(zipinput.equals("00000"))){
		    	System.out.println("zipcode: "+zipinput);
		    	System.out.println("No such zipcode");
		    }
		    else if(!(zipinput.equals("00000"))) {
		    System.out.println("zipcode: "+zipinput);
		    System.out.println(LookupZip.lookupZip(places,zipinput));
		    }
		    else {
		    	System.out.println("zipcode: "+zipinput);
		    	System.out.println("Good Bye!");
		    }
	    
	  }
	}

}

/** Creates a Place with the given zip, town name, and
 *  state
 *  @param inputzip The 5-digit zip code
 *  @param inputtown The town name
 *  @param inputstate The state abbreviation
 */

class Place {
	private String zip;
	private String state;
	private String town;
	
	public Place(String inputzip,String inputstate, String inputtown){
		this.zip=inputzip;
		this.state=inputstate;
		this.town=inputtown;
	}
	public String getZip()
	{
	    return this.zip;
	}
	public String getState()
	{
	    return this.state;
	}
	public String getTown()
	{
	    return this.town;
	}
	public String toString() {
		if(state.length()<town.length())
			return town+", "+state;
		else 
			return state+", "+town;
	}
	
	
	
	
	
}
// a collection of methods search for zipcodes of places 


class LookupZip{
	/** Find a Place with a given zip code
	 *  @param zip The zip code (as a String) to look up
	 *  @return A place that matches the given zip code,
	 *  or null if no such place exists.
	 */
	
	public static Place lookupZip(Place[] inputplaces, String inputzip){
		int lineNumber=0;
		String zip= inputzip;
		Place[] place= inputplaces;
		Place nozip= new Place("","","");
		while (lineNumber< place.length) {
			String pulledzip = place[lineNumber].getZip();
			if (pulledzip.equals(zip)){
				return  place[lineNumber];
			}
			else {
				lineNumber=lineNumber+1;
			}
		}
		return nozip;
		
	}
	
	/** Parses one line of input by creating a Place that
     *  denotes the information in the given line
     *  @param lineNumber The line number of this line
     *  @param line One line from the zipcodes file
     *  @return A Place that contains the relevant information
     *  (zip code, town, state) from that line
     */
	
	public static Place parseLine(int inputlineNumber, String inputline){
		String line= new String(inputline);
		String delims = "[,]";
		String[] splitten = line.split(delims);
		Place value= new Place(splitten[0],splitten[1],splitten[2]);
		
		return value;
	}
	
	/** Reads a zipcodes file, parsing every line
     *  @param filename The name of the zipcodes file
     *  @return The array of Places representing all the
     *  data in the file.
     */
	
	public static Place[] readZipCodes(String inputfilename) {
		File filename= new File(inputfilename);
		Scanner placesraw= null;
		ArrayList<String> placelist = new ArrayList<String>();
		
		try {
			placesraw= new Scanner(filename);
			while(placesraw.hasNextLine()) {
				String data=new String(placesraw.nextLine());
				placelist.add(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Place[] places= new Place[placelist.size()-1];
		int index= 0;
		while(index<placelist.size()-1) {
			places[index]=LookupZip.parseLine(index,placelist.get(index+1));
			index= index+1;
		}
		return places;
	}
}
