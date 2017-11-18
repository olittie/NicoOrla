package ou.jabberpoint.controller.commands;

import ou.jabberpoint.model.access.Accessor;
import ou.jabberpoint.model.access.AccessorFactory;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.view.SlideViewerFrame;

import javax.swing.*;
import java.io.IOException;

public class OpenPresentationCommand implements ICommand {
	

	public static final String TESTFILE = "test.xml";
	public static final String IOEX = "IO Exception: ";
	public static final String LOADERR = "Load Error";
	
	private SlideViewerFrame _frame;
	private IPresentation _presentation;
	private AccessorFactory _accessorFactory;
	
	public OpenPresentationCommand(IPresentation presentation, SlideViewerFrame frame, AccessorFactory accessorFactory )
	{
		_frame = frame;
		_presentation = presentation;
		_accessorFactory = accessorFactory;
	}	
	
	public void execute()
	{
		_presentation.clear();

		Accessor accessor = _accessorFactory.createAccessor(TESTFILE);

		try {
			accessor.loadFile(_presentation, TESTFILE);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(_frame, IOEX + exc, 
					LOADERR, JOptionPane.ERROR_MESSAGE);
		}

		_frame.repaint();
	}	
}
