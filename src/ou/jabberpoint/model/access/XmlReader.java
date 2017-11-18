package ou.jabberpoint.model.access;

import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.model.presentation.Slide;
import ou.jabberpoint.view.ISlideItemFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReader extends AbstractPresentationReader implements IPresentationReader {
	
	/** namen van xml tags of attributen */
	public static final String SHOWTITLE = "showtitle";
	public static final String SLIDETITLE = "title";
	public static final String SLIDE = "slide";
	public static final String ITEM = "item";
	public static final String LEVEL = "level";
	public static final String KIND = "kind";
	public static final String TEXT = "text";
	public static final String IMAGE = "image";

	/** tekst van messages */
	public static final String PCE = "Parser Configuration Exception";
	public static final String UNKNOWNTYPE = "Unknown Element type";
	public static final String NFE = "Number Format Exception";

    public XmlReader(ISlideItemFactory slideItemFactory, IPresentationBuilder builder) {
        super(slideItemFactory, builder);
    }

    public void read(IPresentation presentation, String fileName) throws IOException {
        int slideNumber, itemNumber, max = 0, maxItems = 0;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(fileName)); // maak een JDOM document
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, SHOWTITLE));
            _builder.setPresentation(presentation);

            NodeList slides = doc.getElementsByTagName(SLIDE);
            max = slides.getLength();
            for (slideNumber = 0; slideNumber < max; slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);
                Slide slide = new Slide(getTitle(xmlSlide, SLIDETITLE));
                _builder.addSlide(slide);

                NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
                maxItems = slideItems.getLength();
                for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(item);
                }
            }

            presentation = _builder.getResult();
        }
        catch (IOException iox) {
            System.err.println(iox.toString());
        }
        catch (SAXException sax) {
            System.err.println(sax.getMessage());
        }
        catch (ParserConfigurationException pcx) {
            System.err.println(PCE);
        }
    }

    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();
    }

    private void loadSlideItem(Element item) {
        int level = 1; // default
        NamedNodeMap attributes = item.getAttributes();
        String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
        if (leveltext != null) {
            try {
                level = Integer.parseInt(leveltext);
            }
            catch(NumberFormatException x) {
                System.err.println(NFE);
            }
        }
        String type = attributes.getNamedItem(KIND).getTextContent();
        if (TEXT.equals(type)) {

            _builder.addSlideItem(_slideItemfactory.createTextItem(level, item.getTextContent()));
        }
        else {
            if (IMAGE.equals(type)) {
                _builder.addSlideItem(_slideItemfactory.createBitmapItem(level, item.getTextContent()));
            }
            else {
                System.err.println(UNKNOWNTYPE);
            }
        }
    }
}
