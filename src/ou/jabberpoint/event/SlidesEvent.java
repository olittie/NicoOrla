package ou.jabberpoint.event;

import java.util.EventObject;

import ou.jabberpoint.model.presentation.Presentation;

public class SlidesEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public SlidesEvent(Presentation source) {
		super(source);
	}
}
