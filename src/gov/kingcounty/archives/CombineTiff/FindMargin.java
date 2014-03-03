package gov.kingcounty.archives.CombineTiff;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;



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
	
	private List<IntPair> margin;
	private BufferedImage image;
	
	/**
	 * constructor
	 * @param image the image to use
	 */
	public FindMargin(BufferedImage image) {
		this.image = image;
		margin = new ArrayList<IntPair>(); 
	}
	
    
    
    /**
     *  finds a margin from certain coordinates.
     * @param startX starting x coordinate
     * @param startY starting y coordinate
     * @return List of IntPairs of continguous marks if margin is found. Otherwise, returns null
     */
	public List<IntPair> findMargin(int startX, int startY) {
		if (isBlack(startX, startY)) {
			//search for white space.
		}
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
