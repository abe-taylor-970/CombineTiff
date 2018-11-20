package gov.kingcounty.archives.CombineTiff;
/**
 * a part of a margin, containing two x coordinates and one y coordinate for each point. 
 * @author Abraham Taylor
 *
 */
public class MarginPart implements Comparable<MarginPart>{
	
	private int x1;
	private int x2;
	private int y;
	
	public MarginPart(int x1, int x2, int y) {
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(MarginPart other) {
		return Integer.valueOf(this.y).compareTo(Integer.valueOf(other.getY()));
	}
}
