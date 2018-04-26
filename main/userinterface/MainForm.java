package main.userinterface;

import java.awt.event.ActionEvent;
import main.budgetsubsys.BudgetController;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        setGridLayout(3, 3);
        
        addPlaceholder();
        addLabel("Main Form");
        addPlaceholder();
        addButton("button1", "Example Form");
        addButton("print_budget", "Print Budgets");
        addButton("budget", "Create Budget");
        addPlaceholders(3);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "button1":
                changeForm(new ExampleForm(this.getParent()));
                break;
            case "budget":
                BudgetController budgetController = new BudgetController();
                budgetController.sendBudgetData(this);
                budgetController.sendSpendingGoals(this);
                break;
            case "print_budget":
                main.repositorysys.Repository.printBudgetCollection();
                break;
        }
    }
}