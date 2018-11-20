package gov.kingcounty.archives.CombineTiff;


/**
 * @author Abraham Taylor
 */

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class HoughTransform {
	 
  public ArrayData houghTransform(ArrayData inputData, int thetaAxisSize, int rAxisSize, int minContrast)
  {
    int width = inputData.getWidth();
    int height = inputData.getHeight();
    int halfRAxisSize = rAxisSize >>> 1;
    ArrayData outputData = new ArrayData(thetaAxisSize, rAxisSize);
    int maxRadius = outputData.getMaxRadius();
    System.out.println("maxRadius = " + maxRadius);
    // x output ranges from 0 to pi
    // y output ranges from -maxRadius to maxRadius
    double[] sinTable = new double[thetaAxisSize];
    double[] cosTable = new double[thetaAxisSize];
    for (int theta = thetaAxisSize - 1; theta >= 0; theta--)
    {
      double thetaRadians = theta * Math.PI / thetaAxisSize;
      sinTable[theta] = Math.sin(thetaRadians);
      cosTable[theta] = Math.cos(thetaRadians);
    }
 
    for (int y = height - 1; y >= 0; y--)
    {
    	if (y % 100 == 0) {
    		System.out.println("Processing at " + y);
    	}
      for (int x = width - 1; x >= 0; x--)
      {
        if (inputData.contrast(x, y, minContrast))
        {
          for (int theta = thetaAxisSize - 1; theta >= 0; theta--)
          {
            double r = cosTable[theta] * x + sinTable[theta] * y;
            int rScaled = (int)Math.round(r * halfRAxisSize / maxRadius) + halfRAxisSize;
            outputData.accumulate(theta, rScaled, 1);
          }
        }
      }
    }
    return outputData;
  }
 
 
  public ArrayData getArrayDataFromImage(BufferedImage inputImage) 
  {
    int width = inputImage.getWidth();
    int height = inputImage.getHeight();
    int[] rgbData = inputImage.getRGB(0, 0, width, height, null, 0, width);
    ArrayData arrayData = new ArrayData(width, height);
    // Flip y axis when reading image
    for (int y = 0; y < height; y++)
    {
      for (int x = 0; x < width; x++)
      {
        int rgbValue = rgbData[y * width + x];
        rgbValue = (int)(((rgbValue & 0xFF0000) >>> 16) * 0.30 + ((rgbValue & 0xFF00) >>> 8) * 0.59 + (rgbValue & 0xFF) * 0.11);
        arrayData.set(x, height - 1 - y, rgbValue);
      }
    }
    return arrayData;
  }
 
  public void writeOutputImage(String filename, ArrayData arrayData) throws IOException
  {
    IntPair maxPair = arrayData.getMax();
    int max = arrayData.get(maxPair.getfirstInt(), maxPair.getsecondInt());
    BufferedImage outputImage = new BufferedImage(arrayData.getWidth(), arrayData.getHeight(), BufferedImage.TYPE_INT_ARGB);
    for (int y = 0; y < arrayData.getHeight(); y++)
    {
      for (int x = 0; x < arrayData.getWidth(); x++)
      {
        int n = Math.min((int)Math.round(arrayData.get(x, y) * 255.0 / max), 255);
        outputImage.setRGB(x, arrayData.getHeight() - 1 - y, (n << 16) | (n << 8) | 0x90 | -0x01000000);
      }
    }
    ImageIO.write(outputImage, "PNG", new File(filename));
    return;
  }
 
  public ArrayData doHoughTransform(BufferedImage inputImage, int contrast)
  {
    ArrayData inputData = getArrayDataFromImage(inputImage);
    int minContrast = contrast; 
    int width = inputImage.getWidth();
    int height = inputImage.getHeight();
//    width /= 2;
//    height /= 2;
    System.out.println("About to enter houghTransform");
    return houghTransform(inputData, width, height, minContrast);
  }
}
