package main.transactionsubsys;
import java.util.*;
import java.util.function.Function;

import main.userinterface.Form;
import main.repositorysys.Account;
import main.repositorysys.Repository;
import main.repositorysys.Transaction;

public class FilterController {

    public void FilterByCategory(String acc_lookup, String targetCat) {
        this.buildText = "";
        for (Transaction t : Repository.getAccount(acc_lookup).getTransactions())
            if (categoryMatches(t, targetCat))
                this.buildText += "\t\n" + t.getTransactionString();
    } // FilterByCategory()

    public void FilterByDate(String acc_lookup, Date targetStart, Date targetEnd) {
        this.buildText = "";
        for (Transaction t : Repository.getAccount(acc_lookup).getTransactions())
            if (withinDates(t, targetStart, targetEnd))
                this.buildText += "\t\n" + t.getTransactionString();
    } // FilterByDate()

    public void FilterByCategoryAndDate(String acc_lookup, String targetCat, Date targetStart, Date targetEnd) {
        this.buildText = "";
        for (Transaction t : Repository.getAccount(acc_lookup).getTransactions())
            if (categoryMatches(t, targetCat) && withinDates(t, targetStart, targetEnd))
                this.buildText += "\t\n" + t.getTransactionString();
    } // FilterByCategoryAndDate()

    // Display this.buildText
    public void DisplayFilteredTransactions(Form zForm, String textAreaName) {
        zForm.setText(textAreaName, this.buildText);
    } // DisplayFilteredTransactions()

    // added this for readability
    private Boolean categoryMatches(Transaction t, String c) {
        return t.getCategory().equals(c);
    } // categoryMatches()

    // added this for readability
    private Boolean withinDates(Transaction t, Date d1, Date d2) {
        return d1.before(t.getDate()) && d2.after(t.getDate());
    } // withinDates()

} // FilterController
