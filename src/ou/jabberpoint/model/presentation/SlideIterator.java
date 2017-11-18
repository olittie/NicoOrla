package ou.jabberpoint.model.presentation;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

/**
 * <p>SlideIterator is een concrete class om door een presentatie heen te gaan.</p>
 * 
 * @author Nico, Orla
 *
 */

public class SlideIterator extends Observable implements PresentationIterator {
	
	private ArrayList<Integer> threadNumbers; // een ArrayList met de slidenummers
	private int currentSlideNumber; // verwijst naar het slidenummer in de thread
	
	private Vector<IPresentation> slides;
	
	public SlideIterator(Vector<IPresentation> slides) {
		this.slides = slides;
		currentSlideNumber = 0;
		threadNumbers = new ArrayList<>();
	}
	public SlideIterator(Vector<IPresentation> slides, ArrayList<Integer> thread) {
		this.slides = slides;
		currentSlideNumber = 0;
		threadNumbers = thread;
	}
	
	// geef huidige Slidenummer
	public int getCurrentSlideNumber()
	{
		return currentSlideNumber;
	}
	
	// zet index (slidenummer) in de huidige thread
	public IPresentation setCurrentSlideNumber(int slideNumber) {
//		if (currentSlideNumber < getSize())
//		{
//			this.currentSlideNumber = currentSlideNumber;
//			currentSlideNumber = slides.;
//		}
//		// deze code zet een slidenumber geen threadnumber
////		boolean found = false;
////		for (int i = 0; (i < getSize()) && (found == false) ; i++)
////		{
////			if (threadNumbers.get(i) == slideNumber)
////			{
////				index = i;
////				currentSlideNumber = threadNumbers.get(index);
////				found = true;
////			}
////		}
		
		if( getSize() == 0 )
		{
			return null;
		}
		
		if(slideNumber < 0)
		{
			currentSlideNumber = 0;
		}
		else if( slideNumber >= getSize() )
		{
			currentSlideNumber = getSize() - 1;
		}
		else
		{
			currentSlideNumber = slideNumber;
		}
		int index;
		if (threadNumbers.size() == 0) {
			index = currentSlideNumber;
		}
		else {
			index = threadNumbers.get(currentSlideNumber);
		}
		return slides.get(index);
	}	
	
	public int getSize() {
		if (threadNumbers.size() == 0) {
			return slides.size();
		}
		else {
			return threadNumbers.size();
		}
	}
	
	public int getIndex() {
		return this.currentSlideNumber;
	}
	
	// ga naar de eerste slide
	public IPresentation firstSlide()
	{
		return setCurrentSlideNumber(0);
	}
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public IPresentation prevSlide()
	{
		currentSlideNumber--;
		return setCurrentSlideNumber(currentSlideNumber);
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public IPresentation nextSlide()
	{
		currentSlideNumber++;
		return setCurrentSlideNumber(currentSlideNumber);
	}
	
	// ga naar de laatste slide
	public IPresentation lastSlide()
	{
		return setCurrentSlideNumber(getSize());
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PresentationItem next() {
		// TODO Auto-generated method stub
		return null;
	}
}
