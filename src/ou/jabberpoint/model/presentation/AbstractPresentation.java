package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

import ou.jabberpoint.view.SlideViewerComponent;

public abstract class AbstractPresentation implements IPresentation {
		
	protected String _title;
	protected Vector<IPresentation> items;
	
	public AbstractPresentation() {
	    this.items = new Vector<>();
	}
	
	@Override
	public void addItem(IPresentation item) {
	    this.items.add(item);
	}
	
	@Override
	public int getSize() {
	    return items.size();
	}
	
	@Override
	public Vector<PresentationItem> getSlideItems() {
	    return null;
	}
	
	@Override
	public void setTitle(String title) {
	    this._title = title;
	}
	
	@Override
	public String getTitle() {
	    return this._title;
	}
	
	@Override
	public void draw(Graphics g, Rectangle area, SlideViewerComponent slideViewerComponent) {
        // do nothing
    }
	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
	    items = new Vector<>();
	}
	
	public PresentationIterator getIterator()
	{
	    return new SlideIterator(items);
	}
}
