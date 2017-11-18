package ou.jabberpoint.controller.commands;

import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.view.SlideViewerFrame;

public class NewPresentationCommand implements ICommand {

	private IPresentation presentation;
	private SlideViewerFrame frame;
	
	public NewPresentationCommand(IPresentation presentation, SlideViewerFrame frame)
	{
		this.presentation = presentation;
		this.frame = frame;
	}
	
	public void execute()
	{
		presentation.clear();
		frame.repaint();
	}	
}
