package main.userinterface;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        JButton testButton1 = new JButton("Test button 1");
        JButton testButton2 = new JButton("Test button 2"); 
        testButton1.addActionListener(this);
        testButton2.addActionListener(this);
        
        this.add(testButton1);
        this.add(testButton2);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        
    }
}