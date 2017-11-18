package ou.jabberpoint.event;

import java.util.EventObject;
import java.util.Vector;

public class EventDispatcher <EventType extends EventObject> {
    private Vector<CommandEventListener<EventType>> listenerList =
            new Vector<>();

    public void addListener(CommandEventListener<EventType> listener) {
        listenerList.add(listener);
    }
    
    public void removeListener(CommandEventListener<EventType> listener) {
        listenerList.remove(listener);
    }

    public void fire(EventType event) {
        for (CommandEventListener<EventType> listener : listenerList) {
            listener.eventFired(event);
        }
    }
}
