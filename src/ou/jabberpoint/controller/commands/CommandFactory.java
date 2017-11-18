package ou.jabberpoint.controller.commands;

import ou.jabberpoint.model.access.AccessorFactory;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationBuilder;
import ou.jabberpoint.view.SlideItemFactory;
import ou.jabberpoint.view.SlideViewerComponent;
import ou.jabberpoint.view.SlideViewerFrame;

public class CommandFactory implements ICommandFactory {
		
	private SlideViewerComponent _slideViewComponent;
	private SlideViewerFrame _frame;
	private IPresentation _presentation;
	
	public CommandFactory(SlideViewerFrame frame, SlideViewerComponent slideViewComponent, IPresentation presentation) {
		_frame = frame;
		_presentation = presentation;
		_slideViewComponent = slideViewComponent;
	}
		
	public ICommand createNewPresentationCommand() {
		return new NewPresentationCommand(_presentation, _frame);
	}

	public ICommand createOpenPresentationCommand()
	{
		return new OpenPresentationCommand(_presentation, _frame, new AccessorFactory( new SlideItemFactory(_slideViewComponent)));
	}
	
	public ICommand createSavePresentationCommand()
	{
		return new SavePresentationCommand(_presentation, _frame, new PresentationBuilder(), new AccessorFactory( new SlideItemFactory(_slideViewComponent)));
	}
	
	public ICommand createPreviousSlideCommand() {
		return new PreviousSlideCommand(_frame, _slideViewComponent);
	}
	
	public ICommand createNextSlideCommand() {
		return new NextSlideCommand(_frame, _slideViewComponent);
	}
	
	public ICommand createGoToSlideCommand() {
		return new GoToSlideCommand(_frame, _slideViewComponent);
	}
	
	public ICommand createAboutCommand()
	{
		return new AboutCommand(_frame);
	}
	
	public ICommand createExitCommand()
	{
		return new ExitCommand();
	}
}
