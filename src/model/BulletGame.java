package model;

import controller.MainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BulletGame extends JPanel {
    private static BulletGame instance = null;

    public static BulletGame getInstance() {
        if (instance == null)
            instance = new BulletGame();
        return instance;
    }

    private int width, height;
    private int x, y;
    public Image character;
    private MainWindow mainWindow = MainWindow.getInstance();

    private BulletGame() {
        super(true);


        try {
            this.character = (Image) ImageIO.read(new File("res//sprites//monsters//Lbullet.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.width = mainWindow.j.getWidth();
        this.height = mainWindow.j.getHeight();
        this.x = MonsterGame.getInstance().getX();
        this.y = MonsterGame.getInstance().getY() + 10;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
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
        g.drawImage(character.getScaledInstance((int) (character.getWidth(null)), (int) (character.getHeight(null)), Image.SCALE_DEFAULT), x, y, null);
    }

    public void setCharacter(Image character) {
        this.character = character;
    }
}
