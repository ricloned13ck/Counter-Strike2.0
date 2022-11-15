import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            if (e.getKeyCode() == 32 && CharacterGame.getInstance().flag) {
                AnimationJump animationJump = new AnimationJump();
                animationJump.start();
            } else if (e.getKeyCode() == 65) {
                MainWindow.getInstance().nowPos = "LEFT";
                AnimationWalk.getInstance().setX(-10);
                MainWindow.getInstance().flagWalk = true;
                MainWindow.getInstance().flagIdle = false;
            } else if (e.getKeyCode() == 68) {
                MainWindow.getInstance().nowPos = "RIGHT";
                AnimationWalk.getInstance().setX(10);
                MainWindow.getInstance().flagWalk = true;
                MainWindow.getInstance().flagIdle = false;
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == 65){
                MainWindow.getInstance().flagWalk = false;
                MainWindow.getInstance().flagIdle = true;
                AnimationWalk.getInstance().setX(0);

            }
            else if (e.getKeyCode() == 68) {
                MainWindow.getInstance().flagWalk = false;
                MainWindow.getInstance().flagIdle = true;
                AnimationWalk.getInstance().setX(0);
            }

        }
        return false;
    }
}
