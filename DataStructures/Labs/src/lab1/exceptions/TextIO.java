package lab1.exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextIO {
	public static void main(String[] args)throws FileNotFoundException {
		String inFileName = "//Users//thedude//javaprograms//Labs//Lab1/data//LiamNeeson.txt"; 
		Scanner input;
		String line;
	
			input = new Scanner(new File(inFileName));
			while (input.hasNextLine()) {
				line = input.nextLine();
				System.out.println(line);}
			
		
		
	}
}
