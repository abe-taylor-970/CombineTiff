package gov.kingcounty.archives.CombineTiff;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Abraham Taylor
 *
 */

//NOTES : some files have no line on the left margin and are only white space then one margin line.
//  some files have many black lines on the left, but very little whitespace. 
//  some files have damage, which is black all over the margin (in lower half, in example I saw).for example D198/405/558.tif
//  some files have white horizontal margin at top, with several black horizontal lines before margin on left and text on right begins. ex. D195/399/523.tif
//  IN GENERAL : LEFT pages have black on left, then white begins for margin. RIGHT pages have (on left) white and possibly black vertical lines before margin begins 
//  folder D201 (411 and 412) and all of D202 and all of D194 and all of D193, and D192/394 is single-page deeds and does not need to be processed. D201, 410 all needs to be processed.

//  

// POSSIBLE SOLUTION APPROACHES : SUM UP VALUES OF PIXELS IN EACH VERTICAL LINE TO FIND MARGIN which is a VERTICAL HISTORGRAM
// THEN SUM UP VALUES WITHIN MARGIN ON EACH HORIZONTAL LINE TO FIND NUMBERS
// USE HOUGH TRANSFORM TO DETECT LINES.

/*
FindMargin() :
	1) start (0,0) increment x or y until get to white space (-1)
	2) increment x until find black mark (-16777216)
	3) call recursive function search () to find continguous marks to black mark. Depth first search. keep all continguous marks in array
	  --> only stop searching a certain direction if more than one pixel (maybe several in a row) of white pixels to correct for when
	     the line has gaps.
	4) if y variance is over certain number (500 pixels), and x variance is pretty small, then it's straight line down paper
*/

public class FindMargin {
	
	private Map<Integer, IntPair> margin;
	private BufferedImage image;
	
	/**
	 * constructor
	 * @param image the image to use
	 */
	public FindMargin(BufferedImage image) {
		this.image = image;
		margin = new TreeMap<Integer, IntPair>();
	}
    
    /**
     *  finds a margin from certain coordinates.
     * @param startX starting x coordinate
     * @param startY starting y coordinate
     * @return
     */
	public Map<Integer, IntPair> findMargin(int startX, int startY) {
		if (isBlack(startX, startY)) {
			//search for white space.
		}
    }

	/**
	 * return null if had error finding line. Or maybe throw exception.
	 * @param startX
	 * @param startY
	 * @return
	 */
	private Map<Integer, Integer> findLine(int startX, int startY) {
		
	}

	/**
	 * determines if a specific x and y coordinate in image is black or white
	 * @param x x coordinate
	 * @param y y coordinaTe
	 * @return true if coordinate is black, false otherwise
	 */
	private boolean isBlack(int x, int y) {
		int rgbValue = image.getRGB(x, y);
		if (rgbValue < -500) {
			return true;
		}
		else if (rgbValue == -1) {
			return false;
		}
		else {
			return false;
		}
	}
	
	private boolean testMargin() {
	// margin must be 200 pixels apart at least to be valid.	
	}
	
	private void search (int currentX, int currentY) {
		
	}

}
