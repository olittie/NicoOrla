package ou.jabberpoint.controller.commands;

import ou.jabberpoint.view.AboutBox;

import java.awt.*;


public class AboutCommand implements ICommand {

	private Frame _parent;
	
	public AboutCommand(Frame parentFrame)
	{
		_parent = parentFrame;
	}
	
	public void execute()
	{
		AboutBox.show(_parent);
	}
}
