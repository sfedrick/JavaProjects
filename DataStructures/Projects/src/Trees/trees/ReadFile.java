package homework6.trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



import java.lang.Math; 


public class ReadFile {
	private static double average=0.0;
	private static int linecounter=0;
	public static Candidate parseLine( String inputline){
		String line= new String(inputline);
		String delims = "[,]";
		String[] splitten = line.split(delims);
		Double percent=Double.parseDouble(splitten[2]);
		Candidate value= new Candidate(splitten[0],splitten[1],percent);
		return value;
		
	}
	
	public static void parseLine(String inputline, BinaryTree tree){
		
		Candidate value= parseLine(inputline);
		Boolean copycat=tree.contains(value);
		double old;
		if(copycat) {
				if(tree.peek(value) instanceof Candidate){
					old=((Candidate)(tree.peek(value))).getPercent();
					double average= (old+value.getPercent())/2;
					Candidate averaged= new Candidate(value.getName(),value.getfullName(),average);
					tree.update(averaged);
					
				}
				
			}
		else {
				tree.insert(value);
			}
	}
	


	
	
	
	
	
	
	public static BinaryTree readFile(String inputfilename) {
		File filename= new File(inputfilename);
		Scanner rawinput= null;
		BinaryTree tree = new BinaryTree();
		ArrayList<Candidate>list=new ArrayList<Candidate>();
		
		try {
			rawinput= new Scanner(filename);
			rawinput.nextLine();
			while(rawinput.hasNextLine()) {
				String data=new String(rawinput.nextLine());
				Candidate value=parseLine(data);
				list.add(value);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Candidate runner: list) {
			tree.insert(runner);
		}
		 
		return tree;
		
		
		
	}
	public static void readFile(ArrayList<String> inputfilename,BinaryTree tree) {
		Scanner rawinput= null;
		
		for(String file: inputfilename) {
			File filename= new File(file);
			
			
			try {
				rawinput= new Scanner(filename);
				rawinput.nextLine();
				while(rawinput.hasNextLine()) {
					String data=new String(rawinput.nextLine());
					ReadFile.parseLine(data,tree);
					
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
