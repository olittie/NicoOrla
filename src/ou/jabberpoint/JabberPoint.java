package ou.jabberpoint;

import java.io.IOException;

import javax.swing.JOptionPane;

import ou.jabberpoint.model.access.Accessor;
import ou.jabberpoint.model.access.AccessorFactory;
import ou.jabberpoint.model.presentation.Presentation;
import ou.jabberpoint.view.SlideItemFactory;
import ou.jabberpoint.view.SlideViewerFrame;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/** Het Main Programma */
	public static void main(String argv[]) {
		
		Presentation presentation = new Presentation();
		SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, presentation);	
		
		try {
			if (argv.length == 0) { // een demo presentatie
				AccessorFactory accessorFactory = new AccessorFactory(new SlideItemFactory(frame.slideViewerComponent));
				Accessor accessor = accessorFactory.createAccessor();
				accessor.loadFile(presentation, "");
			} else {
				AccessorFactory accessorFactory = new AccessorFactory(new SlideItemFactory(frame.slideViewerComponent));
				Accessor accessor = accessorFactory.createAccessor(argv[0]);
				accessor.loadFile(presentation, argv[0]);
			}
		
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
