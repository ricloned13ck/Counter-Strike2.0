import javax.swing.*;

public class Frame extends JFrame {
    private static Frame instance = null;

    public static Frame getInstance() {
        if (instance == null)
            instance = new Frame();
        return instance;
    }
}
