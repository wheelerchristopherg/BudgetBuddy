package main.userinterface;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        JButton testButton = new JButton("Test button"); 
        testButton.addActionListener(this);
        this.add(testButton);
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}