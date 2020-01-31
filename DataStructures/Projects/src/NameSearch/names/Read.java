package homework3.names;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Read {
	
	private static ArrayList<Yearobject> totalnamesgirl=new ArrayList<Yearobject>();
	private static ArrayList<Yearobject> totalnamesboy=new ArrayList<Yearobject>();
	
	public static ArrayList<Yearobject> getTotalnamesgirl(){
		return totalnamesgirl;
	}
	public static ArrayList<Yearobject> getTotalnamesboy(){
		return totalnamesboy;
	}
	//Use this if there is only one file 
	public static void file (String file,NameDLL oldlistgirl,NameDLL oldlistboy,int onefile) {
		//grabs the year out of the file and casts it as an int
		//finds year from file name 
		//you may get a numberformat exception if you do not have the file in the format
		//names *(year)* .csv
		String[] filesplit = file.split("/");
		int size=filesplit.length-1;
		String targetfile=filesplit[size];
		String yearstring=targetfile.substring(5,9);
		int year=Integer.parseInt(yearstring);
		
		
		//reads in file and sends each line to an array list of Strings 
		File filename= new File(file);
		Scanner namesraw= null;
		ArrayList<String> namestrings = new ArrayList<String>();
		try {
			namesraw= new Scanner(filename);
			while(namesraw.hasNextLine()) {
				String data=new String(namesraw.nextLine());
				namestrings.add(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NameDLL list=new NameDLL();
		//checks if the file is reading into a boy or girl list
		int sumgirl=0;
		int sumboy=0;
		for(String x: namestrings) {
			Yearobject sumtotalgirl;
			Yearobject sumtotalboy;
			Name newname= parsegirl(x,year);
			sumtotalgirl=newname.getYearlytotal().get(1);
			sumgirl=sumtotalgirl.getData()+sumgirl;
			oldlistgirl.insertsorted(newname);
			newname= parseboy(x,year);
			sumtotalboy=newname.getYearlytotal().get(1);
			sumboy=sumtotalboy.getData()+sumboy;
			oldlistboy.insertsorted(newname);
				
			}
		
		Yearobject sumtotalofallnamesgirl=new Yearobject(year,sumgirl);
		Yearobject sumtotalofallnamesboy=new Yearobject(year,sumboy);
		
		Read.totalnamesgirl.add(sumtotalofallnamesgirl);
		sumboy=0;
		Read.totalnamesboy.add(sumtotalofallnamesboy);	
		sumgirl=0;
		
		
		
	}
	
	
	//Use this if there is more than one file 
	public static void file (String file,NameDLL oldlistgirl,NameDLL oldlistboy) {
		//finds year from file name 
		//you may get a numberformat exception if you do not have the file in the format
		//names *(year)* .csv
		String[] filesplit = file.split("/");
		int size=filesplit.length-1;
		String targetfile=filesplit[size];
		String yearstring=targetfile.substring(5,9);
		int year=Integer.parseInt(yearstring);
		
		//reads in file and sends it to string Array list
		File filename= new File(file);
		Scanner namesraw= null;
		ArrayList<String> namestrings = new ArrayList<String>();
		try {
			namesraw= new Scanner(filename);
			while(namesraw.hasNextLine()) {
				String data=new String(namesraw.nextLine());
				namestrings.add(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int sumgirl=0;
		int sumboy=0;
		for(String x: namestrings) {
				Yearobject sumtotalgirl;
				Yearobject sumtotalboy;
				
		//checks if we are reading into a girl or boy file
			
				//checks if the name is already in  the old list  
				// if so it updates the name 
				//else it adds a new name
				Name newname= parsegirl(x,year);
				String id= newname.getName();
				sumtotalgirl=newname.getYearlytotal().get(1);
				sumgirl=sumtotalgirl.getData()+sumgirl;
				String find;
				try {
					find=oldlistgirl.find(id).getName();
				}
				catch(java.lang.NullPointerException e) {
					find=null;
				}
				if (find==null){
					
					oldlistgirl.insertsorted(newname);
				}
				else {
					int ammount = newname.getYearlytotal().get(1).getData();
					int rank = newname.getRank().get(1).getData();
					oldlistgirl.find(id).update(ammount,rank,year);
				}
		
				newname= parseboy(x,year);
				id= newname.getName();
				sumtotalboy=newname.getYearlytotal().get(1);
				sumboy=sumtotalboy.getData()+sumboy;
				try {
					find=oldlistboy.find(id).getName();
				}
				catch(java.lang.NullPointerException e) {
					find=null;
				}
				if (find==null){
					
					oldlistboy.insertsorted(newname);
				}
				else {
					//int newammount,int newrank,int newyear
					int ammount = newname.getYearlytotal().get(1).getData();
					int rank = newname.getRank().get(1).getData();
					oldlistboy.find(id).update(ammount,rank,year);
				}
				
			}
		
		Yearobject sumtotalofallnamesgirl=new Yearobject(year,sumgirl);
		Yearobject sumtotalofallnamesboy=new Yearobject(year,sumboy);
	
		Read.totalnamesgirl.add(sumtotalofallnamesgirl);
		sumgirl=0;
			
		Read.totalnamesboy.add(sumtotalofallnamesboy);	
		sumboy=0;
			
		
		
	}

//parses a line in the file for inputing into a boy list 
	public static Name parseboy(String boyfile,int year) {
		String[] output = boyfile.split(",");
		//Name(String name,int ammount,int rank,int year)
		int ammount=Integer.parseInt(output[2]);
		int rank=Integer.parseInt(output[0]);
		Name boy= new Name(output[1],ammount,rank,year,false);
		return boy;
		
		
		
	}
//parses a line in the file for inputing into a girl list 
	public static Name parsegirl(String girlfile, int year) {
		String[] output = girlfile.split(",");
		//Name(String name,int ammount,int rank,int year)
		int ammount=Integer.parseInt(output[4]);
		int rank=Integer.parseInt(output[0]);
		Name girl= new Name(output[3],ammount,rank,year,true);
		return girl;
		
	}
	
	
	
}
