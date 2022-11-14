import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CharacterGame extends JPanel {
    private static CharacterGame instance = null;

    public static CharacterGame getInstance() {
        if (instance == null)
            instance = new CharacterGame();
        return instance;
    }

    private int width, height;
    private int x,y;
    public boolean flag = true;


    private Image character;
    private MainWindow mainWindow = MainWindow.getInstance();

    private CharacterGame() {
        super(true);

        this.width = mainWindow.j.getWidth();
        this.height = mainWindow.j.getHeight();
        this.x = width / 2;
        this.y = height-150;
        try {
            this.character = (Image) ImageIO.read(new File("res\\sprites\\" + mainWindow.mainCharacter + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setPos(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(character.getScaledInstance(60, 100, Image.SCALE_DEFAULT), x, y, null);
    }
}
