package lab9.hashtables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



import java.lang.Math; 


public class Read{
	private static double average=0.0;
	private static int linecounter=0;
	public static String parseLine( String inputline){
		String line= new String(inputline);
		//String delims = "[]";
		//String[] splitten = line.split(delims);
		String splitten= line;
		String value= splitten;
		return value;
		
	}

	
	public static ArrayList<String> readFile(String inputfilename) {
		File filename= new File(inputfilename);
		Scanner rawinput= null;
		ArrayList<String> output = new ArrayList();
		
		try {
			rawinput= new Scanner(filename);
			while(rawinput.hasNextLine()) {
				String data=new String(rawinput.nextLine());
				String value=parseLine(data);
				output.add(value);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
		
	}
	
	
}