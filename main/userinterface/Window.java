package main.userinterface;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Window extends JFrame {

    private Form currentForm;
    private Form previousForm;

    public Window() {
        super("Budget Buddy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setSize(640, 480);
        setResizable(false);
        centreWindow(this);

        currentForm = new MainForm(this);

        getContentPane().add(currentForm);
        updateWindow();

        this.requestFocusInWindow();
        setVisible(true);
    }

    public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
}

    public void changeForm(Form newForm) {
        getContentPane().remove(currentForm);
        previousForm = currentForm;
        currentForm = newForm;
        getContentPane().add(currentForm);
        updateWindow();
    }

    public void goBack() {
        getContentPane().remove(currentForm);
        getContentPane().add(previousForm);
        currentForm = previousForm;
        getContentPane().add(currentForm);
        updateWindow();
    }

    public void updateWindow() {
        pack();
        repaint();
    }

}
