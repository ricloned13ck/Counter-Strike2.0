import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private static GameCanvas instance = null;

    public static GameCanvas getInstance() {
        if (instance == null)
            instance = new GameCanvas();
        return instance;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        CharacterGame.getInstance().paint(g);
        BulletGame.getInstance().paint(g);
        MonsterGame.getInstance().paint(g);
    }
}
