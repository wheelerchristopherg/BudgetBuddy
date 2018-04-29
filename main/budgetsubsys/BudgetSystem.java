package main.budgetsubsys;

import main.userinterface.Form;

public class BudgetSystem {
    
    private static BudgetReportController budgetReportCon;
    
    public static void createBudgetReportController(Form form) {
        budgetReportCon = new BudgetReportController(form);
    }
    
    public static BudgetReportController getBudgetReportController() {
        return budgetReportCon;
    }
}
