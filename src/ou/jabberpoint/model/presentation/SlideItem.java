package ou.jabberpoint.model.presentation;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/** <p>De abstracte klasse voor een item op een Slide<p>
 * <p>Alle SlideItems hebben tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class SlideItem implements PresentationItem {
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	private int level = 0; // het level van het slideitem
	private int size; // de size van het slideitem
	
	public SlideItem(int lev) {
		level = lev;
	}

	public SlideItem() {
		this(0);
	}

	public int getLevel() {
		return level;
	}
		
	// geef de afmeting van de SlideItem
	public int getSize() {
		return size;
	}
	
	//empty
	public void append(PresentationItem anItem) {};

	// teken het item
	public void draw(Graphics g, Rectangle area, ImageObserver view) {};
	
	// geef de schaal om de slide te kunnen tekenen
	protected float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
	}

	@Override
	public int getYPosHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
