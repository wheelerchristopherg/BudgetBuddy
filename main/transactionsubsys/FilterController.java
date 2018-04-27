package main.transactionsubsys;
import java.util.*;
import main.userinterface.Form;
import main.repositorysys.Account;
import main.repositorysys.Repository;
import main.repositorysys.Transaction;

public class FilterController {

    String buildText;
    Collection<Account> accColl;

    public void FilterController() {
        buildText = "";
    }
    public void FilterByCategory(String acc_lookup,String targetCat){
        Account acc = Repository.getAccount(acc_lookup);
        for(Transaction trans : acc.getTransactions()){
            if (trans.getCategory().equals(targetCat))
                buildText = buildText+"\t"+trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public void FilterByDate(String acc_lookup, Date targetStart, Date targetEnd){
        Account acc = Repository.getAccount(acc_lookup);
        for(Transaction trans : acc.getTransactions()){
            if(trans.getDate().after(targetStart) && trans.getDate().before(targetEnd))
                buildText = buildText+"\t"+trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public void FilterByCategoryAndDate(String acc_lookup, String targetCat, Date targetStart, Date targetEnd){
        Account acc = Repository.getAccount(acc_lookup);
        for(Transaction trans : acc.getTransactions()){
            if(trans.getDate().after(targetStart) && trans.getDate().before(targetEnd) && trans.getCategory().equals(targetCat))
                buildText = buildText+"\t"+trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public void DisplayFilteredTransactions(Form zForm, String textAreaName){
        zForm.setText(textAreaName, this.buildText);
    }
}