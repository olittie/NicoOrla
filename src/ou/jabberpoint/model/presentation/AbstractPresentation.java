package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import ou.jabberpoint.view.SlideViewerComponent;

public abstract class AbstractPresentation implements IPresentation {
		
	protected String _title;
	protected Vector<IPresentation> items;
	protected ArrayList<ArrayList<Integer>> threads;
	protected int currentThread;
	
	public AbstractPresentation() {
	    this.items = new Vector<>();
	    this.threads = new ArrayList<>();
	    this.currentThread = 0;
	}
	
	@Override
	public void addItem(IPresentation item) {
	    this.items.add(item);
	}
	
	@Override
	public int getSize() {
		if (getThreadsSize() == 0) {
			return items.size();
		}
		else {
			return threads.get(currentThread).size();
		}
	    
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
	
	public void addThread(ArrayList<Integer> thread) {
		threads.add(thread);
	}
	
	public int getThreadsSize() {
		return threads.size();
	}
	
	public ArrayList<ArrayList<Integer>> getThreads(){
		return null;
	}
	
	public void setCurrentThread(int threadNumber) {
		currentThread = threadNumber;
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
		if (currentThread == 0) {
			return new SlideIterator(items);
		}
		else {
			return new SlideIterator(items, threads.get(currentThread));
		}
	}
}
