package homework6.zipcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LookupZip {
	/** Find a Place with a given zip code
	 *  @param zip The zip code (as a String) to look up
	 *  @return A place that matches the given zip code,
	 *  or null if no such place exists.
	 */
	

	public static PopulatedPlace lookupZip(ArrayList<PopulatedPlace>inputplaces, String inputzip){
		
		int lineNumber=0;
		String zip= inputzip;
		ArrayList<PopulatedPlace>place= inputplaces;
		PopulatedPlace nozip= new PopulatedPlace("","","","","","");
		   
		if(inputplaces.size()==0) {
			return nozip;
		}
		
		int min=-1;
		int max=place.size();
		int mid=(min+max)/2;
		PopulatedPlace check=place.get(mid);
		/*
		 * Binary search when given a zipcode 
		 */
		while(!(max==min+1||max==min)) {
			//sets the new mid based on min and max
			mid=(max+min)/2;
			check=place.get(mid);
			
			if(check.compareTo(inputzip)==0) {
				//returns check the found value and resets the min and max value for another search
				min=-1;
				max=place.size();
				return check;	
				
			}
			else if(check.compareTo(inputzip)>0) {
				//changes the value of max because check (or current mid)is greater than input zip
				max=mid;
			}
			else if(check.compareTo(inputzip)<0){
				//changes the value of min because check (or current mid)is less than input zip
				min=mid;
			}
		 
			
		}
		
		return nozip;
		
		/* code from previous assignment
		
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
		*/
		
	}
	
	public static Integer lookupZip(ArrayList<PopulatedPlace>place,PopulatedPlace inputzip){
		int lineNumber=0;
		
		String zip= inputzip.getZip();
		
		PopulatedPlace nozip= new PopulatedPlace("","","","","","");
		                         
		int min=-1;
		int max=place.size();
		int mid=(min+max)/2;
		PopulatedPlace check=place.get(mid);
		
		/*
		 * Binary search when given a place
		 */
		
		while(!(max==min+1||max==min)) {
			//sets the new mid based on min and max
			mid=(max+min)/2;
			check=place.get(mid);
			
			if(check.compareTo(zip)==0) {
				//returns check the found value and resets the min and max value for another search
				min=-1;
				max=place.size();
				
				return mid;	
				
			}
			
			else if(check.compareTo(zip)>0) {
				//changes the value of max because check (or current mid)is greater than input zip
				max=mid;
			}
			else if(check.compareTo(zip)<0){
				//changes the value of min because check (or current mid)is less than input zip
				min=mid;
			}
			
		 
			
		}
		
		return -1;
		
		
		
		
		
		
		/* code from previous assignment
		
		while (lineNumber< place.length) {
			String pulledzip = place[lineNumber].getZip();
			if (pulledzip.equals(zip)){
				return  lineNumber;
			}
			else {
				lineNumber=lineNumber+1;
			}
		}
		return -1;
		*/
		
	}
	
	
	/** Parses one line of input by creating a Place that
     *  denotes the information in the given line
     *  @param lineNumber The line number of this line
     *  @param line One line from the zipcodes file
     *  @return A Place that contains the relevant information
     *  (zip code, town, state) from that line
     */
	
	public static PopulatedPlace parseLine(int inputlineNumber, String inputline){
		String line= new String(inputline);
		String delims = "[,]";
		String[] splitten = line.split(delims);
		try {
			PopulatedPlace value= new PopulatedPlace(splitten[0],splitten[1],splitten[2],"","",splitten[3]);
			return value;
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e) {
			PopulatedPlace value= new PopulatedPlace(splitten[0],splitten[1],splitten[2],"","","");
			return value;
		}
		
		
	}
	
	public static PopulatedPlace parseLine(int inputlineNumber, String inputline, ArrayList<PopulatedPlace>places){
		String line= new String(inputline);
		int n=0;
		String delims = "[,]";
		String[] splittendirty = line.split(delims);
		String[] splitten = new String[splittendirty.length];
		for(String i:splittendirty) {
			String clean=i.replace("\"", "");
			splitten[n]=clean;
			n=n+1;
			
			
		}
	
			PopulatedPlace copy= LookupZip.lookupZip(places,splitten[0]);
			if(copy.getPopulation() != null && !copy.getPopulation().isEmpty()) {
				PopulatedPlace value= new PopulatedPlace(splitten[0],splitten[2],splitten[3],splitten[5],splitten[6],copy.getPopulation());
				return value;
			}
			else {
				PopulatedPlace value= new PopulatedPlace(splitten[0],splitten[2],splitten[3],splitten[5],splitten[6],"");
				return value;
			}
	}
	
	
	
	
	
	
	/** Reads a zipcodes file, parsing every line
     *  @param filename The name of the zipcodes file
     *  @return The array of Places representing all the
     *  data in the file.
     */
	
	public static ArrayList<PopulatedPlace>readZipCodes(String inputfilename) {
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
		ArrayList<PopulatedPlace>places= new ArrayList(placelist.size()-1);
		int index= 0;
		while(index<placelist.size()-1) {
			places.set(index,LookupZip.parseLine(index,placelist.get(index+1)));
			index= index+1;
		}
		return places;
	}
	
	public static ArrayList<PopulatedPlace>readZipCodes(String inputfilename,String inputfilename2) {
		File filename= new File(inputfilename);
		File filename2= new File(inputfilename2);
		Scanner placesraw= null;
		Scanner placesraw2= null;
		ArrayList<String> placelist = new ArrayList<String>();
		ArrayList<String> placelist2 = new ArrayList<String>();
		try {
			placesraw= new Scanner(filename);
			placesraw2= new Scanner(filename2);
			while(placesraw.hasNextLine()) {
				String data=new String(placesraw.nextLine());
				placelist.add(data);
			}
			while(placesraw2.hasNextLine()) {
				String data=new String(placesraw2.nextLine());
				placelist2.add(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ArrayList<PopulatedPlace>places= new ArrayList(placelist.size()-1);
		int index= 0;
		while(index<placelist.size()-1) {
			places.add(LookupZip.parseLine(index,placelist.get(index+1)));
			index= index+1;
		}
		int index2=0;
		while(index2<placelist2.size()-1) {
			PopulatedPlace unknown=LookupZip.parseLine(index,placelist2.get(index2+1),places);
			int linenumber=LookupZip.lookupZip(places,unknown);
			
			places.set(linenumber,unknown);
			
			index2= index2+1;
		}
		return places;
		
		
	}
	
	
	
		
	
	
	
}
			
		


