package controller;

import model.animation.AnimationCharacter;
import model.animation.Jump;
import model.animation.Walk;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharacterKeyListener implements KeyEventDispatcher {
    private static CharacterKeyListener instance = null;

    public static CharacterKeyListener getInstance() {
        if (instance == null)
            instance = new CharacterKeyListener();
        return instance;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if ((e.getKeyCode() == 32 || e.getKeyCode() == 38 || e.getKeyCode() == 87) && !MainWindow.getInstance().isJump) {
                AnimationCharacter.getInstance().animationFrame = 0;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = true;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
                Jump jump = new Jump();
                jump.start();
            } else if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && !MainWindow.getInstance().isAttack) {
                MainWindow.getInstance().nowPos = "LEFT";
                MainWindow.getInstance().isWalk = true;
                Walk.getInstance().setX(-1);

                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
            } else if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && !MainWindow.getInstance().isAttack) {
                MainWindow.getInstance().nowPos = "RIGHT";
                Walk.getInstance().setX(1);
                MainWindow.getInstance().isWalk = true;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
            } else if (e.getKeyCode() == 67) {
                if (MainWindow.getInstance().nowLayout == 1)
                    MainWindow.getInstance().secondLayout();

            } else if (e.getKeyCode() == 76) {
                MainWindow.getInstance().nowLayout = 4;
            } else if ((e.getKeyCode() == 75 || e.getKeyCode() == 17) && !MainWindow.getInstance().isAttack && !MainWindow.getInstance().isJump) {
                AnimationCharacter.getInstance().animationFrame = 0;
                AnimationCharacter.getInstance().attack = 1;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = true;
                MainWindow.getInstance().isDamage = false;
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = true;
                Walk.getInstance().setX(0);
                AnimationCharacter.getInstance().animationFrame = 0;
            } else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = true;
                Walk.getInstance().setX(0);
                AnimationCharacter.getInstance().animationFrame = 0;
            }

        }
        return false;
    }
}
