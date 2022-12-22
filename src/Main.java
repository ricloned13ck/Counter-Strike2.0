import controller.MainWindow;
import model.animation.AnimationStartButtons;

public class Main {
    public static void main(String[] args) {
        MainWindow.getInstance();
        AnimationStartButtons animationStartButtons = AnimationStartButtons.getInstance();
        animationStartButtons.start();

    }
}