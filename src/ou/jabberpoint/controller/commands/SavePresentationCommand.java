package ou.jabberpoint.controller.commands;

import javax.swing.*;

import ou.jabberpoint.model.access.Accessor;
import ou.jabberpoint.model.access.AccessorFactory;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.view.SlideViewerFrame;

import java.io.IOException;


public class SavePresentationCommand implements ICommand {
	
	public static final String SAVEFILE = "dump.xml";
	public static final String SAVEERR = "Save Error";
	public static final String IOEX = "IO Exception: ";

	private IPresentation _presentation;
	private SlideViewerFrame _frame;
	private AccessorFactory _accessorFactory;
//	private IPresentationBuilder _builder;

	public SavePresentationCommand(IPresentation presentation, SlideViewerFrame frame, IPresentationBuilder builder, AccessorFactory accessorFactory) {
		_presentation = presentation;
		_frame = frame;
		_accessorFactory = accessorFactory;
//		_builder = builder;
	}
	
	public void execute()
	{
		Accessor xmlAccessor = _accessorFactory.createAccessor(SAVEFILE);

		try {
			xmlAccessor.saveFile(_presentation, SAVEFILE);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(_frame, IOEX + exc, 
					SAVEERR, JOptionPane.ERROR_MESSAGE);
		}
	}	
}
