package model.animation;

import controller.MainWindow;
import controller.observers.CharacterEvent;
import controller.observers.CharacterObserver;
import model.CharacterGame;

public class Jump extends Thread {


    private CharacterGame characterGame = CharacterGame.getInstance();

    private int y = -1;
    private int highJump = MainWindow.getInstance().j.getHeight() / 5;

    @Override
    public void run() {
        int b = 0;
        MainWindow.getInstance().isJump = true;
        while (true) {
            MainWindow.getInstance().isIdle = false;
            MainWindow.getInstance().isWalk = false;
            if (b == highJump) {
                y = 1;
            }
            if (b >= 2 * highJump) {
                CharacterObserver.fireBallEvent(new CharacterEvent(characterGame.getX(), MainWindow.getInstance().j.getHeight() - CharacterGame.getInstance().character.getHeight(null) * 2 - 70));
                if (Walk.getInstance().x != 0) {
                    MainWindow.getInstance().isIdle = false;
                    MainWindow.getInstance().isWalk = true;
                } else {
                    MainWindow.getInstance().isIdle = true;
                    MainWindow.getInstance().isWalk = false;
                }

                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isAttack = false;
                return;
            }
            b += 1;

            int y1 = characterGame.getY() + y;
            CharacterObserver.fireBallEvent(new CharacterEvent(characterGame.getX(), y1));
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
