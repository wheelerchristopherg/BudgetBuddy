package main.userinterface;

import java.awt.event.ActionEvent;
import main.budgetsubsys.BudgetController;
import main.assetsubsys.DisplayValueOfAssetsController;
import main.transactionsubsys.TransactionSystem;

public class MainForm extends Form {

    public MainForm(Window parent) {
        super(parent);

        setGridLayout(6, 4);

        addButton("BillPayReminder_Button", "Add a Bill Reminder");
        addButton("RecordTransaction_Button", "Add a Transaction");
        addButton("example", "Example Form");
        addButton("print_budget", "Print Budgets");
        addButton("budget", "Create Budget");
        addButton("savings networth over time", "Savings Networth Over Time");
        addButton("autoBillPay", "Add Automatic Bill Pay");
        addButton("value_of_assets_button", "Display Value of Assets");
        addButton("amor_cal", "Amortization Calendar");
        addButton("filterTransactions_button", "Filter Transactions");
        addButton("financialReport","Create a Financial Report");

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
                changeForm(new BudgetForm(this.getParent()));
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
            case "amor_cal":
                changeForm(new AmortizationCalendarForm(this.getParent()));
                break;
            case "value_of_assets_button":
                new DisplayValueOfAssetsController(this);
                break;

            case "filterTransactions_button":
                changeForm(new FilterForm(this.getParent()));
                break;
            case "financialReport":
                changeForm(new FinancialReportForm(this.getParent()));
                break;

        }
    }
}
