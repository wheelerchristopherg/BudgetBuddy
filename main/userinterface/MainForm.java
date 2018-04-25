package main.userinterface;

import java.awt.event.ActionEvent;

public class MainForm extends Form {
    
    private Window parent;
    
    public MainForm(Window parent) {
        super(parent);
        this.parent = parent;
        setGridLayout(3, 3);
        
        addPlaceholders(4);
        addButton("button1", "Example Form");
        addPlaceholders(4);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "button1":
                changeForm(new ExampleForm(this.parent));
                break;
        }
        
        System.out.println("got here");
    }
}