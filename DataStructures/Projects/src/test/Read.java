package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Read {
	
	
	public static Pixel[][] readFile(String inputfilename) throws FileNotFoundException {
		Pixel[][] output;
		try {
		FileInputStream filename= new FileInputStream(inputfilename); 
		Scanner rawinput= null;
			rawinput= new Scanner(filename);
			rawinput.next();
			int i=0;
			int j=0;
			int row;
			int col;
			while (!rawinput.hasNextInt()) rawinput.next();
			row=rawinput.nextInt();
			col=rawinput.nextInt();
			int colorcode=rawinput.nextInt();
			System.out.println("this is my row:"+row);
			System.out.println("this is my row:"+col);
			output = new Pixel[row][col];
			
			while(rawinput.hasNext()) {
				if (rawinput.hasNextInt()) {
					int red=rawinput.nextInt();
					if(rawinput.hasNextInt()) {
						if(rawinput.hasNextInt()) {
							int green=rawinput.nextInt();
							if(rawinput.hasNextInt()) {
								int blue=rawinput.nextInt();
								output[i][j]=new Pixel(red,green,blue);
							}
							else {
								System.out.println("something went wrong");
							}
						}
						else {
							System.out.println("something went wrong");
						}
					}
					else{
						System.out.println("something went wrong");
					}
		         }
				
				if(j<col-1) {
					j++;
				}
				else if(i<row-1) {
					j=0;
					i++;
				}
				else {
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output=new Pixel[1][1];
		}
		return output;
	}
	
	public static void writeFile(String name,Pixel[][] picture) {
		try {
		PrintWriter out = new PrintWriter(name+".ppm"); out.print("P3 ");
		out.println(picture.length+ " " +picture[0].length+ " 255"); 
		 for (int i=0; i<picture.length; i++) { 
			 for (int j=0; j<picture[0].length; j++) {
			 out.print(picture[i][j].getRed()+" "+ picture[i][j].getGreen()+" "+ picture[i][j].getBlue()+" ");
			 }
			 out.println(); 
		}
		 out.close();
		}
		catch(IOException e) {
			System.out.println("something is wrong");
			
		}
	}
}
