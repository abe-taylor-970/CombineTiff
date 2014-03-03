package gov.kingcounty.archives.CombineTiff;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.awt.image.BufferedImage;


public class CombineTiff {
	public static void main (String [] args) {
		BufferedImage image = null;
        try {
            File imagefile = new File("/home/abraham/data/DEL002/D192/392/373.tif");
            Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix("tif");
            System.out.println(readers.hasNext());
            image = ImageIO.read(imagefile);
            System.out.println("Height = " + image.getHeight());
            System.out.println("Width = " + image.getWidth());
            System.out.println("RGB (440,118) = " + image.getRGB(440, 118));
            System.out.println("RGB (420,113) = " + image.getRGB(420, 113));
            System.out.println("RGB (362,228) = " + image.getRGB(362, 228));
    
            


        } catch (IOException e) {
              e.printStackTrace();
        }
        System.out.println("Success");
	}
	

}
