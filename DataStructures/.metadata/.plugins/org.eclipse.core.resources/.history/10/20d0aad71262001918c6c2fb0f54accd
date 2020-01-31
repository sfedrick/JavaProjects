package homework8.hash;
import java.util.*;

public class person implements Comparable<person>{
private String sex;
private String race;
private String dob;
private int age;
private String height;
private int weight;
private String haircolor; 
private String eyecolor;
private String  build;
private String id;
 public person(String sex,String race,String dob, int age,String height,int weight,String haircolor,String eyecolor,String  build){
	 this.sex=sex;
	 this.race=race;
	 this.dob=dob;
	 this.age=age;
	 this.height=height;
	 this.weight=weight;
	 this.haircolor=haircolor; 
	 this.eyecolor=eyecolor;
	 this.build=build;
	 id= sex+race+dob+age+height+weight+haircolor+eyecolor+build;
 }
 public String getSex() {
	 return sex;
 }
 public String getRace() {
	 return race;
 }
 public String getDob(){
	 return dob;
 }
 public int age() {
	 return age;
 }
 public String height() {
	 return height;
 }
 public int weight() {
	 return weight;
 }
 public String haircolor() {
	 return haircolor;
 }
 public String eyecolor() {
	 return eyecolor;
 }
 public String  build() {
	 return build;
 }
 public String getId() {
	 return id;
 }
 
 public int compareTo(person x){
	 if(x==null) {
		return -1; 
	 }
	 if(this.getId().equals(x.getId())) {
		 return 0;
	 }
	 else if(this.getId().compareTo(x.getId())<0) {
		 return -1;
	 }
	 else {
		 return 1; 
	 }
 }
 public String toString() {
	 return id;
 }
}
