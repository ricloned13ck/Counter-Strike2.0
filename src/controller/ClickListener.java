package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

    private static ClickListener instance = null;

    public static ClickListener getInstance() {
        if (instance == null)
            instance = new ClickListener();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.getInstance().firstLayout(Integer.parseInt(e.getActionCommand()));
    }
}
