package ou.jabberpoint.model.presentation;

import java.util.ArrayList;

public interface IPresentationBuilder {
	
	IPresentation getResult();

    void clear();

    IPresentationBuilder setPresentation(IPresentation presentation);
    
    IPresentationBuilder addThread(ArrayList<Integer> thread);

    IPresentationBuilder addSlide(PresentationItem slide);

    IPresentationBuilder addSlideItem(SlideItem slideItem);

}
