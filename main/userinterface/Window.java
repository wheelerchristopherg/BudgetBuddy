package userinterface;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    public Window() {
        super("3D Projection");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        this.requestFocusInWindow();
        setVisible(true);
    }
    
}