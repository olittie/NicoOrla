	package ou.jabberpoint.model.access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ou.jabberpoint.model.presentation.BitmapItem;
import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.model.presentation.PresentationItem;
import ou.jabberpoint.model.presentation.PresentationIterator;
import ou.jabberpoint.model.presentation.Slide;
import ou.jabberpoint.model.presentation.SlideItem;
import ou.jabberpoint.model.presentation.SlideItemAdapter;
import ou.jabberpoint.model.presentation.SlideIterator;
import ou.jabberpoint.model.presentation.TextItem;
import ou.jabberpoint.view.BitmapItemDrawer;
import ou.jabberpoint.view.ISlideItemFactory;
import ou.jabberpoint.view.TextItemDrawer;


/** XMLAccessor, reads and writes XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor extends Accessor {
	
//    /** Default API to use. */
//    protected static final String DEFAULT_API_TO_USE = "dom";
//    
//    /** namen van xml tags of attributen */
//    protected static final String SHOWTITLE = "showtitle";
//    protected static final String SLIDETITLE = "title";
//    protected static final String SLIDE = "slide";
//    protected static final String ITEM = "item";
//    protected static final String LEVEL = "level";
//    protected static final String KIND = "kind";
//    protected static final String TEXT = "text";
//    protected static final String IMAGE = "image";
//    protected static final String THREAD = "thread";
//    protected static final String SLIDENUMBER = "slidenumber";
//    
//    /** tekst van messages */
//    protected static final String PCE = "Parser Configuration Exception";
//    protected static final String UNKNOWNTYPE = "Unknown Element type";
//    protected static final String NFE = "Number Format Exception";
//    
//    protected final ISlideItemFactory slideItemfactory;
//	protected final IPresentationBuilder builder;
	
	public XMLAccessor(IPresentationReader reader, IPresentationWriter writer) {
		super(reader, writer);
	}
	
//	public XMLAccessor(ISlideItemFactory slideItemFactory, IPresentationBuilder builder) {
//		this.slideItemfactory = slideItemFactory;
//		this.builder = builder;
//		
//	}
//    
//    private String getTitle(Element element, String tagName) {
//    	NodeList titles = element.getElementsByTagName(tagName);
//    	return titles.item(0).getTextContent();
//    	
//    }
//
//	public void loadFile(IPresentation presentation, String filename) throws IOException {
//		int slideNumber, itemNumber, max = 0, maxItems = 0;		
//		
//		try {
//			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
//			Document document = builder.parse(new File(filename)); // maak een JDOM document
//			Element doc = document.getDocumentElement();
//			presentation.setTitle(getTitle(doc, SHOWTITLE));
//			this.builder.setPresentation(presentation);
//
//			NodeList slides = doc.getElementsByTagName(SLIDE);
//			max = slides.getLength();
//			for (slideNumber = 0; slideNumber < max; slideNumber++) {
//				Element xmlSlide = (Element) slides.item(slideNumber);
//				// TODO PrsentationItemFactory voor Slide
//				Slide slide = new Slide();
//				slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
//				this.builder.addSlide(slide);
//				
//				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
//				maxItems = slideItems.getLength();
//				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
//					Element item = (Element) slideItems.item(itemNumber);
//					loadSlideItem(slide, item);
//				}
//			}
//			
//			
//			// Toevoeging van threads iterators	
////			NodeList threads = doc.getElementsByTagName(THREAD);
////			max = threads.getLength();
////			for (int threadNumber = 0; threadNumber < max; threadNumber++) {
////				
////				ArrayList<Integer> numbers = new ArrayList<Integer>();
////				
////				Element xmlThread = (Element) threads.item(threadNumber);
////				NodeList threadSlideNumbers = xmlThread.getElementsByTagName(SLIDENUMBER);
////				maxItems = threadSlideNumbers.getLength();
////				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
////					Element item = (Element) threadSlideNumbers.item(itemNumber);
////					numbers.add(new Integer(item.getTextContent()));
////				}
////				// TODO factory
////				SlideIterator si = new SlideIterator(numbers);
////				presentation.addSlideIterator(si);
////			}
//			
//			// TODO factory
////			presentation.setCurrentSlideIterator(1);
//			presentation = this.builder.getResult();
//
//		} 
//		catch (IOException iox) {
//			System.err.println(iox.toString());
//		}
//		catch (SAXException sax) {
//			System.err.println(sax.getMessage());
//		}
//		catch (ParserConfigurationException pcx) {
//			System.err.println(PCE);
//		}
//		
//	}
//
//	protected void loadSlideItem(Slide slide, Element item) {
//		int level = 1; // default
//		NamedNodeMap attributes = item.getAttributes();
//		String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
//		if (leveltext != null) {
//			try {
//				level = Integer.parseInt(leveltext);
//			}
//			catch(NumberFormatException x) {
//				System.err.println(NFE);
//			}
//		}
//		String type = attributes.getNamedItem(KIND).getTextContent();
//		if (TEXT.equals(type)) {
//			this.builder.addSlideItem(slideItemfactory.createTextItem(level, item.getTextContent()));
//		}
//		else {
//			if (IMAGE.equals(type)) {
//				this.builder.addSlideItem(slideItemfactory.createBitmapItem(level, item.getTextContent()));
//			}
//			else {
//				System.err.println(UNKNOWNTYPE);
//			}
//		}
//		
//	}
//
//	public void saveFile(IPresentation presentation, String filename) throws IOException {
//		PrintWriter out = new PrintWriter(new FileWriter(filename));
//		out.println("<?xml version=\"1.0\"?>");
//		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
//		out.println("<presentation>");
//		out.print("<showtitle>");
//		out.print(presentation.getTitle());
//		out.println("</showtitle>");
//		
//		PresentationIterator iterator = presentation.getIterator();
//
//        IPresentation slide = iterator.firstSlide();
//        
//		for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++) {
////			Slide slide = presentation.getSlide(slideNumber);
//			out.println("<slide>");
//			out.println("<title>" + slide.getTitle() + "</title>");
//			Vector<PresentationItem> slideItems = slide.getSlideItems();
//			for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
//				PresentationItem slideItemAdapter = slideItems.elementAt(itemNumber);
//				out.print("<item kind="); 
//				if (slideItemAdapter instanceof SlideItemAdapter) {
//                    SlideItemAdapter adapter = (SlideItemAdapter) slideItemAdapter;
//                    SlideItem slideItem = adapter.getSlideItem();
//                    if (slideItem instanceof TextItem) {
//                        out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
//                        out.print( ( (TextItem) slideItem).getText());
//                    }
//                    else {
//                        if (slideItem instanceof BitmapItem) {
//                            out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
//                            out.print( ( (BitmapItem) slideItem).getName());
//                        }
//                        else {
//                            System.out.println("Ignoring " + slideItem);
//                        }
//                    }
//                }
//				out.println("</item>");
//			}
//			out.println("</slide>");
//		}
//		out.println("</presentation>");
//		out.close();
//	}
}
