package ou.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * <p>PresentationElement is een abstracte class, die zowel slides als slide-items kan bevatten.</p>
 * 
 * @author Nico, Orla
 *
 */

public abstract class PresentationItem {
	

	public void draw(Graphics g, Rectangle area, ImageObserver view)
	{
		
	}

	public void draw(int x, int y, float scale, 
			Graphics g, Style style, ImageObserver observer)
	{
		
	}

	public void add(PresentationItem element)
	{
		
	}
	
	public void remove(PresentationItem element)
	{
		
	}
}
