package main.transactionsubsys;
import java.util.*;
import main.repositorysys.Repository;
import main.userinterface.Form;
import main.repositorysys.Transaction;
import main.repositorysys.Account;

public class FinancialReportController {

    public void FinancialReportController() {
        //System.out.println("Placeholder...");
    }

    public void displayFinancialReport(Form zForm, String textAreaName){
        // The way setText works, you submit one large thing of "buildText"-- we will need to build it!
        String buildText = new String("");
        for(Account acc : Repository.getAccountCollection()){
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
