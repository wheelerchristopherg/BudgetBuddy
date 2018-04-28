package main.transactionsubsys;
import java.util.*;
import main.userinterface.Form;
import main.repositorysys.Account;
import main.repositorysys.Repository;
import main.repositorysys.Transaction;

public class FilterController {

    String buildText;

    public void FilterController() {
        buildText = "";
    }

    public void FilterByCategory(String acc_lookup, String targetCat) {
        System.out.println("FilterByCategory");
        System.out.println(Repository.getAccount(acc_lookup));

        Account acc = Repository.getAccount(acc_lookup);
        //System.out.println(acc.getTransactions().at(0).getType());

        for (Transaction t : acc.getTransactions()) {
            System.out.println(t.getTransactionString());

            if (t.getCategory().equals(targetCat))
                buildText += "\t\n" + t.getCategory() + "\n" + t.getDate() + "\n$" + t.getValue() + "\n";

        }

        System.out.println("b: [" + buildText + "]");
    } // FilterByCategory()


    public void FilterByDate(String acc_lookup, Date targetStart, Date targetEnd) {
        System.out.println("FilterByDate");

        Account acc = Repository.getAccount(acc_lookup);
        System.out.println("account is: " + acc);
        for(Transaction trans : acc.getTransactions()) {
            if(trans.getDate().after(targetStart) && trans.getDate().before(targetEnd))
                buildText = buildText+"\t"+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }

        System.out.println(buildText);
    }


    public void FilterByCategoryAndDate(String acc_lookup, String targetCat, Date targetStart, Date targetEnd){
        Account acc = Repository.getAccount(acc_lookup);
        for(Transaction trans : acc.getTransactions()) {
            if(trans.getDate().after(targetStart) && trans.getDate().before(targetEnd) && trans.getCategory().equals(targetCat))
                buildText = buildText+"\t"+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }


    public void DisplayFilteredTransactions(Form zForm, String textAreaName) {
        zForm.setText(textAreaName, this.buildText);
    }
}
