package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

import ou.jabberpoint.view.ISlideItemFactory;
import ou.jabberpoint.view.SlideItemFactory;
import ou.jabberpoint.view.SlideViewerComponent;

/** <p>Een slide. Deze klasse heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide extends PresentationItem {
	
	public Slide() {
		this(new Vector<>());
	}

	public Slide(Vector<PresentationItem> slideItems) {
		this.items = slideItems;
	}

	public Slide(String title) {
		super(title);
	}
	

	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	void drawSlideItems(Graphics g, Rectangle area, ImageObserver view, float scale, int y) {
		ISlideItemFactory _slideItemFactory = new SlideItemFactory((SlideViewerComponent)view);
		
		yPos = y;
		SlideItem slideItem = _slideItemFactory.createTextItem(0, getTitle());
		slideItem.draw(g, area.x, yPos, scale);
		yPos += slideItem.getBoundingBox(g, scale).height;
		

		for (int number = 0 ; number<getSize(); number++) {
			SlideItemAdapter adapter = (SlideItemAdapter) getSlideItems().elementAt(number);
			slideItem = adapter.getSlideItem();
			slideItem.draw(g, area.x, yPos, scale);
			yPos += slideItem.getBoundingBox(g, scale).height;
		}
	}
}
