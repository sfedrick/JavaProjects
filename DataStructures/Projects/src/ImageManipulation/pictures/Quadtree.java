/*
 * File: Quadtree.java
 * Desc:
 *
 *
 */
package homework9.pictures;
import java.util.*;
import java.lang.Math;

public class Quadtree {
    private Node root;
    private Pixel[][] image;
    private int width; //Number of columns
    private int height; //Number of rows
    private double compression;
    private int threshold;
    private int size = 1;
    private boolean outline;
    private int leafCount = 1;
    private ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    
    
    public Quadtree(Pixel[][] image, double compression, int threshold,
		    boolean outline) {
	this.image = image;
	this.compression = compression;
	this.threshold = threshold;
	this.outline = outline;
	
	width = image[0].length-1;
	height = image.length-1;
	

	root = new Node(0, 0, width, height, null, null, null, null, null);

	//find avg color of root and add it into its node
	Pixel rootClr = root.meanColor();
	root.setColor(rootClr);

	//split until no more splitting is necessary, based on compression,
	//single pixel level, or error
	split();

	//if (outline==true) {
	//  outline();
	//}
    }

    public Pixel[][] getImage() {
	return image;
    }

    public int getLeafCount() {
	return leafCount;
    }
    
    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public void outline() {
	ArrayList<Leaf> leaves = getLeaves();
	Leaf leaf;
	int widthMin = 0;
	int widthMax = 0;
	int heightMin = 0;
	int heightMax = 0;
	
	for (int i=0; i<leaves.size(); i++) {
	    leaf = leaves.get(i);
	    widthMin = leaf.getColLeft();
	    widthMax = leaf.getColRight();
	    heightMin = leaf.getRowLeft();
	    heightMax = leaf.getRowRight();

	    for (int j=widthMin; j<=widthMax; j++) {
		Pixel top = image[heightMin][j];
		top.setRed(0);
		top.setGreen(0);
		top.setBlue(0);
		Pixel bottom = image[heightMax][j];
		bottom.setRed(0);
		bottom.setGreen(0);
		bottom.setBlue(0);
	    }

	    for (int k=heightMin; k<=heightMax; k++) {
		Pixel left = image[k][widthMin];
		left.setRed(0);
		left.setGreen(0);
		left.setBlue(0);
		Pixel right = image[k][widthMax];
		right.setRed(0);
		right.setGreen(0);
		right.setBlue(0);
	    }
	}
    }
    
    public ArrayList<Leaf> getLeaves() {
	return getLeavesRec(root);
    }

    private ArrayList<Leaf> getLeavesRec(Node node) {	
	if (node == null) {
	    return null;
	}
	if (node.getNW() == null && node.getNE() == null &&
	    node.getSW() == null && node.getSE() == null) {
	    Leaf thisLeaf = new Leaf(node.getColLeft(), node.getRowLeft(),
				     node.getColRight(), node.getRowRight());
	    //If the node is a leaf, add it to the ArrayList
	    leaves.add(thisLeaf);
	}
	else {
	    getLeavesRec(node.getNW());
	    getLeavesRec(node.getNE());
	    getLeavesRec(node.getSE());
	    getLeavesRec(node.getSW());
	}
	return leaves;
    }
    
    public int countLeaves() {
	return countLeavesRec(root);
    }

    private int countLeavesRec(Node node) {
	if (node == null) {
	    return 0;
	}
	if (node.getNW() == null) { //If one is null, they all are
	    return 1;
	}
	else {
	    return countLeavesRec(node.getNW()) + countLeavesRec(node.getNE())
		+ countLeavesRec(node.getSE()) + countLeavesRec(node.getSW());
	}
    }
    
    private double compLevel() {
	double pixels = (double) (width+1) * (height+1);
	//ArrayList<Leaf> allLeaves = getLeaves();
	//int numLeaves = allLeaves.size();
	//double leaves2 = (double) numLeaves;
	
	//double leaves = (double) getLeafCount();
	//System.out.println(pixels);
	//System.out.println(leaves);
	//System.out.println(leaves/pixels);
	return leafCount/pixels;
    }
    
    public void split() {
    int rand = (int)(Math.random() * 100) + 3; 
	splitRec(root, compression, threshold,true,"   root" );
    //splitlinear(root,1000,"	root origin");
	
	
    }
    
    
    
    private double compLevel(int rec, Node node) {
    	int c= node.getColRight()-node.getColLeft();
    	int h= node.getRowRight()-node.getRowLeft();
    	double pixels = (double) (c) * (h);
    	//ArrayList<Leaf> allLeaves = getLeaves();
    	//int numLeaves = allLeaves.size();
    	//double leaves2 = (double) numLeaves;
    	
    	//double leaves = (double) getLeafCount();
    	//System.out.println(pixels);
    	//System.out.println(leaves);
    	//System.out.println(leaves/pixels);
    	return rec/pixels;
        }
    
    
    private void splitRec(Node node, double compression, int threshold, boolean isroot, String id) {
    int recursions= node.getRecursions();
	recursions+=1;
	node.setRecursions(recursions);

	
	//Coordinates of the node to be split
	int leftX = node.getColLeft();
	int leftY = node.getRowLeft();
	int rightX = node.getColRight();
	int rightY = node.getRowRight();
	
	//Stop when reach desired compression level
	double currentCompression = compLevel(recursions,node);
	
	{
		
		
		
	System.out.println("this is my id"+ id);
	System.out.println("this is leaf count: "+leafCount);	
	System.out.println("currentCompression  "+ currentCompression);
	System.out.println("these are recusions:"+recursions);
	System.out.println("this is my error:"+node.error());
	
	
	
	//old base cases don't really work 
	/*
	if (currentCompression >= compression ) {
			recursions=0;
		    System.out.println("Desired compression reached");
		    return;
		}	*/
	/*	
	 * 
	
	
	
//look at node.error thoroughly checked node.error and I believe it works after one small fix 
	
	
	*/
	
	//complevel now takes in recursions and node recursions act as leaves and the pixels of the node act as total pixels
	if (compLevel(recursions,node)>=compression  ) {
		System.out.println("THIS IS RUNNING" );
		if (leftX == rightX || leftY == rightY) { 
			System.out.println("HEllo motherfuycker we're geting edge cases" );
		    return;
		}
		//modify this to get rid of extra averages 
		if(node.error()>0) {
			node.setToAvg();
		}
	    return;
	}//max recursions it can take is 1000 decrease this to as low as 500 and you still get good images 
	else if(recursions>1000) {
		return;
	}
	
	
	
	/*
	 * int colLeft, int rowLeft, int colRight, int rowRight,
		    Pixel color, Node NW, Node NE, Node SW, Node SE)
	 */
	
	//Make new nodes and set the pointers of the node that was split
	
	Node NW = new Node(leftX, leftY, rightX/2, rightY/2, null, null,
			   null, null, null,recursions);
	Node NE = new Node(rightX/2, leftY, rightX, rightY/2, null, null,
			   null, null, null,recursions);
	Node SW = new Node(leftX, rightY/2, rightX/2, rightY, null, null,
			   null, null, null,recursions);
	Node SE = new Node(rightX/2, rightY/2, rightX, rightY, null, null,
			   null, null, null,recursions);
	node.setNW(NW);
	node.setNE(NE);
	node.setSW(SW);
	node.setSE(SE);

	size += 4;

	//Find and set the average color of each node
	
	NW.setColor(NW.meanColor());
	NE.setColor(NE.meanColor());
	SW.setColor(SW.meanColor());
	SE.setColor(SE.meanColor());
	
	//Find the average error of each node and recurse on the nodes
	//   that have error > ?
	//Set the all the pixels in the other nodes to average color otherwise
	//System.out.println("My id: "+ id);
	double NWError = NW.error();
	System.out.println("NW error: "+NWError);
	double NEError = NE.error();
	System.out.println("NE error: "+NEError);
	double SEError = SE.error();
	System.out.println("SE error: "+SEError);
	double SWError = SW.error();
	System.out.println("SW error: "+SWError);
	
	
	
	//structure
	/*
	 * if the Node section has an error above the threshhold we continue
	 */
	if (NWError > threshold || isroot ) {
		//if the compression level of the node is low compared to the desired compression
		// we force it to break up again 
		if(compLevel(NW.getRecursions(),NW)<compression){
			leafCount += 3;
		    splitRec(NW, compression, threshold,true,id+" NW");
		}
		else {
			leafCount += 3;
		    splitRec(NW, compression, threshold,false,id+" NW");
		}
	    
	}
	
	

	
	
	if (NEError > threshold || isroot ) {
		if(compLevel(NE.getRecursions(),NE)<compression){
			leafCount += 3;
		    splitRec(NE, compression, threshold,true,id+" NE");
		}
		else {
			leafCount += 3;
		    splitRec(NE, compression, threshold,false,id+" NE");
		}
	    
	}
	
	
	if (SEError > threshold || isroot ) {
		if(compLevel(SE.getRecursions(),SE)<compression){
			leafCount += 3;
		    splitRec(SE, compression, threshold,true,id+" SE");
		}
		else {
			leafCount += 3;
		    splitRec(SE, compression, threshold,false,id+" SE");
		}
	    
	}
	

	
	
	if (SWError > threshold || isroot ) {
		if(compLevel(SW.getRecursions(),SW)<compression){
			leafCount += 3;
		    splitRec(SW, compression, threshold,true,id+" SW");
		}
		else {
			leafCount += 3;
		    splitRec(SW, compression, threshold,false,id+" SW");
		}
	    
	}
	
	
    }
  }
    //Nested node class
    //Each node is a rectangular area of the image defined by where the upper
    //     left corner and the lower right corner are.
    private class Node {
	private int rowLeft; //The row of the upper left corner 
	private int colLeft; //Column of the upper left corner
	private int rowRight; //Row of the lower right corner
	private int colRight; //Column of the lower right corner
	private Pixel color; //The average color of the node
	private Node NW;
	private Node NE;
	private Node SW;
	private Node SE;
	private int recursions;// this is the individual recursion varaible that tracks how much each node has recursed
	public Node(int colLeft, int rowLeft, int colRight, int rowRight,
		    Pixel color, Node NW, Node NE, Node SW, Node SE) {
	    this.rowLeft = rowLeft;
	    this.colLeft = colLeft;
	    this.rowRight = rowRight;
	    this.colRight = colRight;
	    this.color = color;
	    this.NW = NW;
	    this.NE = NE;
	    this.SW = SW;
	    this.SE = SE;
	    recursions=1;
	}
	public Node(int colLeft, int rowLeft, int colRight, int rowRight,
		    Pixel color, Node NW, Node NE, Node SW, Node SE,int recursions) {
	    this.rowLeft = rowLeft;
	    this.colLeft = colLeft;
	    this.rowRight = rowRight;
	    this.colRight = colRight;
	    this.color = color;
	    this.NW = NW;
	    this.NE = NE;
	    this.SW = SW;
	    this.SE = SE;
	    this.recursions=recursions;
	}

	public boolean hasChildren() {
	    return getNW() == null;
	}
	
	public Pixel meanColor() {
	    int redCount = 0;
	    int greenCount = 0;
	    int blueCount = 0;
	    int pixelCount = 0;
	    
	    int widthMin = getColLeft();
	    int widthMax = getColRight();
	    int heightMin = getRowLeft();
	    int heightMax = getRowRight();
	    
	    for (int i=heightMin; i<=heightMax; i++) {
		for (int j=widthMin; j<=widthMax; j++) {
		    Pixel pix = image[i][j];
		    redCount += pix.getRed();
		    greenCount += pix.getGreen();
		    blueCount += pix.getBlue();
		    pixelCount++;
		}
	    }
	    Pixel avg;
	    //Calculate the averages
	    if (pixelCount != 0) {
		int avgRed = redCount/pixelCount;
		int avgGreen = greenCount/pixelCount;
		int avgBlue = blueCount/pixelCount;
		avg = new Pixel(avgRed, avgGreen, avgBlue);
		 }
	    else {
	    	int avgRed = 0;
			int avgGreen = 0;
			int avgBlue = 255;
			avg = new Pixel(avgRed, avgGreen, avgBlue);
	    }
	    
		
	    //Create and return a pixel
	    
	    
	    return avg;
	}

	//Computes the difference between the current node's avg color and each
	//   pixel in the node's color. Then adds up all these errors and
	//   averages them.
	public double error() {
	    Pixel avgColor = getColor();
	    int nodeR = avgColor.getRed();
	    int nodeG = avgColor.getGreen();
	    int nodeB = avgColor.getBlue();
	    int widthMin = getColLeft();
	    int widthMax = getColRight();
	    int heightMin = getRowLeft();
	    int heightMax = getRowRight();
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
	    // pixel count must be squared so it grows at the same rate as error which is being squared
	    double pixels = (double) pixelCount*pixelCount;
	   
	    double avgError = errorCount/pixels;
	    return avgError*100;
	}

	//Sets every pixel in the node to the average color
	public void setToAvg() {
	    Pixel color = getColor();
	    int nodeR = color.getRed();
	    int nodeG = color.getGreen();
	    int nodeB = color.getBlue();
	    int widthMin = getColLeft();
	    int widthMax = getColRight();
	    int heightMin = getRowLeft();
	    int heightMax = getRowRight();
	    
	    for (int i=heightMin; i<=heightMax; i++) {
	    	for (int j=widthMin; j<=widthMax; j++) {
	    		
			    Pixel pix = getColor();
			   
			    
			    image[i][j]=pix;
			    //image[i][j]=new Pixel(0,0,255);
	    	}
	    }
	}
	
	//Getters
	public int getRowLeft() {
	    return rowLeft;
	}

	public int getColLeft() {
	    return colLeft;
	}

	public int getRowRight() {
	    return rowRight;
	}

	public int getColRight() {
	    return colRight;
	}

	public Pixel getColor() {
	    return color;
	}
	
	public Node getNW() {
	    return NW;
	}

	public Node getNE() {
	    return NE;
	}

	public Node getSW() {
	    return SW;
	}

	public Node getSE() {
	    return SE;
	}
	public int getRecursions() {
	    return recursions;
	}
	//Setters
	public void setNW(Node node) {
	    NW = node;
	}

	public void setNE(Node node) {
	    NE = node;
	}

	public void setSW(Node node) {
	    SW = node;
	}

	public void setSE(Node node) {
	    SE = node;
	}
	public void setRecursions(int rec) {
	    recursions = rec;
	}
	public void setColor(Pixel newColor) {
	    color = newColor;
	}
    } //End of nested node class
}
