package ou.jabberpoint.model.access;

import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.presentation.IPresentationBuilder;
import ou.jabberpoint.view.ISlideItemFactory;

import java.io.IOException;

public abstract class AbstractPresentationReader implements IPresentationReader {

    protected final ISlideItemFactory _slideItemfactory;
    protected final IPresentationBuilder _builder;

    public AbstractPresentationReader(ISlideItemFactory slideItemFactory, IPresentationBuilder builder) {
        this._slideItemfactory = slideItemFactory;
        this._builder = builder;
    }

    public abstract void read(IPresentation presentation, String fileName) throws IOException;

}
