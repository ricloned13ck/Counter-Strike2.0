package model.animation;

import controller.MainWindow;
import controller.observers.CharacterEvent;
import controller.observers.CharacterObserver;
import model.CharacterGame;

public class Walk extends Thread {
    private static Walk instance = null;

    public static Walk getInstance() {
        if (instance == null)
            instance = new Walk();
        return instance;
    }

    private CharacterGame characterGame = CharacterGame.getInstance();

    public int x;

    @Override
    public void run() {
        while (true) {
            int y2 = characterGame.getY();
            int x2 = 0;
            if (characterGame.getX() <= 0) {
                x2 = 1;
            } else if (characterGame.getX() >= MainWindow.getInstance().j.getWidth() - CharacterGame.getInstance().character.getWidth(null)) {
                x2 = MainWindow.getInstance().j.getWidth() - CharacterGame.getInstance().character.getWidth(null);
            } else {
                x2 = characterGame.getX() + x;
            }
            CharacterObserver.fireBallEvent(new CharacterEvent(x2, y2));
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

}
