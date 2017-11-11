package ou.jabberpoint.model.presentation;

import java.util.ArrayList;

/**
 * <p>SlideIterator is een concrete class om door een presentatie heen te gaan.</p>
 * 
 * @author Nico, Orla
 *
 */

public class SlideIterator extends PresentationIterator {
	
	private ArrayList<Integer> threadNumbers; // een ArrayList met de slidenummers
	private int index = 0;
	private int currentSlideNumber = 0;
	
	public SlideIterator(ArrayList<Integer> numbers)
	{
		this.threadNumbers = numbers;
		currentSlideNumber = threadNumbers.get(0);
	}
	
	// geef huidige Slidenummer
	public int getCurrentSlideNumber()
	{
		return currentSlideNumber;
	}
	
	// geef huidige Slidenummer
	public void setCurrentSlideNumber(int slideNumber)
	{
		boolean found = false;
		for (int i = 0; (i < getSize()) && (found == false) ; i++)
		{
			if (threadNumbers.get(i) == slideNumber)
			{
				index = i;
				currentSlideNumber = threadNumbers.get(index);
				found = true;
			}
		}
	}
	
	public int getSize() {
		return this.threadNumbers.size();
	}
	
	public int getIndex() {
		return this.index;
	}
	
	// ga naar de eerste slide
	public int firstSlide()
	{
		index = 0;
		currentSlideNumber = threadNumbers.get(index);
		return currentSlideNumber;
	}
	
	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public int prevSlide()
	{
		if (index > 0) 
		{
			index = index - 1;
			currentSlideNumber = threadNumbers.get(index);
		}
		return currentSlideNumber;
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public int nextSlide()
	{
		if (index < (this.getSize()-1)) {
			index = index + 1;
			currentSlideNumber = threadNumbers.get(index);
		}
		return currentSlideNumber;
	}
	
	// ga naar de laatste slide
	public int lastSlide()
	{
		index = this.getSize() - 1;
		currentSlideNumber = threadNumbers.get(index);
		return currentSlideNumber;
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
