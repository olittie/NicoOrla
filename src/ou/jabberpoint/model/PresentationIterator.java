package ou.jabberpoint.model;

/**
 * <p>PresentationIterator is een abstracte class, die het mechanisme definieert om door een presentatie heen te gaan.</p>
 * 
 * @author Nico, Orla
 *
 */

public abstract class PresentationIterator {
	
	// ga naar de eerste slide
	public abstract PresentationItem firstSlide();
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public abstract PresentationItem prevSlide();

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public abstract PresentationItem nextSlide();
	
	// ga naar de laatste slide
	public abstract PresentationItem lastSlide();
}
