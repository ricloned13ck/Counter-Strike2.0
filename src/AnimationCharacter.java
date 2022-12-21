import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class AnimationCharacter extends Thread {
    private static AnimationCharacter instance = null;

    public static AnimationCharacter getInstance() {
        if (instance == null)
            instance = new AnimationCharacter();
        return instance;
    }

    public int animationFrame = 0;
    public int damage = 0;
    public int death = 0;
    public int attack = 0;
    public boolean flag = true;

    @Override
    public void run() {
        while (true) {
            Image image = null;
            try {
                if (MainWindow.getInstance().isWalk) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//walk//" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//walk//L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(100);
                } else if (MainWindow.getInstance().isIdle) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//idle//" + MainWindow.getInstance().mainCharacter + animationFrame % 4 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//idle//L" + MainWindow.getInstance().mainCharacter + animationFrame % 4 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(65);
                } else if (MainWindow.getInstance().isJump) {
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//jump//" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//jump//L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;

                    Thread.sleep(65);
                } else if (MainWindow.getInstance().isDamage) {
                    if (damage % 4 == 0) {
                        MainWindow.getInstance().isDamage=false;
                        if (Walk.getInstance().x==0){
                            MainWindow.getInstance().isIdle = true;
                            MainWindow.getInstance().isWalk = false;
                        }
                        else{
                            MainWindow.getInstance().isIdle = false;
                            MainWindow.getInstance().isWalk = true;
                        }
                        continue;
                    }
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//damage//" + MainWindow.getInstance().mainCharacter + animationFrame % 3 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//damage//L" + MainWindow.getInstance().mainCharacter + animationFrame % 3 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;
                    damage++;
                    Thread.sleep(65);
                } else if (MainWindow.getInstance().isDeath) {
                    if (death % 7 == 0) {
                        MainWindow.getInstance().isIdle = true;
                        MainWindow.getInstance().isDeath = false;
                        int result = JOptionPane.showConfirmDialog(Frame.getInstance(), "Вы набрали "+FAQWindow.getInstance().score +" очков. Поздравляем!!!");
                        if (result == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                        else System.exit(0);
                    }
                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//death//" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//death//L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    CharacterGame.getInstance().setPos(CharacterGame.getInstance().getX(),CharacterGame.getInstance().getY()+8);
                    animationFrame++;
                    death++;
                    Thread.sleep(65);
                } else if (MainWindow.getInstance().isAttack) {
                    if (MainWindow.getInstance().nowPos=="RIGHT"){
                        int gun = CharacterGame.getInstance().getX()+CharacterGame.getInstance().character.getWidth(null);
                        int monster = MonsterGame.getInstance().getX();
                        int sizeMonster = MonsterGame.getInstance().getX()+MonsterGame.getInstance().character.getWidth(null);
                        if(gun>=monster && gun<=sizeMonster && flag){
                            MonsterGame.getInstance().isHurt=true;
                            MonsterGame.getInstance().health--;
                            flag = false;
                        }
                    }
                    else{
                        int gun = CharacterGame.getInstance().getX();
                        int monster = MonsterGame.getInstance().getX();
                        int sizeMonster = MonsterGame.getInstance().getX()+MonsterGame.getInstance().character.getWidth(null);
                        if(gun>=monster && gun<=sizeMonster && flag){
                            MonsterGame.getInstance().isHurt=true;
                            flag = false;
                            MonsterGame.getInstance().health--;
                        }
                    }
                    if (attack % 7 == 0) {
                        flag = true;
                        MainWindow.getInstance().isAttack=false;
                        if (Walk.getInstance().x==0){
                            MainWindow.getInstance().isIdle = true;
                            MainWindow.getInstance().isWalk = false;
                        }
                        else{
                            MainWindow.getInstance().isIdle = false;
                            MainWindow.getInstance().isWalk = true;
                        }
                        continue;
                    }

                    if (Objects.equals(MainWindow.getInstance().nowPos, "RIGHT"))
                        image = (Image) ImageIO.read(new File("res//sprites//attack//" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    else
                        image = (Image) ImageIO.read(new File("res//sprites//attack//L" + MainWindow.getInstance().mainCharacter + animationFrame % 6 + ".png"));
                    CharacterGame.getInstance().setCharacter(image);
                    animationFrame++;
                    attack++;
                    Thread.sleep(65);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MainWindow.getInstance().j.repaint();
        }
    }
}
