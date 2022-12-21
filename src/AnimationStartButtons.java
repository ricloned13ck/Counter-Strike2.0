import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class AnimationStartButtons extends Thread {
    private static AnimationStartButtons instance = null;

    public static AnimationStartButtons getInstance() {
        if (instance == null)
            instance = new AnimationStartButtons();
        return instance;
    }

    // animation icons in JButtons
    @Override
    public void run() {
        int animation = 1;
        while (true) {
            try {
                for (int i = 0; i < MainWindow.getInstance().characters.size(); i++) {
                    Image image = null;
                    image = (Image) ImageIO.read(new File("res//sprites//idle//" + MainWindow.getInstance().characterImages[i] + animation % 4 + ".png"));
                    MainWindow.getInstance().characters.get(i).setIcon(new ImageIcon(image.getScaledInstance(60, 100, Image.SCALE_DEFAULT)));
                }
                animation++;
                Thread.sleep(200);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
