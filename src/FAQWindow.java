import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FAQWindow extends JPanel {
    private static FAQWindow instance = null;

    public static FAQWindow getInstance() {
        if (instance == null)
            instance = new FAQWindow();
        return instance;
    }

    private JLabel skip;
    private JLabel content;
    private JLabel next;
    public JLabel fullHeart;
    public JLabel notFullHeart1;
    public JLabel notFullHeart2;
    public JLabel zeroHeart;

    FAQWindow() {
        setLayout(new GridLayout(1, 3));

        skip = new JLabel("<html>Press <font color='green'>L</font> to skip instruction</html>", SwingConstants.CENTER);
        skip.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(skip);

        content = new JLabel("<html>Press <font color='green'>SPACE</font> to jump</html>", SwingConstants.CENTER);
        content.setFont(new Font("SansSerif", Font.BOLD, 21));
        add(content);

        next = new JLabel("<html>Press <font color='green'>C</font> to continue</html>", SwingConstants.CENTER);
        next.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(next);
        setOpaque(false);

        setVisible(true);
    }

    protected void changeTextJump() {
        content.setText("<html>Press <font color='green'>A</font> and <font color='green'>D</font> to walk</html>");
        MainWindow.getInstance().nowLayout = 2;
    }

    protected void changeTextWalk() {
        content.setText("<html><font color='green'>Left Click</font> to attack</html>");
        MainWindow.getInstance().nowLayout = 3;
    }

    protected void changeTextAttack() {
        removeAll();
        try {
            Image img = (Image) ImageIO.read(new File("res\\sprites\\HeartFull.png"));
            fullHeart = new JLabel(new ImageIcon(img));
            add(fullHeart);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MainWindow.getInstance().nowLayout = 4;
        CharacterGame.getInstance().setPos(0, MainWindow.getInstance().j.getHeight()-CharacterGame.getInstance().character.getHeight(null)*2 - 70);
    }
}
