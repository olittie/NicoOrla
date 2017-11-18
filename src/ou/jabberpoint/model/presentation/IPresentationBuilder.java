package ou.jabberpoint.model.presentation;

public interface IPresentationBuilder {
	
	IPresentation getResult();

    void clear();

    IPresentationBuilder setPresentation(IPresentation presentation);

    IPresentationBuilder addSlide(PresentationItem slide);

    IPresentationBuilder addSlideItem(SlideItem slideItem);

}
