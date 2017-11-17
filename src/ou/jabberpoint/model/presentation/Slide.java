package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/** <p>Een slide. Deze klasse heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide implements PresentationItem {
	
	/* Geen String meer maar een TextItem TODO */
	protected String title; // de titel wordt apart bewaard
	protected Vector<PresentationItem> items; // de slide-items worden in een Vector bewaard

	public Slide() {
		items = new Vector<PresentationItem>();
	}

	public Slide(String title) {
		items = new Vector<PresentationItem>();
		this.title = title;
	}
	
	// Voeg een SlideItem toe
	public void append(PresentationItem anItem) {
		items.addElement(anItem);
	}

	// geef de titel van de slide
	public String getTitle() {
		/* Geef nu de tekst van het TextItem terug */
		return title;
	}

	@Override
	public int getYPosHeight() {
		// TODO Auto-generated method stub
		return 20;
	}
	
	// verander de titel van de slide
	public void setTitle(String newTitle) {
		/* Creëer nu een TextItem op basis van de nieuwe titel */
		title = newTitle;
	}


	// geef het betreffende SlideItem
	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.elementAt(number);
	}

	// geef alle SlideItems in een Vector
	public Vector<PresentationItem> getSlideItems() {
		return items;
	}

	// geef de afmeting van de Slide
	public int getSize() {
		return items.size();
	}

	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		
		/* De titel hoeft niet meer apart behandeld te worden */
	    PresentationItem slideItem = new TextItemAdapter(0, this.title);
	    slideItem.draw(g, area, view);
	    area.y += slideItem.getYPosHeight();
	    
	    for (int number=0; number<getSize(); number++) {
	      slideItem = getSlideItems().elementAt(number);
	      slideItem.draw(g, area, view);
		  area.y += slideItem.getYPosHeight();
	    }
	  }


}
