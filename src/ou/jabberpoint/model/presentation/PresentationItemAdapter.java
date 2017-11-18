package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Vector;

import ou.jabberpoint.view.SlideViewerComponent;

public class PresentationItemAdapter extends AbstractPresentation implements IPresentation {

	
	private PresentationItem presentationItem;

    public PresentationItemAdapter(PresentationItem presentationItem) {
        this.presentationItem = presentationItem;
    }

    public PresentationItem getPresentatinItem() {
        return this.presentationItem;
    }

    @Override
    public void addItem(IPresentation item) {
    	PresentationItemAdapter adapter = (PresentationItemAdapter) item;
    	getPresentatinItem().addItem(adapter.getPresentatinItem());
    }

    @Override
    public String getTitle() {
        return this.presentationItem.getTitle();
    }

    @Override
    public Vector<PresentationItem> getSlideItems() {
        return this.presentationItem.getSlideItems();
    }

    @Override
    public void draw(Graphics g, Rectangle area, SlideViewerComponent slideViewerComponent) {
    	this.presentationItem.draw(g, area, slideViewerComponent);
    }

//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public PresentationIterator getIterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
