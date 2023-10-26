package uk.co.seanstar.jeventhandler.demo;

import uk.co.seanstar.jeventhandler.JEventHandler;

public class DummyView {
    public final JEventHandler<String> loadEvt = new JEventHandler<>();
    public final JEventHandler<DummyObject> saveEvt = new JEventHandler<>();
    public final JEventHandler<Void> disposedEvt = new JEventHandler<>();

    public DummyView() {

    }
    public void testSave() {
        saveEvt.invoke(new DummyObject("Save - Test 123"));
        disposedEvt.invoke(null);
    }
    public void testLoad() {
        loadEvt.invoke("Load - Test 123");
    }
}
