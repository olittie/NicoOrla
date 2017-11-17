package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * <p>PresentationElement is een abstracte class, die zowel slides als slide-items kan bevatten.</p>
 * 
 * @author Nico, Orla
 *
 */

public interface PresentationItem {
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public abstract int getSize();
	public abstract int getYPosHeight();
	public abstract void append(PresentationItem anItem);
	public abstract void draw(Graphics g, Rectangle area, ImageObserver view);

}
