package GameInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class setIcon {
	//load anh tu file
	public ImageIcon loadImage(String image) {
		BufferedImage bimage = null;
	    ImageIcon photo = null;
	    try {
	    	bimage = ImageIO.read(new File(image));
	        photo = new ImageIcon(bimage);
	    } catch (IOException e) {
	        System.out.println(e.toString());
	        System.out.println("Can't load image");
	    }
	    return photo;
	}
}

