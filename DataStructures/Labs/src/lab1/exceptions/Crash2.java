package lab1.exceptions;
import java.util.*;
public class Crash2 {
	public static void main(String[] args) { 
		 
		while (true) {
			Scanner in = new Scanner(System.in);
			try {
			System.out.print("Enter a number: "); String line = in.nextLine();
			int data = Integer.parseInt(line);
			System.out.println("Square root of " + data + " is " + Math.sqrt(data));
			}
			catch(NumberFormatException e) {
				System.out.println("That's not a number!");
			}
		}
	} // main()
}
