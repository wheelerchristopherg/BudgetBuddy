package main.repositorysys;
import java.util.*;
import main.repository.Account;
import main.userinterface.Form;
import main.repositorysys.Transaction;


public class FinancialReport {

    private String reportText;

    public FinancialReport(String inText){
        reportText = inText;
    }

    public String getReport(){
        return reportText;
    }
}