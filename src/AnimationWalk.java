import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AnimationWalk extends Thread {
    private static AnimationWalk instance = null;

    public static AnimationWalk getInstance() {
        if (instance == null)
            instance = new AnimationWalk();
        return instance;
    }

    private CharacterGame characterGame = CharacterGame.getInstance();

    private int x;

    @Override
    public void run() {
        int animation = 1;
        while (true) {

            int x1 = characterGame.getX() + x;
            characterGame.setPos(x1, characterGame.getY());

            Image image = null;
            if (MainWindow.getInstance().flagWalk)
                try {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res\\sprites\\walk\\" + MainWindow.getInstance().mainCharacter + animation % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res\\sprites\\walk\\L" + MainWindow.getInstance().mainCharacter + animation % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            MainWindow.getInstance().j.repaint();

            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            animation++;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

}
