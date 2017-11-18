package ou.jabberpoint.event;

import java.util.EventObject;

import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.view.SlideViewerFrame;

public class SlideIteratorEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public PresentationIterator slideIterator;
	
	public SlideIteratorEvent(SlideViewerFrame source, PresentationIterator iterator) {
		super(source);
		
		slideIterator = iterator;
	}
}
