package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;


/** <p>De klasse voor een Bitmap item Adapter</p>
 * <p>De adapter maakt van een BitItem een SlideItem.</p>
 * <p>De draw wordt omgezet.</p>
 * 
 * @author Nico
 *
*/

public class BitmapItemAdapter extends SlideItem {
	
	private String imageName;
	  
	private BitmapItem bitMapItem;
	private int yPos;
	
// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItemAdapter(int level, String name) {
		super(level);
		this.imageName = name;
		this.bitMapItem = new BitmapItem(level, name);
	}

// Een leeg bitmap-item
	public BitmapItemAdapter() {
		this(0, null);
		this.bitMapItem = new BitmapItem();
	}

// geef de bestandsnaam van de afbeelding
	public String getName() {
		return imageName;
	}


// Geef de yPos;
	public int getYPos() {
		return yPos;
	}


	
// teken het item
	public void draw(Graphics g, Rectangle area, ImageObserver view)
	{
	    Style style = Style.getStyle(this.getLevel());
		float scale = super.getScale(area);

		this.bitMapItem.draw(area.x, area.y, scale, g, style, view);
	    yPos = this.bitMapItem.getBoundingBox(g, view, scale, style).height;
	}


	public String toString() {
		return "BitmapItemAdapter[" + getLevel() + "," + imageName + "]";
	}
}
