package ou.jabberpoint.model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class AbstractSlideItemDrawer {
	public void drawText(Graphics g, int x, int y, float scale, Style style, String text) { }
    public void drawBitmap(Graphics g, int x, int y, float scale, Style style, BufferedImage image) { }

    public Rectangle getBoundingBox(Graphics g, float scale, Style style, BufferedImage image) { return new Rectangle(); }
    public Rectangle getBoundingBox(Graphics g, float scale, Style style, String text) { return new Rectangle(); }

    Rectangle getBoundingBox() { return new Rectangle(); }
}
