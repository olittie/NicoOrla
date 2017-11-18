package ou.jabberpoint.model.presentation;

import java.awt.Color;

public class StyleFactory implements IStyleFactory {

	@Override
	public Style createStyle(int level) {
		// TODO Auto-generated method stub
		
		switch (level) {
	        case 1:
	            return new Style(level, 20, Color.blue,  40, 10);
	        case 2:
	            return new Style(level, 50, Color.black, 36, 10);
	        case 3:
	            return new Style(level, 70, Color.black, 30, 10);
	        case 4:
	            return new Style(level, 90, Color.black, 24, 10);
	        default:
	            return new Style(level, 0, Color.red, 48, 20);
	    }
	}
}
