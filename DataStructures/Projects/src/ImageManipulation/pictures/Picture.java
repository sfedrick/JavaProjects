package homework9.pictures;

import java.io.FileNotFoundException;

public class Picture {
	private Pixel[][] picture;
	private Pixel[][] compressed;
	private String picfile;
	public Picture(String picfile) {
		try {
			picture= Read.readFile(picfile);
		}
		catch(FileNotFoundException e) {
			System.out.println("the file was not found please check that the file is in the correct format and it exists");
		}
		
		
	}
	public Pixel[][] getArray(){
		return picture;
	}
	
}
