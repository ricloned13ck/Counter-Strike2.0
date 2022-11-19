import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1 && !MainWindow.getInstance().isAttack && !MainWindow.getInstance().isJump){
            AnimationCharacter.getInstance().animationFrame=0;
            AnimationCharacter.getInstance().attack=1;
            MainWindow.getInstance().isWalk = false;
            MainWindow.getInstance().isIdle = false;
            MainWindow.getInstance().isJump = false;
            MainWindow.getInstance().isDeath = false;
            MainWindow.getInstance().isAttack = true;
            MainWindow.getInstance().isDamage = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
