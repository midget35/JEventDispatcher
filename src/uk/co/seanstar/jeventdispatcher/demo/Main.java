package uk.co.seanstar.jeventdispatcher.demo;

public class Main {

    private static final Main instance = new Main();
    public static void main(String[] args) { }

    DummyView dummyView = new DummyView();
    public Main() {
        System.out.println("-= JEventDispatcher Demo =-");

        dummyView.saveEvt.addListener(this, this::onSave);
        dummyView.saveEvt.addListener(this, this::onSave2);
        dummyView.disposedEvt.addListener(this, this::onDisposed);
        dummyView.test();
    }

    private void onDisposed(Void v) {
        System.out.println("- onDisposed: '" + v + "'.");
        dummyView.disposedEvt.removeListeners(this);
        dummyView.saveEvt.removeListeners(this);
        dummyView.loadEvt.removeListeners(this);
        System.out.println("- disposedEvt listeners: " + dummyView.disposedEvt.getListenerCount(this) + ".");
        System.out.println("- saveEvt listeners    : " + dummyView.saveEvt.getListenerCount(this) + ".");
        System.out.println("- loadEvt listeners    : " + dummyView.loadEvt.getListenerCount(this) + ".");
    }
    private void onSave(DummyObject dummyObject ) {
        System.out.println("- onSave: '"+dummyObject.name+"'.");
    }
    private void onSave2(DummyObject dummyObject ) {
        System.out.println("- onSave2: '"+dummyObject.name+"'.");
    }
}