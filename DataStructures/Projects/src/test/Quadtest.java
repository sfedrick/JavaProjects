package test;



public class Quadtest {
	
	public static Pixel meanColor(int colLeft,int colRight,int rowLeft,int rowRight, Pixel[][] image) {
	    int redCount = 0;
	    int greenCount = 0;
	    int blueCount = 0;
	    int pixelCount = 0;
	    
	    int widthMin = colLeft;
	    int widthMax = colRight;
	    int heightMin = rowLeft;
	    int heightMax = rowRight;
	    
	    for (int i=heightMin; i<=heightMax; i++) {
		for (int j=widthMin; j<=widthMax; j++) {
		    Pixel pix = image[i][j];
		    redCount += pix.getRed();
		    greenCount += pix.getGreen();
		    blueCount += pix.getBlue();
		    pixelCount++;
		}
	    }
	    
	    //Calculate the averages
	    //if (pixelCount != 0) {
		int avgRed = redCount/pixelCount;
		int avgGreen = greenCount/pixelCount;
		int avgBlue = blueCount/pixelCount;
		//  }
	    
		//int avgRed = 0;
		//int avgGreen = 0;
		//int avgBlue = 0;
	    
	    //Create and return a pixel
	    Pixel avg = new Pixel(avgRed, avgGreen, avgBlue);
	    
	    return avg;
	}

	public static double error(Pixel average,int colLeft,int colRight,int rowLeft,int rowRight, Pixel[][] image) {
	    Pixel avgColor = average;
	    int nodeR = avgColor.getRed();
	    int nodeG = avgColor.getGreen();
	    int nodeB = avgColor.getBlue();
	    int widthMin = colLeft;
	    int widthMax = colRight;
	    int heightMin = rowLeft;
	    int heightMax = rowRight;
	    int r = 0;
	    int g = 0;
	    int b = 0;
	    
	    int errorCount = 0;
	    int pixelCount = 0;
	    for (int i=heightMin; i<=heightMax; i++) {
	    	for (int j=widthMin; j<=widthMax; j++) {
			    Pixel pix = image[i][j];
			    r = pix.getRed();
			    g = pix.getGreen();
			    b = pix.getBlue();
			    
			    //Calculate error
			    double error = (r-nodeR)*(r-nodeR) + (g-nodeG)*(g-nodeG) +(b-nodeB)*(b-nodeB);
			    errorCount+= error;
			    
			    
			    pixelCount++;
			   
	    	}
	    }
	    double pixels = (double) pixelCount*pixelCount;
	   
	    double avgError = errorCount/pixels;
	    return avgError;
	}
}
