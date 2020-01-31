package lab2.ArrayList;
import java.util.*;
class Mammal {
private String  name;
private String sound;
	public Mammal(String inputname,String inputsound) {
		name=inputname;
		sound=inputsound;
		
	}
	public void speak() {
		System.out.println(sound);
	}
	public boolean laysEggs() {
		return false;
	}
	public boolean livesInWater(){
		return false;
	}
	public String getName() {
		return name;
	}
	public String getSound() {
		return sound;
	}
	public String toString() {
			return name+", "+sound;
	}
	
}
