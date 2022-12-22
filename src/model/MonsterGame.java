package model;

import controller.MainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MonsterGame extends JPanel {
    private static MonsterGame instance = null;

    public static MonsterGame getInstance() {
        if (instance == null)
            instance = new MonsterGame();
        return instance;
    }

    public int width, height;
    private int x, y;
    public int pos = 1;
    public int health = 3;


    public Image character;
    private MainWindow mainWindow = MainWindow.getInstance();
    public boolean isHurt = false;

    private MonsterGame() {
        super(true);


        try {
            this.character = (Image) ImageIO.read(new File("res//sprites//monsters//attack//Monster0.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.width = mainWindow.j.getWidth();
        this.height = mainWindow.j.getHeight();
        this.x = width - this.character.getWidth(null) * 3;
        this.y = height - character.getHeight(null) * 3 - 5;

    }

    public void setPos(int x, int y, int pos) {
        this.pos = pos;
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
        g.drawImage(character.getScaledInstance((int) (character.getWidth(null) * 1.5), (int) (character.getHeight(null) * 1.5), Image.SCALE_DEFAULT), x, y, null);
    }

    public void setCharacter(Image character) {
        this.character = character;
    }

    public boolean getCanvas() {
        if (instance != null)
            return true;
        return false;
    }
}
