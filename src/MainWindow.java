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
    public String mainCharacter;
    private JPanel spaces = new JPanel();
    private ClickListener clickListener = ClickListener.getInstance();
    public JPanel j;
    public Dimension screenDimension;
    private CharacterGame characterGame;
    private GameCanvas gameCanvas;
    CharacterKeyListener keyListener = CharacterKeyListener.getInstance();


    public MainWindow() {
        frame.setTitle("Counter-Strike 2.0");
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);



        // screen size and position center
        screenDimension = frame.getToolkit().getScreenSize();
        Dimension windowDimension = new Dimension(screenDimension.width / 2, screenDimension.height / 2);
        Point windowLocation = new Point(screenDimension.width / 4, screenDimension.height / 4);
        frame.setSize(windowDimension);
        frame.setLocation(windowLocation);
        try {
            Image img = (Image) ImageIO.read(new File("res\\background\\Background.png"));
            JLabel back = new JLabel(new ImageIcon(img.getScaledInstance(screenDimension.width / 2, screenDimension.height / 2, Image.SCALE_SMOOTH)));
            frame.setContentPane(back);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setLayout(new GridLayout(1,3));


        //we need more space
        spaces.setLayout(new GridLayout(3,1));
        JLabel space = new JLabel("\n");
        space.setFont(new Font("SansSerif", Font.BOLD, 250));

        chooseCharacter = new JLabel("Choose your character", SwingConstants.CENTER);
        spaces.setOpaque(false);
        canvas.setOpaque(false);
        chooseCharacter.setFont(new Font("SansSerif", Font.BOLD, 40));

        spaces.add(chooseCharacter);


        canvas.setLayout(new GridLayout(1,45));

        // selection character buttons
        createCharacters();
        j = new JPanel();
        j.setOpaque(false);
        j.setLayout(new GridLayout(3,1));
        j.add(spaces);
        j.add(space);
        j.add(canvas);

        frame.add(j);
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
        j.removeAll();
        j.setLayout(new BorderLayout());
        j.add(FAQWindow.getInstance(), BorderLayout.NORTH);

        gameCanvas = GameCanvas.getInstance();
        gameCanvas.setOpaque(false);

        j.add(gameCanvas, BorderLayout.CENTER);


        try {
            Image img = (Image) ImageIO.read(new File("res\\background\\ground.png"));
            JLabel pole = new JLabel(new ImageIcon(img.getScaledInstance(screenDimension.width / 2, 25, Image.SCALE_SMOOTH)));
            j.add(pole, BorderLayout.SOUTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(keyListener);
        AnimationWalk.getInstance().start();

        frame.revalidate();
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
