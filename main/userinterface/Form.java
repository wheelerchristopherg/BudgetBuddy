package main.userinterface;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public abstract class Form extends JPanel implements ActionListener {
    
    private Window parent;
    
    public Form(Window parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(640, 480));
    }

}