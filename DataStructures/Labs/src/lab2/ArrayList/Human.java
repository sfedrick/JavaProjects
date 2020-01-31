package lab2.ArrayList;
import java.util.*;
class Human extends Mammal{
	String namehuman;
	String soundhuman;
	
	public Human(String inputname,String inputsound) {
		super(inputname,inputsound);
		
		
		
	}
	public String getName() {
		return "human";
	}
	public void speak() {
		System.out.println("I'll	take	a	grande	latte	with	a	double-shot	of	espresso");
	}
	
}
