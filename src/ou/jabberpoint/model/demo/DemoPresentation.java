package ou.jabberpoint.model.demo;

import java.io.IOException;
import java.util.ArrayList;

import ou.jabberpoint.model.access.Accessor;
import ou.jabberpoint.model.access.IPresentationReader;
import ou.jabberpoint.model.access.IPresentationWriter;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.model.presentation.Slide;
import ou.jabberpoint.view.ISlideItemFactory;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class DemoPresentation extends Accessor {
	
//	protected final ISlideItemFactory slideItemfactory;
//	protected final IPresentationBuilder builder;
//	
//	public DemoPresentation(ISlideItemFactory slideItemFactory, IPresentationBuilder builder) {
//		this.slideItemfactory = slideItemFactory;
//		this.builder = builder;
//		
//	}
	
	
	public DemoPresentation(IPresentationReader reader, IPresentationWriter writer) {
		super(reader, writer);
	}
//	public void loadFile(PresentationItemAdapter presentation, String unusedFilename) {
//		presentation.setTitle("Demo Presentation");
//		PresentationItem slide;
//		slide = new Slide("JabberPoint");
//		
//		// TODO Factory voor slide items
//		
//		slide.append(slideItemFactory.)
//		slide.append(new TextItemAdapter(1, "Het Java Presentatie Tool"));
//		slide.append(new TextItemAdapter(2, "Copyright (c) 1996-2000: Ian Darwin"));
//		slide.append(new TextItemAdapter(2, "Copyright (c) 2000-now:"));
//		slide.append(new TextItemAdapter(2, "Gert Florijn en Sylvia Stuurman"));
//		slide.append(new TextItemAdapter(4, "JabberPoint aanroepen zonder bestandsnaam"));
//		slide.append(new TextItemAdapter(4, "laat deze presentatie zien"));
//		slide.append(new TextItemAdapter(1, "Navigeren:"));
//		slide.append(new TextItemAdapter(3, "Volgende slide: PgDn of Enter"));
//		slide.append(new TextItemAdapter(3, "Vorige slide: PgUp of up-arrow"));
//		slide.append(new TextItemAdapter(3, "Stoppen: q or Q"));
//		presentation.append(slide);
//
//		slide = new Slide("Demonstratie van levels en stijlen");
//		slide.append(new TextItemAdapter(1, "Level 1"));
//		slide.append(new TextItemAdapter(2, "Level 2"));
//		slide.append(new TextItemAdapter(1, "Nogmaals level 1"));
//		slide.append(new TextItemAdapter(1, "Level 1 heeft stijl nummer 1"));
//		slide.append(new TextItemAdapter(2, "Level 2 heeft stijl nummer 2"));
//		slide.append(new TextItemAdapter(3, "Zo ziet level 3 er uit"));
//		slide.append(new TextItemAdapter(4, "En dit is level 4"));
//		presentation.append(slide);
//
//		slide = new Slide("De derde slide");
//		slide.append(new TextItemAdapter(1, "Om een nieuwe presentatie te openen,"));
//		slide.append(new TextItemAdapter(2, "gebruik File->Open uit het menu."));
//		slide.append(new TextItemAdapter(1, " "));
//		slide.append(new TextItemAdapter(1, "Dit is het einde van de presentatie."));
//		slide.append(new BitmapItemAdapter(1, "JabberPoint.jpg"));
//		presentation.append(slide);
//		
//		// maak een iterator aan voor 1 thread
//		// todo factory voor iterator
//		ArrayList<Integer> threadNumbers = new ArrayList<Integer>();
//		threadNumbers.add(0);
//		threadNumbers.add(1);
//		threadNumbers.add(2);
//		threadNumbers.add(0);
//		PresentationIterator si = new SlideIterator(threadNumbers);
//		presentation.addSlideIterator(si);
//		presentation.setCurrentSlideIterator(0);
//	}
//
//	public void saveFile(IPresentation presentation, String unusedFilename) {
//		throw new IllegalStateException("Save As->Demo! aangeroepen");
//	}
//
//	@Override
//	public void loadFile(IPresentation p, String fn) throws IOException {
//		// TODO Auto-generated method stub
//		
//	}
}
