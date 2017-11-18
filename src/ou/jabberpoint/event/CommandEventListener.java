package ou.jabberpoint.event;

import java.util.EventListener;
import java.util.EventObject;

public interface CommandEventListener <EventType extends EventObject> extends EventListener {
    void eventFired(EventType e);
}
