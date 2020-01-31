package homework9.pictures;

import java.io.FileNotFoundException;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		try {
			Pixel[][] tester = Read.readFile("/Users/thedude/Desktop/prinzipal.ppm"); 
			
			
			Pixel[][] simple = new Pixel[11][11]; 
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
			Quadtree tree= new Quadtree(tester,0.002,50,false);
			Read.writeFile("written",tree.getImage());
			
			
		}
		catch(FileNotFoundException e) {
			
		}
		
		
		
		
	}
}
