package ou.jabberpoint.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ou.jabberpoint.controller.KeyController;
import ou.jabberpoint.controller.MenuController;
import ou.jabberpoint.controller.command.CommandFactory;
import ou.jabberpoint.controller.command.ICommandFactory;
import ou.jabberpoint.event.CommandEventListener;
import ou.jabberpoint.event.EventDispatcher;
import ou.jabberpoint.event.SlideIteratorEvent;
import ou.jabberpoint.event.SlidesEvent;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.Presentation;
import ou.jabberpoint.model.presentation.PresentationIterator;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class SlideViewerFrame extends JFrame implements CommandEventListener<SlidesEvent>  {
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	private IPresentation _presentation;
	public SlideViewerComponent slideViewerComponent;
	public EventDispatcher<SlideIteratorEvent> slideIteratorDispatcher;
	
	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);
		_presentation = presentation;
		slideIteratorDispatcher = new EventDispatcher<>();

		slideViewerComponent = new SlideViewerComponent(presentation, this);		
		presentation.slidesDispatcher.addListener(this);
		setupWindow(slideViewerComponent);
	}

// De GUI opzetten
	public void setupWindow(SlideViewerComponent slideViewerComponent) {
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});		
		ICommandFactory commandFactory = new CommandFactory(this, slideViewerComponent, _presentation);		
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(commandFactory)); // een controller toevoegen
		setMenuBar(new MenuController(commandFactory));	// nog een controller toevoegen
		setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
		setVisible(true);
	}

	@Override
	public void eventFired(SlidesEvent e) {
		// TODO Auto-generated method stub
		PresentationIterator slideIterator = _presentation.getIterator();
		slideIteratorDispatcher.fire(new SlideIteratorEvent(this, slideIterator));
		slideViewerComponent.update(slideIterator.firstSlide(), slideIterator.getCurrentSlideNumber());
	}
}
