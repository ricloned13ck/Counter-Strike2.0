package controller.observers;

import java.util.ArrayList;

public abstract class CharacterObserver {

    private static ArrayList<CharacterListener> listeners = null;

    private static class ObserveThread extends Thread {
        private CharacterEvent event;

        public ObserveThread(CharacterEvent event) {
            super();
            this.event = event;
            this.start();
        }

        @Override
        public void run() {
            for (CharacterListener listener : getListeners())
                listener.onPositionChanged(event);
        }
    }

    private static ArrayList<CharacterListener> getListeners() {
        if (listeners == null)
            listeners = new ArrayList<>();
        return listeners;
    }

    public static void addListener(CharacterListener listener) {
        getListeners().add(listener);
    }

    public static void removeListener(CharacterListener listener) {
        getListeners().remove(listener);
    }

    public static void fireBallEvent(CharacterEvent event) {
        new ObserveThread(event);
    }

}
