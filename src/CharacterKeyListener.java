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
                AnimationCharacter.getInstance().animationFrame=0;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = true;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
                Jump jump = new Jump();
                jump.start();
            } else if (e.getKeyCode() == 65 ) {
                MainWindow.getInstance().nowPos = "LEFT";
                MainWindow.getInstance().isWalk = true;
                Walk.getInstance().setX(-1);

                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
            } else if (e.getKeyCode() == 68) {
                MainWindow.getInstance().nowPos = "RIGHT";
                Walk.getInstance().setX(1);
                MainWindow.getInstance().isWalk = true;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
            }
            else if (e.getKeyCode()==49){ //damage future test
                AnimationCharacter.getInstance().damage=1;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = true;
            } else if (e.getKeyCode() == 50) { //death
                AnimationCharacter.getInstance().death=1;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = true;
                MainWindow.getInstance().isAttack = false;
                MainWindow.getInstance().isDamage = false;
            }
            else if (e.getKeyCode() == 51) { //attack
                AnimationCharacter.getInstance().attack=1;
                MainWindow.getInstance().isWalk = false;
                MainWindow.getInstance().isIdle = false;
                MainWindow.getInstance().isJump = false;
                MainWindow.getInstance().isDeath = false;
                MainWindow.getInstance().isAttack = true;
                MainWindow.getInstance().isDamage = false;
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
