package main.userinterface;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.Deque;
import java.util.ArrayDeque;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame implements ActionListener {
    
    private Form currentForm;
    private Form previousForm;
    private Timer backEvent;
    
    public Window() {
        super("Budget Buddy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setSize(640, 480);
        
        currentForm = new MainForm(this);
        
        updateWindow();
        this.requestFocusInWindow();
        setVisible(true);
    }
    
    public void changeForm(Form newForm) {
        getContentPane().remove(currentForm);
        previousForm = currentForm;
        currentForm = newForm;
        updateWindow();
    }
    
    public void goBack() {
        getContentPane().remove(currentForm);
        getContentPane().add(previousForm);
        currentForm = previousForm;
        updateWindow();
    }
    
    public void updateWindow() {
        getContentPane().add(currentForm);
        pack();
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        System.out.println("timer went off");
        if (event.getSource().equals((Object)backEvent)) {
            backEvent.stop();
            //getContentPane().remove(formStack.removeFirst());
            updateWindow();
        }
    }
    
}