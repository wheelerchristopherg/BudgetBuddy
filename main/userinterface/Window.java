package main.userinterface;

import javax.swing.JFrame;
import java.util.ArrayDeque;

public class Window extends JFrame {
    
    private formStack;
    
    public Window() {
        super("Budget Buddy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        this.requestFocusInWindow();
        setVisible(true);
    }
    
}