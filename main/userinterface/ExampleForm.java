package main.userinterface;

import java.awt.event.ActionEvent;

public class ExampleForm extends Form {
    
    public ExampleForm(Window parent) {
        super(parent);
        
        setGridLayout(5, 2);
        
        addLabel("Example Form");
        addPlaceholder();
        addButton("button1","Print text");
        addTextField("text1", "box 1");
        addButton("button2","Print text");
        addTextField("text2", "box 2");
        addLabel("uneditable text area:");
        addTextArea("output", 5, 20, false);
        addButton("change","change the output");
        addButton("back", "Back");
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "button1":
                System.out.println(getTextFromInput("text1"));
                break;
            case "button2":
                System.out.println(getTextFromInput("text2"));
                break;
            case "change":
                setText("text1", "hello there, these");
                setText("text2", "fields have changed");
                setText("output", "Hello there\nthis field\nhas changed too\nnewline\nnewline\nnewline\nnewline\nnewline\nnewline");
                break;
            case "back":
                goBack();
                break;
            
        }
    }
}