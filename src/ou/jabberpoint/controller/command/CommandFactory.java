package ou.jabberpoint.controller.command;

import ou.jabberpoint.model.access.AccessorFactory;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationBuilder;
import ou.jabberpoint.view.SlideItemFactory;
import ou.jabberpoint.view.SlideViewerComponent;
import ou.jabberpoint.view.SlideViewerFrame;

public class CommandFactory implements ICommandFactory {
		
	private SlideViewerComponent component;
	private SlideViewerFrame frame;
	private IPresentation presentation;
	
	public CommandFactory(SlideViewerFrame slideViewerFrame, SlideViewerComponent slideViewComponent, IPresentation p) {
		frame = slideViewerFrame;
		presentation = p;
		component = slideViewComponent;
	}
		
	public ICommand createNewPresentationCommand() {
		return new NewPresentationCommand(presentation, frame);
	}

	public ICommand createOpenPresentationCommand()
	{
		return new OpenPresentationCommand(presentation, frame, new AccessorFactory( new SlideItemFactory(component)));
	}
	
	public ICommand createSavePresentationCommand()
	{
		return new SavePresentationCommand(presentation, frame, new PresentationBuilder(), new AccessorFactory( new SlideItemFactory(component)));
	}
	
	public ICommand createPreviousSlideCommand() {
		return new PreviousSlideCommand(frame, component);
	}
	
	public ICommand createNextSlideCommand() {
		return new NextSlideCommand(frame, component);
	}
	
	public ICommand createGoToSlideCommand() {
		return new GoToSlideCommand(frame, component);
	}
	
	public ICommand createAboutCommand()
	{
		return new AboutCommand(frame);
	}
	
	public ICommand createExitCommand()
	{
		return new ExitCommand();
	}
}
