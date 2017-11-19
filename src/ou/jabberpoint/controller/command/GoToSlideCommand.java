package ou.jabberpoint.controller.command;

import ou.jabberpoint.event.CommandEventListener;
import ou.jabberpoint.event.SlideIteratorEvent;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.view.SlideViewerComponent;
import ou.jabberpoint.view.SlideViewerFrame;

import javax.swing.*;


public class GoToSlideCommand implements ICommand, CommandEventListener<SlideIteratorEvent> {
	
	public static final String PAGENR = "Page number?";

	private PresentationIterator presentationIterator;
	private SlideViewerComponent slideViewComponent;
	
	public GoToSlideCommand(SlideViewerFrame frame, SlideViewerComponent component )
	{
		presentationIterator = null;
		slideViewComponent = component;
		
		frame.slideIteratorDispatcher.addListener(this);
	}

	public void execute()
	{
		if(presentationIterator != null)
		{
			String slideNumberStr = JOptionPane.showInputDialog(PAGENR);
			int slideNumber = Integer.parseInt(slideNumberStr);

			IPresentation slide = presentationIterator.setCurrentSlideNumber(slideNumber - 1);
			slideViewComponent.update(slide, presentationIterator.getCurrentSlideNumber());
		}
	}
	
	@Override
	public void eventFired(SlideIteratorEvent event)
	{
		presentationIterator = event.slideIterator;
	}
}
