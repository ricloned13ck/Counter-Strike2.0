import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AnimationIdle extends Thread {
    private static AnimationIdle instance = null;

    public static AnimationIdle getInstance() {
        if (instance == null)
            instance = new AnimationIdle();
        return instance;
    }

    @Override
    public void run() {
        int animation = 1;
        while (true) {
            Image image = null;
            if (MainWindow.getInstance().flagIdle){
                try {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res\\sprites\\idle\\" + MainWindow.getInstance().mainCharacter + animation % 4 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res\\sprites\\idle\\L" + MainWindow.getInstance().mainCharacter + animation % 4 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    MainWindow.getInstance().j.repaint();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                animation++;
            }
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
