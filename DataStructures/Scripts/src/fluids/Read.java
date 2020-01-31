package fluids;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.io.*; 


public class Read {

	public static ArrayList<String> file (String file,int skip,int filenumber) {
		
		Scanner rawinput= null;
		ArrayList<String> numbers = new ArrayList<String>();
		
		for (int i = 1; i <= filenumber; i++) {
			String num= String.valueOf(i);
			String newfile=file+num+".csv";
			try {
			FileInputStream filename= new FileInputStream(newfile); 
			rawinput= new Scanner(filename);
			int count=0;
			while(rawinput.hasNextLine()) {
				if(count<skip) {
					count++;
					rawinput.nextLine();
				}
				else {
					String newdata=new String(rawinput.nextLine());
					newdata=newdata.replaceAll("\"", "");
					numbers.add(newdata);
				}
			}
			
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(" You file path is wrong");
				
			}
			rawinput.close();
			
		}
		
		return numbers;
	}
	
	
	public static void write(ArrayList<String> bigboi, String filelocation) {
		try {
		FileWriter csvWriter = new FileWriter(filelocation);
		
		for ( String data : bigboi) {
		    csvWriter.append(data);
		    csvWriter.append("\n");
		}
		csvWriter.flush();
		csvWriter.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" You write path is wrong");
			
		}
	}
	
	
	
	
	
	
	
}
