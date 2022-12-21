import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BulletFlying extends Thread {
    private static BulletFlying instance = null;

    public static BulletFlying getInstance() {
        if (instance == null)
            instance = new BulletFlying();
        return instance;
    }

    private int animation = 0;

    @Override
    public void run() {
        while (true) {
            Image image = null;
            double a = Math.random() * 800 + 800;
            if (animation >= a) {
                animation = 0;
                if (MonsterGame.getInstance().pos==0)
                    BulletGame.getInstance().setPos(MonsterGame.getInstance().getX()+20, MonsterGame.getInstance().getY()+10);
                else
                    BulletGame.getInstance().setPos(MonsterGame.getInstance().getX(), MonsterGame.getInstance().getY()+10);
            }
            if (CharacterGame.getInstance().getX()<=BulletGame.getInstance().getX() && BulletGame.getInstance().getX()<=CharacterGame.getInstance().getX()+CharacterGame.getInstance().character.getWidth(null) && (MainWindow.getInstance().isWalk || MainWindow.getInstance().isIdle)){
                BulletGame.getInstance().setPos(-1000,-1000);
                CharacterGame.getInstance().minusHealth();
            }

            if (MonsterGame.getInstance().pos == 1) {
                BulletGame.getInstance().setPos(BulletGame.getInstance().getX() - MainWindow.getInstance().j.getWidth() / 350, BulletGame.getInstance().getY());
                try {
                    image = (Image) ImageIO.read(new File("res//sprites//monsters//Lbullet.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                BulletGame.getInstance().setCharacter(image);

            } else {
                BulletGame.getInstance().setPos(BulletGame.getInstance().getX() + MainWindow.getInstance().j.getWidth() / 350, BulletGame.getInstance().getY());
                try {
                    image = (Image) ImageIO.read(new File("res//sprites//monsters//bullet.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                BulletGame.getInstance().setCharacter(image);
            }
            animation++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            MainWindow.getInstance().j.repaint();
        }
    }
}
