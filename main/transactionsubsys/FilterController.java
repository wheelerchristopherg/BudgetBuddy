package main.transactionsubsys;
import java.util.*;
import main.userinterface.Form;
import main.repositorysys.Account;

public class FilterController {

    String buildText;
    Collection<Account> accColl;

    public void FilterController() {
        buildText = "";
    }
    public .... FilterByCategory(String acc,String targetCat){
        Repository.getAccount(acc);
        for(Transaction trans : acc.getTransactions()){
            if (trans.getCategory().equals(targetCat))
                buildText = buildText+"\t"trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public .... FilterByDate(String acc, Date targetStart, Date targetEnd){
        Repository.getAccount(acc);
        for(Transaction trans : acc.getTransactions()){
            if(trans.after(targetStart) && trans.after(targetEnd))
                buildText = buildText+"\t"trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public .... FilterByCategoryAndDate(String acc, String targetCat, Date targetStart, Date targetEnd){
        Repository.getAccount(acc);
        for(Transaction trans : acc.getTransactions()){
            if(trans.after(targetStart) && trans.after(targetEnd) && trans.getCategory().equals(targetCat))
                buildText = buildText+"\t"trans.getVendor()+"\n"+trans.getCategory()+"\n"+trans.getDate()+"\n$"+trans.getValue()+"\n";
        }
    }
    public void DisplayFilteredTransactions(Form zForm, String textAreaName){
        zForm.setText(textAreaName, this.buildText);
    }
}