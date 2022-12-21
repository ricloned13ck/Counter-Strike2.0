import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AnimationMonster extends Thread {
    private static AnimationMonster instance = null;

    public static AnimationMonster getInstance() {
        if (instance == null)
            instance = new AnimationMonster();
        return instance;
    }

    public int animationFrame = 0;


    @Override
    public void run() {
        while (true) {
            if (MonsterGame.getInstance().health == 0) {
                MonsterGame.getInstance().health=3;
                FAQWindow.getInstance().setScore();
                BulletGame.getInstance().setPos(-1000,-1000);
                if (MonsterGame.getInstance().pos == 1)
                    MonsterGame.getInstance().setPos(MonsterGame.getInstance().width - MonsterGame.getInstance().getX(), MonsterGame.getInstance().getY(), 0);
                else
                    MonsterGame.getInstance().setPos(MonsterGame.getInstance().width-MonsterGame.getInstance().character.getWidth(null)*3,MonsterGame.getInstance().getY(), 1);
            }
            Image image = null;
            try {
                if (MonsterGame.getInstance().pos == 1) {
                    if(MonsterGame.getInstance().isHurt){
                        image = (Image) ImageIO.read(new File("res//sprites//monsters//hurt//Monster0.png"));
                        MonsterGame.getInstance().isHurt=false;
                    }
                    else{
                        image = (Image) ImageIO.read(new File("res//sprites//monsters//attack//Monster" + animationFrame % 4 + ".png"));
                    }
                    MonsterGame.getInstance().setCharacter(image);
                    animationFrame++;
                } else {
                    if(MonsterGame.getInstance().isHurt){
                        image = (Image) ImageIO.read(new File("res//sprites//monsters//hurt//LMonster0.png"));
                        MonsterGame.getInstance().isHurt=false;
                    }
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//monsters//attack//LMonster" + animationFrame % 4 + ".png"));
                    MonsterGame.getInstance().setCharacter(image);
                    animationFrame++;
                }
                Thread.sleep(250);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            MainWindow.getInstance().j.repaint();
        }
    }
}
