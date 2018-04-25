package main.userinterface;

import java.awt.event.ActionEvent;

public class ExampleForm extends Form {
    
    public ExampleForm(Window parent) {
        super(parent);
        
        setGridLayout(9, 2);
        
        addPlaceholders(2);
        addButton("button1","Print text");
        addTextField("input1", "box 1");
        addPlaceholders(2);
        addButton("button2","Print text");
        addTextField("input2", "box 2");
        addPlaceholders(2);
        addButton("button3","Print text");
        addTextField("input3", "box 3");
        addPlaceholders(5);
        addButton("back", "Back");
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        String output = "";
        switch (name) {
            case "button1":
                output = getTextFromInput("input1");
                break;
            case "button2":
                output = getTextFromInput("input2");
                break;
            case "button3":
                output = getTextFromInput("input3");
                break;
            case "back":
                //javax.swing.JOptionPane.showMessageDialog(this, "Doesn't work yet");
                goBack();
                break;
            
        }
        
        System.out.println(output);
    }
}