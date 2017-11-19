package ou.jabberpoint.controller.command;

public interface ICommandFactory {
	ICommand createNewPresentationCommand();
	ICommand createOpenPresentationCommand();
	ICommand createSavePresentationCommand();
	ICommand createPreviousSlideCommand();
	ICommand createNextSlideCommand();
	ICommand createGoToSlideCommand();
	ICommand createAboutCommand();
	ICommand createExitCommand();
}
