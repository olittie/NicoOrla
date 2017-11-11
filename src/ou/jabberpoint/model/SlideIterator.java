package ou.jabberpoint.model;

import java.util.ArrayList;

/**
 * <p>SlideIterator is een concrete class om door een presentatie heen te gaan.</p>
 * 
 * @author Nico, Orla
 *
 */

public class SlideIterator extends PresentationIterator {
	
	private ArrayList<Integer> numbers; // een ArrayList met de slidenummers
	private ArrayList<PresentationItem> slides; // een ArrayList met de slides
	private int currentNumber = 0;
	
	public SlideIterator(ArrayList<PresentationItem> slides, ArrayList<Integer> numbers)
	{
		this.slides = slides;
		this.numbers = numbers;
	}
	
	//TODO
	public void setSlides(ArrayList<PresentationItem> slides) {
		this.slides = slides;
	}
	
	// ga naar de eerste slide
	public PresentationItem firstSlide()
	{
		currentNumber = 0;
		return slides.get(numbers.get(0));
	}
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public PresentationItem prevSlide()
	{
		// TODO indien 0 is bereikt
		return slides.get(numbers.get(currentNumber-1));
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public PresentationItem nextSlide()
	{
		// TODO indien max is bereikt
		return slides.get(numbers.get(currentNumber+1));
	}
	
	// ga naar de laatste slide
	public PresentationItem lastSlide()
	{
		return slides.get(numbers.get(numbers.size()-1));
	}
}
