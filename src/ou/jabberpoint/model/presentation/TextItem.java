package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;

import ou.jabberpoint.view.TextItemDrawer;

/** <p>Een tekst item.</p>
 * <p>Een TextItem heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem {
	private String text;
	private TextItemDrawer slideItemDrawer;
	
	
	private static final String EMPTYTEXT = "No Text Given";

// een textitem van level level, met als tekst string
	public TextItem(String text, Style style, TextItemDrawer itemDrawer) {
		super(style);
		this.text = text;
		this.slideItemDrawer = itemDrawer;
	}

// een leeg textitem
	public TextItem(Style style) {
		this(EMPTYTEXT, style, null);
	}
	
	
// Geef de tekst
	public String getText() {
		return text == null ? "" : text;
	}


// teken het item
	public void draw(Graphics g, int x, int y, float scale) {
		if (text == null || text.length() == 0) {
			return;
		}
		slideItemDrawer.drawText(g, x, y, scale, getStyle(), text);
	}	

// geef de bounding box van het item
	public Rectangle getBoundingBox(Graphics g, float scale) {
		return slideItemDrawer.getBoundingBox(g, scale, getStyle(), text);
	}
	

	public String toString() {
		return "{TextItem: " + getText() + "}";
	}	
}
