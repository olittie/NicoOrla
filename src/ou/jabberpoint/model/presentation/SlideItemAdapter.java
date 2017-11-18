package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class SlideItemAdapter extends PresentationItem {
	
	private SlideItem slideItem;

    public SlideItemAdapter(SlideItem slideItem) {
        this.slideItem = slideItem;
    }

    public SlideItem getSlideItem() {
        return slideItem;
    }

    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);

        this.slideItem.draw(g, area.x, area.y, scale);
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
        return this.slideItem.getBoundingBox(g, scale);
    }

    @Override
    void drawHeader(Graphics g, Rectangle area, ImageObserver view, float scale, int y) {
        // don't draw header for slide item
    }

    @Override
    void drawSlideItems(Graphics g, Rectangle area, ImageObserver view, float scale, int y) {
        // don't draw items for slide item
    }

}
