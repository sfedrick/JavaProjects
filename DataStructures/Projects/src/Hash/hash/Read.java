package homework8.hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*; 

public class Read {
private static double average=0.0;
private static int linecounter=0;
	public static person parseLine( String inputline){
		String line= new String(inputline);
		Pattern MY_PATTERN = Pattern.compile("\"(.*?)\"");
		Matcher matcher = MY_PATTERN.matcher(line);
		while(matcher.find()) {
			
			String found1=matcher.group();
			String found= found1.replace(',', '\b');
			found= found.replace('\"', '\b');
			line=line.replace(found1,found);
		}
		String delims = ",";
		String[] splitten = line.split(delims);
		int i=0;
		
		
		int age=0;
		int weight=0;
		String sex=" ";
		String race=" ";
		String dob=" ";
		String height=" ";
		String haircolor=" ";
		String eyecolor=" ";
		String build=" ";
		
		
		try {
			sex=splitten[81-1];
			race=splitten[82-1];
			dob=splitten[83-1];
			height=splitten[85-1]+splitten[86-1];
			haircolor=splitten[88-1];
			eyecolor=splitten[89-1];
			build=splitten[90-1];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		
		try {
			age=Integer.parseInt(splitten[84-1]);
			weight=Integer.parseInt(splitten[87-1]);
		}
		catch(NumberFormatException e ) {
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		
		person value= new person(sex,race,dob,age,height,weight,haircolor,eyecolor,build);
		return value;
		
	}

	
	public static ArrayList<Comparable<person>> readFile(String inputfilename) throws FileNotFoundException{
		ArrayList<Comparable<person>> output = new ArrayList();
		
		try {
		FileInputStream filename= new FileInputStream(inputfilename); 
		Scanner rawinput= null;
		
		
			rawinput= new Scanner(filename);
			rawinput.nextLine();
			int i=0;
			while(rawinput.hasNextLine()) {
				i++;
				String data=new String(rawinput.nextLine());
				person value=parseLine(data);
				output.add(value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public static ArrayList<Comparable<person>> readFile(String inputfilename, int lines) throws FileNotFoundException{
		ArrayList<Comparable<person>> output = new ArrayList();
		
		try {
		FileInputStream filename= new FileInputStream(inputfilename); 
		Scanner rawinput= null;
		
		
			rawinput= new Scanner(filename);
			rawinput.nextLine();
			int i=0;
			while(rawinput.hasNextLine()&& i<=lines) {
				i++;
				String data=new String(rawinput.nextLine());
				person value=parseLine(data);
				output.add(value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
		
	}
	
	public static ArrayList<person> readFile2(String inputfilename) throws FileNotFoundException {
		ArrayList<person> output = new ArrayList();
		
		try {
		FileInputStream filename= new FileInputStream(inputfilename); 
		Scanner rawinput= null;
		
		
			rawinput= new Scanner(filename);
			rawinput.nextLine();
			int i=0;
			while(rawinput.hasNextLine()) {
				i++;
				String data=new String(rawinput.nextLine());
				person value=parseLine(data);
				output.add(value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	
	
public static ArrayList<person> readFile2(String inputfilename, int lines) throws FileNotFoundException{
		ArrayList<person> output = new ArrayList();
		
		try {
		FileInputStream filename= new FileInputStream(inputfilename); 
		Scanner rawinput= null;
		
		
			rawinput= new Scanner(filename);
			rawinput.nextLine();
			int i=0;
			while(rawinput.hasNextLine()&& i<=lines) {
				i++;
				String data=new String(rawinput.nextLine());
				person value=parseLine(data);
				output.add(value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
