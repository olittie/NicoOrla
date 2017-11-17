package ou.jabberpoint.model.presentation;

import java.util.ArrayList;

import ou.jabberpoint.view.SlideViewerComponent;


/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
	private String showTitle; // de titel van de presentatie
	private ArrayList<PresentationItem> showList = null; // een ArrayList met de Slides

	// Gebruik van Iterators om verschillende threads te doorlopen
	// Elke thread bevat zijn eigen slidenummers
	private ArrayList<PresentationIterator> slideIters = null;
	// Huidige thread iterator
	private PresentationIterator currentSlideIter;
	private SlideViewerComponent slideViewComponent = null; // de viewcomponent voor de Slides

	public Presentation() {
		slideViewComponent = null;
		this.slideIters = new ArrayList<PresentationIterator>();
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		this.slideIters = new ArrayList<PresentationIterator>();
		clear();
	}

	public void addSlideIterator(PresentationIterator si)
	{
		// TODO
		slideIters.add(si);
	}

	public void setCurrentSlideIterator(int i)
	{
		// TODO
		currentSlideIter = slideIters.get(i);
	}

	public PresentationIterator getCurrentSlideIterator()
	{
		// TODO
		return currentSlideIter;
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	// geef het nummer van de huidige slide
	public int getSlideNumber() {
		
		if (currentSlideIter != null)
		{
			return currentSlideIter.getCurrentSlideNumber();
		}
		else
		{
			return -1;
		}
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number) {
		currentSlideIter.setCurrentSlideNumber(number);
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		currentSlideIter.prevSlide();
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide() {
		currentSlideIter.nextSlide();
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}
	
	// Verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		
		showList = new ArrayList<PresentationItem>();
		if (currentSlideIter != null)
		{
			currentSlideIter.setCurrentSlideNumber(-1);
		}
	}

	// Voeg een slide toe aan de presentatie
	public void append(PresentationItem slide) {
		showList.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public Slide getSlide(int number) {
		if (number < 0 ) // || number >= currentSlideIter.getSize())
		{
			return null;
	    }
		else
		{
			return (Slide)showList.get(number);
		}
	}

	// Geef de huidige Slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideIter.getCurrentSlideNumber());
	}

	public void exit(int n) {
		System.exit(n);
	}

}
