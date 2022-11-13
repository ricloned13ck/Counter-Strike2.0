import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainWindow {
    private static MainWindow instance = null;

    public static MainWindow getInstance() {
        if (instance == null)
            instance = new MainWindow();
        return instance;
    }

    private Frame frame = Frame.getInstance();
    private Canvas canvas = Canvas.getInstance();
    private JLabel chooseCharacter;
    public LinkedList<JButton> characters = new LinkedList<>();
    public String[] characterImages = {"Woodcutter", "Cyborg", "LaraCroft"};
    private String mainCharacter;
    private JPanel spaces = new JPanel();
    private ClickListener clickListener = ClickListener.getInstance();

    public MainWindow() {
        frame.setTitle("Counter-Strike 2.0");

        // screen size and position center
        Dimension screenDimension = frame.getToolkit().getScreenSize();
        Dimension windowDimension = new Dimension(screenDimension.width / 2, screenDimension.height / 2);
        Point windowLocation = new Point(screenDimension.width / 4, screenDimension.height / 4);
        frame.setSize(windowDimension);
        frame.setLocation(windowLocation);

        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);

        //we need more space
        spaces.setLayout(new BorderLayout());
        JLabel space = new JLabel("\n");
        space.setFont(new Font("SansSerif", Font.BOLD, 100));

        chooseCharacter = new JLabel("Choose your character", SwingConstants.CENTER);
        chooseCharacter.setFont(new Font("SansSerif", Font.BOLD, 50));

        spaces.add(chooseCharacter, BorderLayout.CENTER);
        spaces.add(space, BorderLayout.SOUTH);

        frame.add(spaces, BorderLayout.NORTH);

        canvas.setLayout(new FlowLayout());

        // selection character buttons
        createCharacters();

        frame.setVisible(true);
    }

    // starting game
    protected void changeFirstLayout(int x) {
        if (x == 1)
            this.mainCharacter = "Woodcutter";
        if (x == 2)
            this.mainCharacter = "Cyborg";
        if (x == 3)
            this.mainCharacter = "LaraCroft";
        AnimationStartButtons animationStartButtons = AnimationStartButtons.getInstance();
        animationStartButtons.stop();
        spaces.removeAll();
        canvas.removeAll();
        frame.repaint();
    }

    // create characters
    private void createCharacters() {
        for (int i = 0; i < characterImages.length; i++) {
            Image image = null;
            try {
                image = (Image) ImageIO.read(new File("res\\sprites\\" + characterImages[i] + ".png"));
                JButton button = new JButton(new ImageIcon(image.getScaledInstance(60, 100, Image.SCALE_DEFAULT)));
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setBorderPainted(false);

                button.setActionCommand(String.valueOf(i + 1));
                button.addActionListener(clickListener);
                characters.add(button);
                canvas.add(button);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
