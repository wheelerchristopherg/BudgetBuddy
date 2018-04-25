package main.userinterface;

import javax.swing.JFrame;
import java.awt.Graphics;
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
        
        updateWindow();
        setVisible(true);
    }
    
    public void changeForm(Form newForm) {
        getContentPane().remove(formStack.peekFirst());
        formStack.addFirst(newForm);
        updateWindow();
    }
    
    public void goBack() {
        formStack.removeFirst();
        updateWindow();
    }
    
    public void updateWindow() {
        getContentPane().add(formStack.peekFirst());
        this.requestFocusInWindow();
        pack();
    }
}