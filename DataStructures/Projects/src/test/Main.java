package test;

import java.util.*;
import java.util.regex.*;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		try {
		Pixel[][] simple = new Pixel[11][11]; 
		Pixel[][] tester = Read.readFile("/Users/thedude/Desktop/testimage.ppm"); 
		for (int i=0 ; i<simple.length; i++) {
			for (int j=0; j<simple[0].length; j++) {
				if(j%2==0) {
					Pixel pix = new Pixel(0,0,0);
					simple[i][j]=pix;
				}
				else {
					Pixel pix = new Pixel(255,255,255);
					simple[i][j]=pix;
				}
			    
			    
				}
		    }
		
		Pixel average= Quadtest.meanColor(0,10,0,10, tester);
		
		
		System.out.println(average);
		Quadtest.error(average,0,3,0,3, simple);
		System.out.print(Quadtest.error(average,0,1,0,0, simple));
		}
		catch(FileNotFoundException e) {
			
		}
	}
	
}
