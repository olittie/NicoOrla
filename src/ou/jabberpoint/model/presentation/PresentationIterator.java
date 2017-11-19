package ou.jabberpoint.model.presentation;

import java.util.Iterator;

/**
 * <p>PresentationIterator is een interface, die het mechanisme definieert om door een presentatie heen te gaan.</p>
 * <p>java.util.Iterator wordt (nog) niet gebruikt. </>
 * @author Nico, Orla
 *
 */

public interface PresentationIterator extends Iterator<PresentationItem> {
	
	int getCurrentSlideNumber();
	IPresentation setCurrentSlideNumber(int slideNumber);
	int getSize();
		
	// ga naar de eerste slide
	IPresentation firstSlide();
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	IPresentation prevSlide();

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	IPresentation nextSlide();
	
	// ga naar de laatste slide
	IPresentation lastSlide();
	
	int getIndex();	

}
