package ou.jabberpoint.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ou.jabberpoint.model.presentation.AbstractSlideItemDrawer;
import ou.jabberpoint.model.presentation.Slide;
import ou.jabberpoint.model.presentation.Style;

public class TextItemDrawer extends AbstractSlideItemDrawer {
	
	public void drawText(Graphics g, int x, int y, float scale, Style style, String text) {
        java.util.List<TextLayout> layouts = getLayouts(text, g, style, scale);
        Point pen = new Point(x + (int)(style.getIndent() * scale),
                y + (int) (style.getLeading() * scale));
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(style.getColor());
        Iterator<TextLayout> it = layouts.iterator();

        while (it.hasNext()) {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    public Rectangle getBoundingBox(Graphics g, float scale, Style style, String text) {
        List<TextLayout> layouts = getLayouts(text, g, style, scale);
        int xsize = 0, ysize = (int) (style.getLeading() * scale);
        Iterator<TextLayout> iterator = layouts.iterator();

        while (iterator.hasNext()) {
            TextLayout layout = iterator.next();
            Rectangle2D bounds = layout.getBounds();

            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }

            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }

            ysize += layout.getLeading() + layout.getDescent();
        }

        return new Rectangle(xsize, ysize);
    }

    private AttributedString getAttributedString(String text, Style style, float scale) {
        AttributedString attrStr = new AttributedString(text);
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
        return attrStr;
    }

    private java.util.List<TextLayout> getLayouts(String text, Graphics g, Style s, float scale) {
        java.util.List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attrStr = getAttributedString(text, s, scale);
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - s.getIndent()) * scale;

        while (measurer.getPosition() < text.length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

}
