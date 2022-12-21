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

    public JLabel content;
    public JLabel fullHeart;
    public int score=0;
    public int health =3;

    FAQWindow() {
        setLayout(new GridLayout(1, 2));
        content = new JLabel();
        content.setFont(new Font("SansSerif", Font.BOLD, 15));
        content.setText("Ваш счёт: "+ score);
        add(content);
        try {
            Image img = (Image) ImageIO.read(new File("res//sprites//HeartFull.png"));
            fullHeart = new JLabel(new ImageIcon(img),SwingConstants.RIGHT);
            add(fullHeart);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MainWindow.getInstance().nowLayout = 4;
        CharacterGame.getInstance().setPos(0, MainWindow.getInstance().j.getHeight()-CharacterGame.getInstance().character.getHeight(null)*2 - 70);
        setOpaque(false);

        setVisible(true);
    }

    public void setScore(){
        content.setText("Ваш счёт: "+ score);
        score++;
    }

    public void twoHealth(){
        Image img = null;
        try {
            img = (Image) ImageIO.read(new File("res//sprites//2Heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        changeImage(img);
    }

    private void changeImage(Image img) {
        fullHeart.setIcon(new ImageIcon(img));
        AnimationCharacter.getInstance().animationFrame = 0;
        AnimationCharacter.getInstance().damage = 1;
        MainWindow.getInstance().isWalk = false;
        MainWindow.getInstance().isIdle = false;
        MainWindow.getInstance().isJump = false;
        MainWindow.getInstance().isDeath = false;
        MainWindow.getInstance().isAttack = false;
        MainWindow.getInstance().isDamage = true;
        repaint();
        revalidate();
    }

    public void oneHealth(){
        Image img = null;
        try {
            img = (Image) ImageIO.read(new File("res//sprites//1Heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        changeImage(img);
    }
    public void zeroHealth(){
        Image img = null;
        try {
            img = (Image) ImageIO.read(new File("res//sprites//0Heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fullHeart.setIcon(new ImageIcon(img));
        repaint();
        revalidate();
        AnimationCharacter.getInstance().animationFrame = 0;
        AnimationCharacter.getInstance().death = 1;
        while (true){
            MainWindow.getInstance().isWalk = false;
            MainWindow.getInstance().isIdle = false;
            MainWindow.getInstance().isJump = false;
            MainWindow.getInstance().isDeath = true;
            MainWindow.getInstance().isAttack = false;
            MainWindow.getInstance().isDamage = false;
        }
    }

}
