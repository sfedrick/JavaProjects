package homework6.trees;
import java.util.*;


public class Candidate implements Comparable<Candidate>{
	private String name;
	private String fullname;
	private double percent;


		public Candidate(String name,String fullname,double percent) {
			this.name=name;
			this.fullname=fullname;
			this.percent=percent;
		}
		
		public String getName(){
			return name;
		}
		public String getfullName(){
			return fullname;
		}
		public double getPercent() {
			return percent;
		}
		
		
		public int compareTo(Candidate input) {
		
			if(this.getName().compareToIgnoreCase(input.getName())>0) {
				return 1;
			}
			else if(this.getName().compareToIgnoreCase(input.getName())<0){
				return -1;
			}
			else {
				return 0;
			}
		
			
				
			
		}
		
		
		public String toString() {
			String answer;
			answer=name+" "+percent+" ";
			return answer;
		}
	

}
