package ou.jabberpoint.model.presentation;

import java.util.Iterator;

/**
 * <p>PresentationIterator is een abstracte class, die het mechanisme definieert om door een presentatie heen te gaan.</p>
 * 
 * @author Nico, Orla
 *
 */

public abstract class PresentationIterator implements Iterator<PresentationItem>{
	
	public abstract int getCurrentSlideNumber();
	public abstract void setCurrentSlideNumber(int slideNumber);
	public abstract int getSize();
	
	// ga naar de eerste slide
	public abstract int firstSlide();
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public abstract int prevSlide();

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public abstract int nextSlide();
	
	// ga naar de laatste slide
	public abstract int lastSlide();
}
