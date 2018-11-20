package gov.kingcounty.archives.CombineTiff;

/**
 * 
 * @author Abraham Taylor
 *
 */

public class ArrayData
  {
    private final int[] dataArray;
    private final int width;
    private final int height;
    private int maxRadius;
 

	public ArrayData(int width, int height)
    {
      this(new int[width * height], width, height);
    }
 
    public ArrayData(int[] dataArray, int width, int height)
    {
      this.dataArray = dataArray;
      this.width = width;
      this.height = height;
      this.maxRadius = (int)Math.ceil(Math.hypot(width, height));
    }
 
    public int get(int x, int y)
    {  return dataArray[y * width + x];  }
 
    public void set(int x, int y, int value)
    {  dataArray[y * width + x] = value;  }
 
    public void accumulate(int x, int y, int delta)
    {  set(x, y, get(x, y) + delta);  }
 
    public boolean contrast(int x, int y, int minContrast)
    {
      int centerValue = get(x, y);
      for (int i = 8; i >= 0; i--)
      {
        if (i == 4)
          continue;
        int newx = x + (i % 3) - 1;
        int newy = y + (i / 3) - 1;
        if ((newx < 0) || (newx >= width) || (newy < 0) || (newy >= height))
          continue;
        if (Math.abs(get(newx, newy) - centerValue) >= minContrast)
          return true;
      }
      return false;
    }
    
    /**
     * returns doublepair. first number is r, second is theta.
     * @param x
     * @param y
     * @return
     */
    public DoublePair convertBack(int x, int y) {
    	System.out.println("width = " + width + "   height = " + height + "   maxradius = " + maxRadius);
    	double theta = (double)x / (double) width * Math.PI;
    	double r =  (double)y / (double)height * (double)maxRadius * 2 - (double)maxRadius;
    	return new DoublePair(r, theta);
    }
 
    public IntPair getMax()
    {
      int max = dataArray[0];
      int maxWidth = 0;
      int maxHeight = 0;
      for (int y = height - 1;y >= 0; y--) {
        for (int x = width - 1; x >= 0; x--) {
          int i = y * width + x;
    	  if (dataArray[i] > max) {
            maxWidth = x;
            maxHeight = y; 
            max = dataArray[i];
    	  }
        }
      }

      IntPair pair = new IntPair(maxWidth, maxHeight);
      return pair;
    }
    
    public int getMaxRadius() {
		return maxRadius;
	}
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
}