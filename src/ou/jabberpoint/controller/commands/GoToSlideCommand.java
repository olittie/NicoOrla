package ou.jabberpoint.controller.commands;

import ou.jabberpoint.event.CommandEventListener;
import ou.jabberpoint.event.SlideIteratorEvent;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.view.SlideViewerComponent;
import ou.jabberpoint.view.SlideViewerFrame;

import javax.swing.*;


public class GoToSlideCommand implements ICommand, CommandEventListener<SlideIteratorEvent> {
	
	public static final String PAGENR = "Page number?";

	private PresentationIterator _presentationIterator;
	private SlideViewerComponent _slideViewComponent;
	
	public GoToSlideCommand(SlideViewerFrame frame, SlideViewerComponent slideViewComponent )
	{
		_presentationIterator = null;
		_slideViewComponent = slideViewComponent;
		
		frame.slideIteratorDispatcher.addListener(this);
	}

	public void execute()
	{
		if(_presentationIterator != null)
		{
			String slideNumberStr = JOptionPane.showInputDialog(PAGENR);
			int slideNumber = Integer.parseInt(slideNumberStr);

			IPresentation slide = _presentationIterator.setCurrentSlideNumber(slideNumber - 1);
			_slideViewComponent.update(slide, _presentationIterator.getCurrentSlideNumber());
		}
	}
	
	@Override
	public void eventFired(SlideIteratorEvent event)
	{
		_presentationIterator = event.slideIterator;
	}
}
