package ou.jabberpoint.model.presentation;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/** <p>Een adapter voor een tekst item.</p>
 * <p>De adapter maakt van een TextItem een SlideItem.</p>
 * <p>De draw wordt omgezet.</p>
 * 
 * @author Nico
 *
 */

public class TextItemAdapter extends SlideItem {
	private String text;
	private TextItem textItem;
	private int yPos;
	
	private static final String EMPTYTEXT = "No Text Given";

// een textitem van level level, met als tekst string
	public TextItemAdapter(int level, String string) {
		super(level);
		text = string;
		this.textItem = new TextItem(level, string);
	}

// een leeg textitem
	public TextItemAdapter() {
		this(0, EMPTYTEXT);
		this.textItem = new TextItem();
		
	}
	
// Geef de tekst
	public String getText() {
		return text == null ? "" : text;
	}

// Geef de yPos;
	public int getYPosHeight() {
		return yPos;
	}
	
// teken het item
	public void draw(Graphics g, Rectangle area, ImageObserver view)
	{
	    Style style = Style.getStyle(this.getLevel());
		float scale = super.getScale(area);

		this.textItem.draw(area.x, area.y, scale, g, style, view);
	    yPos = this.textItem.getBoundingBox(g, view, scale, style).height;
	}


	public String toString() {
		return "TextItemAdapter[" + super.getLevel()+","+getText()+"]";
	}
}
