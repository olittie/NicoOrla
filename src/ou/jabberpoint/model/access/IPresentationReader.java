package ou.jabberpoint.model.access;

import java.io.IOException;

import ou.jabberpoint.model.presentation.IPresentation;

public interface IPresentationReader {

	void read(IPresentation presentation, String fileName) throws IOException;
}
