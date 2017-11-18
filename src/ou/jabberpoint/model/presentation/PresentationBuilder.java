package ou.jabberpoint.model.presentation;

import java.util.ArrayList;

public class PresentationBuilder implements IPresentationBuilder{
	
	private IPresentation result;

    private PresentationItem lastSlide;

    public PresentationBuilder() {
        clear();
    }

    @Override
    public IPresentation getResult() {
        this.appendLastSlideToResult();
        return result;
    }

    @Override
    public void clear() {
    	result = null;
    	lastSlide = null;
    }

    @Override
    public IPresentationBuilder setPresentation(IPresentation presentation) {
    	result = presentation;
        return this;
    }

    @Override
    public IPresentationBuilder addSlide(PresentationItem slide) {
        if (result == null) {
            throw new NullPointerException("Cannot add a slide when no presentation is set.");
        }

        this.appendLastSlideToResult();

        lastSlide = slide;
        return this;
    }

    @Override
    public IPresentationBuilder addSlideItem(SlideItem slideItem) {
        if (lastSlide == null) {
            throw new NullPointerException("Cannot add a slide item when no slide has been added.");
        }

        SlideItemAdapter adapter = new SlideItemAdapter(slideItem);
        lastSlide.addItem(adapter);
        return this;
    }

    private void appendLastSlideToResult() {
        if (lastSlide != null) {
        	PresentationItemAdapter adapter = new PresentationItemAdapter(lastSlide);
        	result.addItem(adapter);
        	lastSlide = null;
        }
    }

	@Override
	public IPresentationBuilder addThread(ArrayList<Integer> thread) {
		if (result == null) {
            throw new NullPointerException("Cannot add a thread when no presentation is set.");
        }
		result.addThread(thread);        
        return this;
	}

}
