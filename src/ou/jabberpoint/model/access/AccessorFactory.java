package ou.jabberpoint.model.access;

import ou.jabberpoint.model.demo.DemoPresentation;
import ou.jabberpoint.model.demo.DemoReader;
import ou.jabberpoint.model.demo.DemoWriter;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.model.presentation.IStyleFactory;
import ou.jabberpoint.model.presentation.PresentationBuilder;
import ou.jabberpoint.model.presentation.StyleFactory;
import ou.jabberpoint.view.ISlideItemFactory;


public class AccessorFactory {

	private ISlideItemFactory _slideItemFactory;

	public AccessorFactory(ISlideItemFactory slideItemFactory)
	{
		_slideItemFactory = slideItemFactory;
	}
	
	public Accessor createAccessor()
	{
		return new DemoPresentation(new DemoReader(_slideItemFactory, new PresentationBuilder()), new DemoWriter());

	}
	
	public Accessor createAccessor(String path)
	{
		if(path == null || path.length() == 0)
		{
			return createAccessor();
		}

		IStyleFactory styleFactory = new StyleFactory();
		IPresentationBuilder builder = new PresentationBuilder();
		
		return new XMLAccessor(new XmlReader(_slideItemFactory, builder), new XmlWriter());
	}
}