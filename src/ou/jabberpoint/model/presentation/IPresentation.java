package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

import ou.jabberpoint.view.SlideViewerComponent;

public interface IPresentation {
	
	void addItem(IPresentation item);

    int getSize();

    Vector<PresentationItem> getSlideItems();

    void clear();

    PresentationIterator getIterator();

    void setTitle(String title);

    String getTitle();

    void draw(Graphics g, Rectangle area, SlideViewerComponent view);
    
}
