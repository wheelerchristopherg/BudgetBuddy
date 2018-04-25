package main.userinterface;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
    
    private Form currentForm;
    private Form previousForm;
    
    public Window() {
        super("Budget Buddy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setSize(640, 480);
        setResizable(false);
        
        currentForm = new MainForm(this);
        
        getContentPane().add(currentForm);
        updateWindow();
        
        this.requestFocusInWindow();
        setVisible(true);
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