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
        setLayout(new GridLayout(1, 3));

        JLabel skip = new JLabel("<html>Press <font color='green'>L</font> to skip instruction</html>",SwingConstants.CENTER);
        skip.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(skip);

        JLabel jump = new JLabel("<html>Press <font color='green'>SPACE</font> to jump</html>", SwingConstants.CENTER);
        jump.setFont(new Font("SansSerif", Font.BOLD, 21));
        add(jump);

        JLabel next =new JLabel("<html>Press <font color='green'>C</font> to continue</html>", SwingConstants.CENTER);
        next.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(next);
        setOpaque(false);

        setVisible(true);
    }
}
