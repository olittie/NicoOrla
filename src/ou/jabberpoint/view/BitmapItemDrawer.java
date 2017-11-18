package ou.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ou.jabberpoint.model.presentation.AbstractSlideItemDrawer;
import ou.jabberpoint.model.presentation.Style;

public class BitmapItemDrawer extends AbstractSlideItemDrawer {

    public void drawBitmap(Graphics g, int x, int y, float scale, Style style, BufferedImage image) {
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getIndent() * scale);

        g.drawImage(image, width, height,(int) (image.getWidth()*scale),
                (int) (image.getHeight()*scale), null);
    }

    public Rectangle getBoundingBox(Graphics g, float scale, Style style, BufferedImage image) {
        return new Rectangle((int) (style.getIndent() * scale), 0,
                (int) (image.getWidth() * scale),
                ((int) (style.getLeading() * scale)) +
                        (int) (image.getHeight() * scale));
    }
}
