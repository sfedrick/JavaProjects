package homework9.pictures;

public class Pixel {
	private int red;
	private int green;
	private int blue;
	
	public Pixel(int red,int green,int blue) {
		this.red=red;
		this.green=green;
		this.blue=blue;
		
	}
	public int getDifference(Pixel takeaway) {
		int rederror= ((this.getRed()-takeaway.getRed())*(this.getRed()-takeaway.getRed()));
		int blueerror= ((this.getBlue()-takeaway.getBlue())*(this.getBlue()-takeaway.getBlue()));
		int greenerror=((this.getGreen()-takeaway.getGreen())*(this.getGreen()-takeaway.getGreen()));
		return rederror+blueerror+greenerror;
	}
	public int getSquare() {
		int rederror= ((this.getRed())*(this.getRed()));
		int blueerror=  ((this.getBlue())*(this.getBlue()));
		int greenerror=((this.getGreen())*(this.getGreen()));
		return rederror+blueerror+greenerror;
	}
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public void setRed(int r) {
		red = r;
	}
	
	public void setGreen(int g) {
		green = g;
	}
	
	public void setBlue(int b) {
		blue = b;
	}
	public String toString() {
		String value= "red:"+ red+ " green: "+green +"blue: "+blue;
		return value;
	}
}
