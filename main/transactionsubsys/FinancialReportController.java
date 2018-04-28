package main.transactionsubsys;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import main.repositorysys.Repository;
import main.userinterface.Form;
import main.repositorysys.Transaction;
import main.repositorysys.Account;

public class FinancialReportController {

    public void FinancialReportController() {
        //System.out.println("Placeholder...");
    }

    private String getFinancialReport() {
        String buildText = new String("");
        SimpleDateFormat sdf = new SimpleDateFormat();
        for(Account acc : Repository.getAccountCollection()){
            // add the Account title to the buildText
            buildText = buildText+acc.getName()+"\n"+acc.getType()+"\n$"+acc.getBalance()+"\n"+acc.getInterestRate()+"%\n";
            for(Transaction trans : acc.getTransactions()){
                // Add to the buildText the transaction vendor, category, value,and date
                buildText = buildText+"\t"+"\n"+trans.getCategory()+"\n"+sdf.getDateInstance().format(trans.getDate())+"\n$"+trans.getValue()+"\n";
            }
        }
        return buildText;
    } // getFinancialReport

    public void displayFinancialReport(Form zForm, String textAreaName){
        // The way setText works, you submit one large thing of "buildText"-- we will need to build it!
        String buildText = getFinancialReport();
        zForm.setText(textAreaName,buildText);
        Repository.createFinancialReport(buildText);
    } // displayFinancialReport()


    public void exportReportToTextFile() {

        try {
            File file = new File("Exported_Report.txt");

            PrintWriter writer = new PrintWriter(file);
            writer.println(getFinancialReport());
            writer.close();
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    } // exportReportToTextFile

}
