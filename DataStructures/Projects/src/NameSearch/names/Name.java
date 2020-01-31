package homework3.names;
import java.util.ArrayList;

public class Name {
	/*
	 * INIT
	 */
	//must use this after the creation of any new name object
	//initializes each array so that the first element is set up to be total
	String name;
	private ArrayList<Yearobject> rank= new ArrayList<Yearobject> (); 
	private ArrayList<Yearobject> yearlypercentage= new ArrayList<Yearobject> (); 
	private ArrayList<Yearobject> yearlytotal= new ArrayList<Yearobject> ();
	
	private int rankinit;
	private int yearinit;
	private int initammount;
	private Boolean girl;
	public Name(String name,int ammount,int rank,int year,Boolean gender){
		this.name= name;
		girl=gender;
		yearinit=year;
		initammount=ammount;
		rankinit=rank;
		this.initarrays();
	}
	
	
	public void initarrays(){
		Yearobject rank0= new Yearobject(yearinit,rankinit);
		Yearobject placeholder=new Yearobject(-1,0);
		Yearobject yearpercent0= placeholder;
		Yearobject yeartotal0= new Yearobject(yearinit,initammount);
		Yearobject totalrank= new Yearobject(0,rankinit);
		Yearobject totalyear= new Yearobject(0,initammount);
		Yearobject totalyearpercent= new Yearobject(0,0);
		rank.add(totalrank);
		yearlypercentage.add(totalyearpercent);
		yearlytotal.add(totalyear);
		rank.add(rank0);
		yearlypercentage.add(yearpercent0);
		yearlytotal.add(yeartotal0);
		
	}
	
	
	//methods to updates name if there is another file 
	/*UPDATE
	 *  Update which is a general update that adds new year data
	 * update total which updates the total time the name shows up in all files
	 * update rank which updates rank using linked list
	 * update percent total using linked list
	 */
	public void update(int newammount,int newrank,int newyear){
		//adds a new total of the name for that year
		Yearobject yeartotaladd= new Yearobject(newyear,newammount);
		yearlytotal.add(yeartotaladd);
		//updates total number of times the name has been used in all years
		Yearobject totalyear= updateTotalyear();
		yearlytotal.set(0, totalyear);
		//adds new rank
		Yearobject rankadd= new Yearobject(newyear,newrank);
		rank.add(rankadd);
		
		Yearobject placeholder=new Yearobject(-1,0);
		Yearobject yearpercentadd=placeholder;
		yearlypercentage.add(yearpercentadd);
		
	}
	
	public Yearobject updateTotalyear() {
		int last=yearlytotal.size()-1;
		int total=yearlytotal.get(0).getData()+yearlytotal.get(last).getData();
		Yearobject updatetotalyear=new Yearobject(0,total);
		return updatetotalyear;
	
	}
	public Yearobject findpercent(int newammount,int newyear) {
		Boolean found=false;
		
		float denom=0;
		if(girl) {
			while(!found) {
			for(Yearobject x: Read.getTotalnamesgirl()) {
				
				 if(x.getYear()==newyear) {
					 
					 denom=x.getData();
					 found=true;
				 }
				 
			}
			
			}
		}
		else {
			while(!found) {
				for(Yearobject x: Read.getTotalnamesboy()) {
					 if(x.getYear()==newyear) {
						 denom=x.getData();
						 found=true;
					 }
					 
				}
				
				}
			
		}
		float percent=newammount/denom;
		
		Yearobject value=new Yearobject(newyear,percent);
		return value;
	}
	
	public Yearobject updateTotalrank(NameDLL list) {
		int total=getTotalYearlytotal().getData();
		int rankfinal=list.Rank(total);
		Yearobject ranking= new Yearobject(0,rankfinal);
		return ranking;
		
		
	}
	
	
	public Yearobject updateTotalyearpercentage() {
		//call linked list to find
		ArrayList<Yearobject> years_percent=new ArrayList<Yearobject>();
		int value=0;
		if(girl) {
			
			Yearobject x=Read.getTotalnamesgirl().get(rank.size()-2);
			value=value+x.getData();

			
		}
		else {
			Yearobject x=Read.getTotalnamesboy().get(rank.size()-2);
			value=value+x.getData();
			
		}
		
		int total=getTotalYearlytotal().getData();
		
		
		float totalpercent=(float)total/value;
		
		Yearobject yearpercentadd= new Yearobject(0,totalpercent);
		return yearpercentadd;
		
	}
	
	
	
	
	//GETTERS
	public String getName() {
		return name;
		
	}
	public ArrayList<Yearobject> getRank() {
		return rank;
		
	}
	public ArrayList<Yearobject> getYearlytotal() {
		return yearlytotal;
		
	}
	public ArrayList<Yearobject> getYearlypercentage() {
		setYearlypercent();
		return yearlypercentage;
		
	}
	public Yearobject getTotalRank(NameDLL list) {
		setTotalRank(list);
		return rank.get(0);
		
	}
	public Yearobject getTotalYearlypercentage() {
		yearlypercentage.set(0,updateTotalyearpercentage());
		return yearlypercentage.get(0);
		
	}
	public Yearobject getTotalYearlytotal() {
		return yearlytotal.get(0);
		
	}
	public String toString(NameDLL list) {
		
		String start="";
		
		String ranktotal=Integer.toString(getTotalRank(list).getData());
		String yearlytotalstring=Integer.toString(getTotalYearlytotal().getData());
		String yearlypercentstring=Float.toString(getTotalYearlypercentage().getPercent());
		String output= new String("Total"+"\n"+name+": "+ranktotal+", "+yearlytotalstring+","+yearlypercentstring);
		for(int i = 1; i < rank.size(); i++){
			Yearobject pullstring1= rank.get(i);
			Yearobject pullstring2= yearlytotal.get(i);
			Yearobject pullstring3= getYearlypercentage().get(i);
			String addstring1=Integer.toString(pullstring1.getYear());
			String addstring2=Integer.toString(pullstring1.getData());
			String addstring3=Integer.toString(pullstring2.getData());
			String addstring4=Float.toString(pullstring3.getPercent());
			start= new String(start+addstring1+"\n"+name+": "+addstring2+", "+addstring3+","+addstring4+"\n");
		}
		return start+output;
	}
	
	//Setters
	public void setTotalRank(NameDLL list) {
		rank.set(0,updateTotalrank(list));
		
	}
	
	public void setYearlypercent(){
		for(int i = 1; i < yearlytotal.size(); i++) {
			int year=yearlytotal.get(i).getYear();
			int ammount=yearlytotal.get(i).getData();
			Yearobject update=findpercent(ammount,year);
			yearlypercentage.set(i, update);
			
		}
	}
	
	
}

