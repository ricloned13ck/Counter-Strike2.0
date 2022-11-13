import javax.swing.*;
import java.awt.*;

public class FAQWindow extends JPanel {
    private static FAQWindow instance = null;

    public static FAQWindow getInstance() {
        if (instance == null)
            instance = new FAQWindow();
        return instance;
    }

    FAQWindow() {
        setLayout(new GridLayout(15, 15));

        JLabel skip = new JLabel("Press L to skip instruction");
        skip.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(skip);

        JLabel jump = new JLabel("<html>Press <font color='red'>SPACE</font> to jump</html>", SwingConstants.CENTER);
        jump.setFont(new Font("SansSerif", Font.BOLD, 35));
        add(jump);

        JLabel next =new JLabel("Press C to continue", SwingConstants.CENTER);
        next.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(next);
        setOpaque(false);

        setVisible(true);
    }
}
