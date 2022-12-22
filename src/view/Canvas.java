package view;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private static Canvas instance = null;

    public static Canvas getInstance() {
        if (instance == null)
            instance = new Canvas();
        return instance;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
