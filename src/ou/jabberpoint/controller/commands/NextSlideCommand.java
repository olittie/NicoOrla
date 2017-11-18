package ou.jabberpoint.controller.commands;

import ou.jabberpoint.event.CommandEventListener;
import ou.jabberpoint.event.SlideIteratorEvent;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.view.SlideViewerComponent;
import ou.jabberpoint.view.SlideViewerFrame;

public class NextSlideCommand implements ICommand, CommandEventListener<SlideIteratorEvent> {
	
	private PresentationIterator _presentationIterator;
	private SlideViewerComponent _slideViewComponent;
	
	public NextSlideCommand(SlideViewerFrame frame, SlideViewerComponent slideViewComponent )
	{
		_presentationIterator = null;
		_slideViewComponent = slideViewComponent;
		frame.slideIteratorDispatcher.addListener(this);
	}

	public void execute()
	{
		if(_presentationIterator != null)
		{
			IPresentation slide = _presentationIterator.nextSlide();
			_slideViewComponent.update(slide, _presentationIterator.getCurrentSlideNumber());
		}
	}
	
	@Override
	public void eventFired(SlideIteratorEvent event)
	{
		_presentationIterator = event.slideIterator;
	}
}
