package uk.co.seanstar.jeventhandler;
import java.util.ArrayList;
import java.util.List;

public class JEventHandler<T> {
    public interface Callback<T> {
        void onEvent(T obj);
    }

    private static class ListenerContainer<T> {
        Object listener;
        Callback<T> callback;

        ListenerContainer(Object listener, Callback<T> callback) {
            this.listener = listener;
            this.callback = callback;
        }
    }

    private final List<ListenerContainer<T>> containers = new ArrayList<>();

    public void addListener(Object listener, Callback<T> callback) {
        containers.add(new ListenerContainer<>(listener, callback));
    }

    public void invoke(T arg) {
        for (ListenerContainer<T> container : new ArrayList<>(containers)) {
            container.callback.onEvent(arg);
        }
    }

    public void removeListeners(Object listener) {
        containers.removeIf(container -> container.listener.equals(listener));
    }

    public boolean hasListener(Object listener) {
        return containers.stream().anyMatch(container -> container.listener.equals(listener));
    }
	
    public int getListenerCount(Object listener) {
        int count = 0;
        for (ListenerContainer<T> container : containers) {
            if (container.listener.equals(listener)) {
                count++;
            }
        }
        return count;
    }
}
