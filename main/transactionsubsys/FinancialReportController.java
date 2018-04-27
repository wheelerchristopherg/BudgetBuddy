

public class FinancialReportController {

    public void FinancialReportController(Form zForm) {
        System.out.println("Placeholder...");
    }

    public displayFinancialReport(Form zForm, String textAreaName){
        // The way setText works, you submit one large thing of "buildText"-- we will need to build it!
        String buildText = new String("");
        for(Account acc : accountCollection)){
            // add the Account title to the buildText
            buildText = buildText+acc.getName()+"\n"+acc.getType()+"\n$"+acc.getBalance()+"\n"+acc.getInterestRate()+"%\n";
            for(Transaction trans : acc.getTransactions()){
                // Add to the buildText the transaction vendor, category, value,and date
                buildText = buildText+"\t"+trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
            }
        }
        zForm.setText(textAreaName,buildText);
        Repository.createFinancialReport(buildText);
    }
}
