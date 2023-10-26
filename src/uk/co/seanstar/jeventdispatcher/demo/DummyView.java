package uk.co.seanstar.jeventdispatcher.demo;

import uk.co.seanstar.jeventdispatcher.JEventDispatcher;

public class DummyView {
    public final JEventDispatcher<String> loadEvt = new JEventDispatcher<>();
    public final JEventDispatcher<DummyObject> saveEvt = new JEventDispatcher<>();
    public final JEventDispatcher<Void> disposedEvt = new JEventDispatcher<>();

    public DummyView() {

    }
    public void test() {
        saveEvt.invoke(new DummyObject("Test 123"));

        disposedEvt.invoke(null);
    }
}
