package main.userinterface;

import java.awt.event.ActionEvent;
import main.budgetsubsys.BudgetController;

public class MainForm extends Form {

    public MainForm(Window parent) {
        super(parent);

        setGridLayout(6, 3);

        //addPlaceholder();
        //addLabel("Budget Buddy");
        //addPlaceholder();
        addButton("BillPayReminder_Button", "Add a Bill Reminder");
        addButton("RecordTransaction_Button", "Add a Transaction");
        addPlaceholder();
        addButton("example", "Example Form");
        addButton("print_budget", "Print Budgets");
        addButton("budget", "Create Budget");
        addButton("savings networth over time", "Savings Networth Over Time");
        addButton("autoBillPay", "Add Automatic Bill Pay");

        addPlaceholders(2);

    }

    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);

        switch (name) {
            case "BillPayReminder_Button":
                changeForm(new BillPayReminderForm(this.getParent()));
                break;
            case "RecordTransaction_Button":
                changeForm(new RecordTransactionForm(this.getParent()));
                break;
            case "example":
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
            case "savings networth over time":
                changeForm(new SavingsNetworthValueForm(this.getParent()));
                break;
            case "autoBillPay":
                changeForm(new AutoBillPayForm(this.getParent()));
                break;

        }
    }
}
