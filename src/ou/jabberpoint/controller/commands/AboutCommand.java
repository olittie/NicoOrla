package ou.jabberpoint.controller.commands;

import ou.jabberpoint.view.AboutBox;

import java.awt.*;


public class AboutCommand implements ICommand {

	private Frame parent;
	
	public AboutCommand(Frame parentFrame)
	{
		parent = parentFrame;
	}
	
	public void execute()
	{
		AboutBox.show(parent);
	}
}
