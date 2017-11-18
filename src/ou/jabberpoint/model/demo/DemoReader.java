package ou.jabberpoint.model.demo;

import java.util.ArrayList;

import ou.jabberpoint.model.access.AbstractPresentationReader;
import ou.jabberpoint.model.access.IPresentationReader;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.model.presentation.Slide;
import ou.jabberpoint.view.ISlideItemFactory;

public class DemoReader extends AbstractPresentationReader implements IPresentationReader {

    public DemoReader(ISlideItemFactory slideItemFactory, IPresentationBuilder builder) {
        super(slideItemFactory, builder);
    }

    public void read(IPresentation presentation, String fileName) {
        presentation.setTitle("Demo Presentation");
        _builder.setPresentation(presentation)
                .addSlide(new Slide("JabberPoint"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Het Java Presentatie Tool"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "Copyright (c) 1996-2000: Ian Darwin"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "Copyright (c) 2000-now:"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "Gert Florijn en Sylvia Stuurman"))
                .addSlideItem(_slideItemfactory.createTextItem(4, "JabberPoint aanroepen zonder bestandsnaam"))
                .addSlideItem(_slideItemfactory.createTextItem(4, "laat deze presentatie zien"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Navigeren:"))
                .addSlideItem(_slideItemfactory.createTextItem(3, "Volgende slide: PgDn of Enter"))
                .addSlideItem(_slideItemfactory.createTextItem(3, "Vorige slide: PgUp of up-arrow"))
                .addSlideItem(_slideItemfactory.createTextItem(3, "Stoppen: q or Q"))
                .addSlide(new Slide("Demonstratie van levels en stijlen"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Level 1"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "Level 2"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Nogmaals level 1"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Level 1 heeft stijl nummer 1"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "Level 2 heeft stijl nummer 2"))
                .addSlideItem(_slideItemfactory.createTextItem(3, "Zo ziet level 3 er uit"))
                .addSlideItem(_slideItemfactory.createTextItem(4, "En dit is level 4"))
                .addSlide(new Slide("De derde slide"))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Om een nieuwe presentatie te openen,"))
                .addSlideItem(_slideItemfactory.createTextItem(2, "gebruik File->Open uit het menu."))
                .addSlideItem(_slideItemfactory.createTextItem(1, " "))
                .addSlideItem(_slideItemfactory.createTextItem(1, "Dit is het einde van de presentatie."))
                .addSlideItem(_slideItemfactory.createBitmapItem(1, "JabberPoint.jpg"));
        
     // maak een iterator aan voor 1 thread
     		// todo factory voor iterator
     		ArrayList<Integer> threadNumbers = new ArrayList<Integer>();
     		threadNumbers.add(0);
     		threadNumbers.add(1);
     		threadNumbers.add(2);
     		threadNumbers.add(0);
//     		PresentationIterator si = new SlideIterator(threadNumbers);
//     		presentation.addSlideIterator(si);
//     		presentation.setCurrentSlideIterator(0);

        presentation = _builder.getResult();
    }
}
