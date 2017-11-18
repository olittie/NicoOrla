package ou.jabberpoint.view;

import ou.jabberpoint.model.presentation.BitmapItem;
import ou.jabberpoint.model.presentation.IStyleFactory;
import ou.jabberpoint.model.presentation.StyleFactory;
import ou.jabberpoint.model.presentation.TextItem;
import ou.jabberpoint.view.SlideViewerComponent;

public class SlideItemFactory implements ISlideItemFactory {
	
	private IStyleFactory styleFactory;
    private SlideViewerComponent slideViewer;

    public SlideItemFactory(SlideViewerComponent slideViewer) {

        styleFactory = new StyleFactory();
        this.slideViewer = slideViewer;
    }

    @Override
    public BitmapItem createBitmapItem(int level, String name) {
        return new BitmapItem(name, styleFactory.createStyle(level), new BitmapItemDrawer() );
    }

    @Override
    public TextItem createTextItem(int level, String text) {
        return new TextItem(text, styleFactory.createStyle(level), new TextItemDrawer());
    }  

}
