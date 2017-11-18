package ou.jabberpoint.model.access;

import ou.jabberpoint.model.presentation.IPresentation;

import java.io.IOException;

public interface IPresentationWriter {

    void write(IPresentation presentation, String fileName) throws IOException;

}
