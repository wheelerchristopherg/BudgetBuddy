package main.userinterface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridLayout;

public abstract class Form extends JPanel implements ActionListener {
    
    private Window parent;
    private HashMap<JButton, String> buttons;
    private HashMap<String, JTextComponent> inputElements;
    
    public Form(Window parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(640, 480));
        this.setLayout(new GridLayout(10, 10, 3, 3));
        
        buttons = new HashMap<JButton, String>();
        inputElements = new HashMap<String, JTextComponent>();
        
    }
    
    public void setGridLayout(int rows, int columns) {
        this.setLayout(new GridLayout(rows, columns, 3, 3));
    }
    
    public void addButton(String name, String label) {
        JButton newButton = new JButton(label);
        newButton.addActionListener(this);
        buttons.put(newButton, name);
        this.add(newButton);
    }
    
    public void addTextField(String name, String defaultValue) {
        JTextField newField = new JTextField(defaultValue);
        inputElements.put(name, newField);
        this.add(newField);
    }
    
    public void addTextField(String name) {
        JTextField newField = new JTextField();
        inputElements.put(name, newField);
        this.add(newField);
    }
    
    public void addLabel(String text) {
        
    }
    
    public void addTextarea() {
        
    }
    
    public void addPlaceholder() {
        this.add(new JPanel());
    }
    
    public void addPlaceholders(int numPlaceholders) {
        for (int i = 0; i < numPlaceholders; i++) {
            this.add(new JPanel());
        }
    }
    
    public String buttonPressed(ActionEvent event) {
        return buttons.get(event.getSource());
    }
    
    public String getTextFromInput(String name) {
        JTextComponent inputText = inputElements.get(name);
        
        if (inputText == null) {
            return "";
        }
        
        return inputText.getText();
    }
    
    public abstract void actionPerformed(ActionEvent event);

}