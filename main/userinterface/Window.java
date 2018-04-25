package main.userinterface;

import javax.swing.JFrame;
import java.util.Deque;
import java.util.ArrayDeque;

public class Window extends JFrame {
    
    private Deque<Form> formStack;
    
    public Window() {
        super("Budget Buddy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setSize(640, 480);
        formStack = new ArrayDeque<Form>();
        
        formStack.addFirst(new MainForm(this));
        
        getContentPane().add(formStack.peekFirst());
        this.requestFocusInWindow();
        pack();
        setVisible(true);
    }
    
}