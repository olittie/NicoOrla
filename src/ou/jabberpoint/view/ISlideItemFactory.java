package ou.jabberpoint.view;

import ou.jabberpoint.model.presentation.BitmapItem;
import ou.jabberpoint.model.presentation.TextItem;

public interface ISlideItemFactory {
	
	BitmapItem createBitmapItem(int level, String name);
    TextItem createTextItem(int level, String text);

}
