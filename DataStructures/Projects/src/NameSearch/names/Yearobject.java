package homework3.names;

public class Yearobject {
	private int year;
	private int data;
	private float percent;
	private Boolean girl;
	private String name;
	public Yearobject(int yearinit,int datainit) {
		year=yearinit;
		data=datainit;
	}
	public Yearobject(int yearinit,float datainit) {
		year=yearinit;
		percent=datainit;
	}
	
	public Yearobject(Boolean gender,String inputfile) {
		girl=gender;
		name=inputfile;
	}
	
	
	
	public int getYear() {
		return year;
	}
	public int getData() {
		return data;
	}
	
	public Boolean getGirl() {
		return girl;
	}
	public String getName() {
		return name;
	}
	
	public float getPercent() {
		return percent;
	}
	public void setYear(int setyear) {
		year=setyear;
	}
	public void setData(int setdata) {
		data=setdata;
	}
	
	

}
