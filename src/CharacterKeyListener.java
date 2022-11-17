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
            if (e.getKeyCode() == 32 && !MainWindow.getInstance().isJump) {
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = true;
                Jump jump = new Jump();
                jump.start();
            } else if (e.getKeyCode() == 65 ) {
                MainWindow.getInstance().nowPos = "LEFT";
                Walk.getInstance().setX(-1);
                MainWindow.getInstance().isWalk = true;
                MainWindow.getInstance().isIdle = false;
            } else if (e.getKeyCode() == 68) {
                MainWindow.getInstance().nowPos = "RIGHT";
                Walk.getInstance().setX(1);
                MainWindow.getInstance().isWalk = true;
                MainWindow.getInstance().isIdle = false;
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            if (e.getKeyCode() == 65){
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = true;
                Walk.getInstance().setX(0);
                AnimationCharacter.getInstance().animationFrame=0;
            }
            else if (e.getKeyCode() == 68) {
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = true;
                Walk.getInstance().setX(0);
                AnimationCharacter.getInstance().animationFrame=0;
            }

        }
        return false;
    }
}
