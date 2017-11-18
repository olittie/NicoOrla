package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>PresentationElement is een abstracte class, die zowel slides als slide-items kan bevatten.</p>
 * 
 * @author Nico, Orla
 *
 */

public abstract class PresentationItem {
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
    protected int yPos;

    protected Vector<PresentationItem> items;
    protected String title;

    public PresentationItem() {
    	items = new Vector<>();
    }

    public PresentationItem(String title) {
        this();
        this.title = title;
    }

    public void addItem(PresentationItem presentationItem) {
    	items.add(presentationItem);
    }

    // Voeg een SlideItem toe
    public void append(PresentationItem slideItem) {
        this.items.addElement(slideItem);
    }
    

    // geeft de titel van de slide
    public String getTitle() {
        return this.title;
    }

    // verander de titel van de slide
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    // geef het betreffende SlideItem
    public PresentationItem getSlideItem(int number) {
        return this.items.elementAt(number);
    }

    // geef alle SlideItems in een Vector
    public Vector<PresentationItem> getSlideItems() {
        return this.items;
    }

    // geef de afmeting van de Slide
    public int getSize() {
        return this.items.size();
    }

    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);
        int y = area.y;

        this.drawSlideItems(g, area, view, scale, y);
    }

    // geef de schaal om de slide te kunnen tekenen
    protected float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float) WIDTH), ((float)area.height) / ((float) HEIGHT));
    }

    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);
    
    abstract void drawSlideItems(Graphics g, Rectangle area, ImageObserver view, float scale, int y);

}
