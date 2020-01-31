package lab3.LinkedList;
import java.util.*;

public class City {
	private String city;
	private int population;
	public City(String city,int population) {
		this.city=city;
		this.population=population;
	}
	public String getCity() {
		return this.city;
	}
	public int getPopulation() {
		return this.population;
	}
	public String toString() {
		
		return city ;
    }

}
