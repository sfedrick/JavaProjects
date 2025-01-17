package homework2.zipcodecontinued;

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
	

	public static PopulatedPlace lookupZip(PopulatedPlace[] inputplaces, String inputzip){
		int lineNumber=0;
		String zip= inputzip;
		PopulatedPlace[] place= inputplaces;
		PopulatedPlace nozip= new PopulatedPlace("","","","","","");
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
	
	public static Integer lookupZip(PopulatedPlace[] place,PopulatedPlace inputzip){
		int lineNumber=0;
		String zip= inputzip.getZip();
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
	
	public static PopulatedPlace parseLine(int inputlineNumber, String inputline, PopulatedPlace[] places){
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
	
	public static PopulatedPlace[] readZipCodes(String inputfilename) {
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
		PopulatedPlace[] places= new PopulatedPlace[placelist.size()-1];
		int index= 0;
		while(index<placelist.size()-1) {
			places[index]=LookupZip.parseLine(index,placelist.get(index+1));
			index= index+1;
		}
		return places;
	}
	
	public static PopulatedPlace[] readZipCodes(String inputfilename,String inputfilename2) {
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
		
		
		
		PopulatedPlace[] places= new PopulatedPlace[placelist.size()-1];
		int index= 0;
		while(index<placelist.size()-1) {
			places[index]=LookupZip.parseLine(index,placelist.get(index+1));
			index= index+1;
		}
		int index2=0;
		while(index2<placelist2.size()-1) {
			PopulatedPlace unknown=LookupZip.parseLine(index,placelist2.get(index2+1),places);
			int linenumber=LookupZip.lookupZip(places,unknown);
			places[linenumber]=unknown;
			index2= index2+1;
		}
		return places;
		
		
	}
	
	
	
		
	
	
	
}
			
		


