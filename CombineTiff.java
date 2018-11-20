package gov.kingcounty.archives.CombineTiff;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.awt.image.BufferedImage;

/**
 * @author Abraham Taylor
 */

public class CombineTiff {
	public static void main (String [] args) {
		BufferedImage image = null;
		
		//Have it say Input Folder to process : ... then recursively do everything inside that folder
		//Then have it say Input Index file :
        try {
            File imagefile = new File("/home/abraham/data/DEL002/D192/392/373.tif");
            image = ImageIO.read(imagefile);
            System.out.println("Height = " + image.getHeight());
            System.out.println("Width = " + image.getWidth());
            System.out.println("RGB (440,118) = " + image.getRGB(440, 118));
            System.out.println("RGB (420,113) = " + image.getRGB(420, 113));
            System.out.println("RGB (362,228) = " + image.getRGB(362, 228));

            HoughTransform transform = new HoughTransform();
            ArrayData data = transform.doHoughTransform(image, 75);
            transform.writeOutputImage("/home/abraham/Development/outputImage.png", data);
            IntPair maxPair = data.getMax();
            int max = data.get(maxPair.getfirstInt(), maxPair.getsecondInt());
            System.out.println("width = " + maxPair.getfirstInt() + "   height = " + maxPair.getsecondInt() + "  max = " + max);
            DoublePair line = data.convertBack(maxPair.getfirstInt(), maxPair.getsecondInt());
            double r = line.getfirstdouble();
            double theta = line.getseconddouble();
            System.out.println(" r = " + r + " theta = " + theta);

        } catch (IOException e) {
              e.printStackTrace();
        }
        System.out.println("Success");
	}
	

}
