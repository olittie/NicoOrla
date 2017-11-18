package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ou.jabberpoint.view.BitmapItemDrawer;


/** <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class BitmapItem extends SlideItem {
	
	private BufferedImage bufferedImage;
	private String imageName;
	private BitmapItemDrawer itemDrawer;
	
	protected static final String FILE = "Bestand ";
	protected static final String NOTFOUND = " niet gevonden";

// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItem(String name, Style style, BitmapItemDrawer itemDrawer) {
		super(style);
		imageName = name;		
		this.itemDrawer = itemDrawer;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND) ;
		}
	}	
	
// Een leeg bitmap-item
	public BitmapItem(Style style) {
		this(null, style, null);
	}
	
// geef de bestandsnaam van de afbeelding
	public String getName() {
		return imageName;
	}

// geef de bounding box van de afbeelding
	public Rectangle getBoundingBox(Graphics g, float scale) {
		return itemDrawer.getBoundingBox(g, scale, getStyle(), bufferedImage);
	}

// teken de afbeelding
	public void draw(Graphics g, int x, int y, float scale) {
		itemDrawer.drawBitmap(g, x, y, scale, getStyle(), bufferedImage);
	}

	public String toString() {
		return "{BitmapItem:" + "," + imageName + "}";
	}		
		
}