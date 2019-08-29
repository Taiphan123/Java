package img.processing;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AI1 {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;

        // read image
        try {
//            f = new File("/home/framgia/Pictures/dep.jpg");
            f = new File("C://Users//1 cu//Desktop//web//anh/dep.jpg");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }

        /* get pixel value */
        int p = img.getRGB(0, 0);

        /* We, have seen that the components of pixel occupy
           8 bits. To get the bits we have to first right shift
           the 32 bits of the pixels by bit position(such as 24
           in case of alpha) and then bitwise ADD it with 0xFF.
           0xFF is the hexadecimal representation of the decimal
           value 255.  */

        // get alpha
        int a = (p >> 24) & 0xff;

        // get red
        int r = (p >> 16) & 0xff;

        // get green
        int g = (p >> 8) & 0xff;

        // get blue
        int b = p & 0xff;

        /*
        for simplicity we will set the ARGB
        value to 255, 100, 150 and 200 respectively.
        */
        a = 255;
        r = 100;
        g = 150;
        b = 200;
        // set the pixel value
        p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(0, 0, p);

        // write image
        try {
        	f = new File("C://Users//1 cu//Desktop//web//anh/Out1.jpg");
//            f = new File("C:\\Out.jpg");
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
