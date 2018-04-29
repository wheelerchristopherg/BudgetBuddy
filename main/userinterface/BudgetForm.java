package main.userinterface;

import java.awt.event.ActionEvent;
import main.repositorysys.Budget;
import main.budgetsubsys.BudgetController;

public class BudgetForm extends Form {
    public BudgetForm(Window parent){
        super (parent);

        setGridLayout(4,2); // Set grid
        addLabel("Enter the appropriate information.");// add label
        addTextField("nameField", "Name");
        addTextField("numCatsField","Number of Categories");
        addTextField("startDateField","Start Date (MM-dd-yyyy)");
        addTextField("endDateField","End Date (MM-dd-yyyy)");
        addTextField("capField","Overall Spending Cap");
        //addButton("catInputs", "Input Category Names and Spending Goals");
        addButton("submit", "Input Categories and Create Budget");
        addButton("back","Back");
    }

    public void actionPerformed(ActionEvent event) {
        BudgetController bc = new BudgetController();
        String name = buttonPressed(event);
        switch (name) {
            //case "catInputs":
                //sendSpendingGoals
            //    break;
            case "submit":
                bc.sendBudgetData(this,getTextFromInput("nameField"),getTextFromInput("numCatsField"),getTextFromInput("startDateField"),getTextFromInput("endDateField"),getTextFromInput("capField"));
                bc.sendSpendingGoals(this);
                break;
            case "back":
                goBack();
                break;
        }
    }
}