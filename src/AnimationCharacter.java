import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class AnimationCharacter extends Thread {
    private static AnimationCharacter instance = null;

    public static AnimationCharacter getInstance() {
        if (instance == null)
            instance = new AnimationCharacter();
        return instance;
    }

    public int animationFrame = 0;

    @Override
    public void run() {
        while (true) {
            Image image = null;
            try {
                if (MainWindow.getInstance().isWalk) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res\\sprites\\walk\\" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res\\sprites\\walk\\L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(100);
                } else if (MainWindow.getInstance().isIdle) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res\\sprites\\idle\\" + MainWindow.getInstance().mainCharacter + animationFrame % 4 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res\\sprites\\idle\\L" + MainWindow.getInstance().mainCharacter + animationFrame % 4 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(100);
                } else if (MainWindow.getInstance().isJump) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res\\sprites\\jump\\" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res\\sprites\\jump\\L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(60);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MainWindow.getInstance().j.repaint();
        }
    }
}
