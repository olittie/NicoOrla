package ou.jabberpoint.model.demo;

import ou.jabberpoint.model.presentation.IPresentation;
import ou.jabberpoint.model.access.IPresentationWriter;

import java.io.IOException;

public class DemoWriter implements IPresentationWriter {

    public void write(IPresentation presentation, String fileName) throws IOException {
        throw new IllegalStateException("Save As->Demo! aangeroepen");
    }

}
