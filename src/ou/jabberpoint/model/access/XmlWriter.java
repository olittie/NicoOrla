package ou.jabberpoint.model.access;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import ou.jabberpoint.model.presentation.BitmapItem;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.PresentationItem;
import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.model.presentation.SlideItem;
import ou.jabberpoint.model.presentation.SlideItemAdapter;
import ou.jabberpoint.model.presentation.TextItem;


public class XmlWriter implements IPresentationWriter {

    public void write(IPresentation presentation, String fileName) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");

        PresentationIterator iterator = presentation.getIterator();

        IPresentation slide = iterator.firstSlide();
        for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++) {

            out.println("<slide>");
            out.println("<title>" + slide.getTitle() + "</title>");
            Vector<PresentationItem> slideItems = slide.getSlideItems();
            for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
            	PresentationItem slideItemAdapter = slideItems.elementAt(itemNumber);
                out.print("<item kind=");
                if (slideItemAdapter instanceof SlideItemAdapter) {
                    SlideItemAdapter adapter = (SlideItemAdapter) slideItemAdapter;
                    SlideItem slideItem = adapter.getSlideItem();
                    if (slideItem instanceof TextItem) {
                        out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
                        out.print( ( (TextItem) slideItem).getText());
                    }
                    else {
                        if (slideItem instanceof BitmapItem) {
                            out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
                            out.print( ( (BitmapItem) slideItem).getName());
                        }
                        else {
                            System.out.println("Ignoring " + slideItem);
                        }
                    }
                }
                out.println("</item>");
            }
            out.println("</slide>");

            slide = iterator.nextSlide();
        }
        out.println("</presentation>");
        out.close();
    }

}