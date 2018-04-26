

public class FinancialReportController {

    public void FinancialReportController(Form zForm) {
        ans = JOptionPane.showInputDialog(zForm, "Would you like to use an Account or a Budget?", "Request",1,4,null,["Account","Budget"],null);
        // if ans = 0, display list of accounts
        // if ans = 1, display list of budgets
    }

}
