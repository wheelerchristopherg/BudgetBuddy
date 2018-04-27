package main.assetsubsys;

import java.util.*;
import main.repositorysys.Account;
import main.repositorysys.Repository;
import main.repositorysys.Asset;
import main.repositorysys.Loan;
import main.repositorysys.Transaction;
import main.graphsubsys.Graph;
import main.graphsubsys.GraphFactory;
import main.userinterface.Form;
import main.userinterface.SavingsNetworthValueForm;

public class SavingsNetWorthValueController {

    private Graph graph;

    public SavingsNetWorthValueController(String userChoice, Date startDateIn, SavingsNetworthValueForm formIn) {
        double[] graphXData = new double[10];
        double[] yAxis = {0,1,2,3,4,5,6,7,8,9};
        if(userChoice.equals("savings")) {
            graphXData = savingsOverTime(startDateIn);
        }
        else {
            graphXData = netWorthOverTime(startDateIn);
        }
        Date now = new Date();
        Graph graphOfData = GraphFactory.createLineGraph(graphXData, yAxis, startDateIn, now);
        form.setGraph(graphOfData);
    }

    private double[] savingsOverTime(Date startingDateIn) {
        double[] savingsOTData = new double[10];
        Date currentDate = new Date();
        long currDateMil = currentDate.getTime();
        long startDateMil = startingDateIn.getTime();
        long timeSpan = currDateMil - startDateMil;
        long timeInterval = timeSpan / 9;
        long[] datesInMil = new long[10];

        for (int i = 0; i < 10; i++) {
            datesInMil[i] = startDateMil + (timeInterval * i);
        }

        for (int i = 0; i < 10; i++) {
            Date thisDate = new Date(datesInMil[i]);
            savingsOTData[i] = calculateSavingsAtDate(thisDate);
        }
        return savingsOTData;
    }

    private double[] netWorthOverTime(Date startingDateIn) {
        double[] netWorthOTData = new double[10];
        Date currentDate = new Date();
        long currDateMil = currentDate.getTime();
        long startDateMil = startingDateIn.getTime();
        long timeSpan = currDateMil - startDateMil;
        long timeInterval = timeSpan / 9;
        long[] datesInMil = new long[10];

        for (int i = 0; i < 10; i++) {
            datesInMil[i] = startDateMil + (timeInterval * i);
        }

        for (int i = 0; i < 10; i++) {
            Date thisDate = new Date(datesInMil[i]);
            netWorthOTData[i] = calculateSavingsAtDate(thisDate) +
                calculateAssetsAtDate(thisDate) +
                calculateLoansAtDate(thisDate) +
                calculateCreditAtDate(thisDate);
        }
        return netWorthOTData;
    }

    private double calculateLoansAtDate(Date dateIn) {
        Collection<Loan> loans = Repository.getLoans();
        double totalLoanValue = 0;

        for(Loan l: loans) {
            if(l.isBefore(dateIn)) {
                totalLoanValue -= l.getAmount();
            }
        }
        return totalLoanValue;
    }

    private double calculateAssetsAtDate(Date dateIn) {
        Collection<Asset> assets = Repository.getAssets();
        double totalAssetValue = 0;

        for(Asset a: assets) {
            if(a.isBefore(dateIn)) {
                totalAssetValue += a.getValue();
            }
        }
        return totalAssetValue;
    }

    private double calculateSavingsAtDate(Date dateIn) {
        Collection<Account> sAccounts = Repository.getSavingsAccounts();
        Collection<Transaction> transactions = null;
        double totalSavings;

        for (Account acc : sAccounts) {
            totalSavings += acc.getBalance();
            Collection<Transaction> currentTransactions = acc.getTransactions();
            for (Transaction t : currentTransactions) {
                transactions.add(t);
            }
        }

        for (Transaction t : transactions) {
            if (t.isBefore(dateIn)) {
                totalSavings += t.getValue();
            }

            return totalSavings;
        }
    }

    private double calculateCreditAtDate(Date dateIn) {
        Collection<Account> cAccounts = Repository.getCreditAccounts();
        Collection<Transaction> transactions = null;
        double totalCredit;

        for (Account acc : cAccounts) {
            totalCredit -= acc.getBalance();
            Collection<Transaction> currentTransactions = acc.getTransactions();
            for (Transaction t : currentTransactions) {
                transactions.add(t);
            }
        }

        for (Transaction t : transactions) {
            if (t.isAfter(dateIn)) {
                totalCredit += t.getValue();
            }

            return totalCredit;
        }
    }
}