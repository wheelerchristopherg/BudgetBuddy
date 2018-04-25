package main.userinterface;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridLayout;

public abstract class Form extends JPanel implements ActionListener {
    
    private Window parent;
    private Collection<JComponent> allComponents;
    private HashMap<JButton, String> buttons;
    private HashMap<String, JTextComponent> textElements;
    
    public Form(Window parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(640, 480));
        this.setLayout(new GridLayout(10, 10, 3, 3));
        
        buttons = new HashMap<JButton, String>();
        textElements = new HashMap<String, JTextComponent>();
        allComponents = new ArrayList<JComponent>();
    }
    
    public Window getParent() {
        return parent;
    }
    
    public void setGridLayout(int rows, int columns) {
        this.setLayout(new GridLayout(rows, columns, 3, 3));
    }
    
    public void clearForm() {
        for (JComponent component : allComponents) {
            this.remove(component);
        }
        buttons = new HashMap<JButton, String>();
        textElements = new HashMap<String, JTextComponent>();
        allComponents = new ArrayList<JComponent>();
    }
    
    public void addButton(String name, String label) {
        JButton newButton = new JButton(label);
        newButton.addActionListener(this);
        buttons.put(newButton, name);
        allComponents.add(newButton);
        this.add(newButton);
    }
    
    public void addTextField(String name, String defaultValue) {
        JTextField newField = new JTextField(defaultValue);
        textElements.put(name, newField);
        allComponents.add(newField);
        this.add(newField);
    }
    
    public void addTextField(String name) {
        JTextField newField = new JTextField();
        textElements.put(name, newField);
        allComponents.add(newField);
        this.add(newField);
    }
    
    public void addLabel(String text) {
        JLabel label = new JLabel(text);
        allComponents.add(label);
        this.add(label);
    }
    
    public void addTextArea(String name, int rows, int columns, boolean editable) {
        JTextArea newTextArea = new JTextArea(rows, columns);
        textElements.put(name, newTextArea);
        JScrollPane textPane = new JScrollPane(newTextArea);
        
        if (!editable) {
            newTextArea.setEditable(false);
        }
        
        allComponents.add(textPane);
        this.add(textPane);
    }
    
    public void addPlaceholder() {
        JPanel panel = new JPanel();
        this.add(panel);
        allComponents.add(panel);
    }
    
    public void addPlaceholders(int numPlaceholders) {
        for (int i = 0; i < numPlaceholders; i++) {
            JPanel panel = new JPanel();
            this.add(panel);
            allComponents.add(panel);
        }
    }
    
    public String buttonPressed(ActionEvent event) {
        return buttons.get(event.getSource());
    }
    
    public String getTextFromInput(String name) {
        JTextComponent inputText = textElements.get(name);
        
        if (inputText == null) {
            return "";
        }
        
        return inputText.getText();
    }
    
    public void setText(String name, String text) {
        JTextComponent element = textElements.get(name);
        
        if (element != null) {
            element.setText(text);
        }
    }
    
    public void goBack() {
        parent.goBack();
    }
    
    public void changeForm(Form form) {
        parent.changeForm(form);
    }
    
    public abstract void actionPerformed(ActionEvent event);

}