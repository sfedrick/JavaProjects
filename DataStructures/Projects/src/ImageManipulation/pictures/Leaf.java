/*
 * File: Leaf.java
 * Desc:
 *
 *
 */
package homework9.pictures;
public class Leaf{
    private int rowLeft; //The row # of the upper left corner
    private int colLeft; //The column # of the upper left corner
    private int rowRight; //The row # of the lower right corner
    private int colRight; //The column # of the lower right corner

    public Leaf(int colLeft, int rowLeft, int colRight, int rowRight) {
	this.rowLeft = rowLeft;
	this.colLeft = colLeft;
	this.rowRight = rowRight;
	this.colRight = colRight;
    }

    public int getColLeft() {
	return colLeft;
    }

    public int getRowLeft() {
	return rowLeft;
    }

    public int getColRight() {
	return colRight;
    }

    public void setRowRight(int x) {
	 rowRight=x;
    }
    public void setColLeft(int x) {
    	colLeft=x;
        }

    public void setRowLeft(int x) {
    	rowLeft=x;
        }

    public void setColRight(int x) {
    	colRight=x;
        }

    public int getRowRight() {
    	return rowRight;
        }
    
}
