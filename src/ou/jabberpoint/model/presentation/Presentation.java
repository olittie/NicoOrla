package ou.jabberpoint.model.presentation;

import ou.jabberpoint.event.EventDispatcher;
import ou.jabberpoint.event.SlidesEvent;
import ou.jabberpoint.view.SlideViewerComponent;

import java.awt.*;


/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation extends AbstractPresentation implements IPresentation {
	
	public EventDispatcher<SlidesEvent> slidesDispatcher;

	public Presentation() {
		slidesDispatcher = new EventDispatcher<>();
		clear();
	}
	
	@Override
	public void draw(Graphics g, Rectangle area, SlideViewerComponent slideViewerComponent) {
		// do nothing
	}

	
	@Override
	public void addItem(IPresentation presentation) {
		super.addItem(presentation);
		slidesDispatcher.fire(new SlidesEvent(this));
	}
	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		super.clear();
		slidesDispatcher.fire(new SlidesEvent(this));
	}
}
