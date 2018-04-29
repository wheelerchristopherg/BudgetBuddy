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
        //double[] testXValues = {2.0,3.0,4.0,2.0,5.0,3.0,6.0,2.0,4.0,2.0,4.0};
        double[] yAxis = {0,1,2,3,4,5,6,7,8,9};
        if(userChoice.equals("savings")) {
            graphXData = savingsOverTime(startDateIn);
        }
        else {
            graphXData = netWorthOverTime(startDateIn);
        }
        Date now = new Date();
        Graph graphOfData = GraphFactory.createLineGraph(yAxis, graphXData, startDateIn, now);
        formIn.setGraph(graphOfData);
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
        Account[] sAccounts = Repository.getSavingsAccounts();
        Collection<Transaction> transactions = new ArrayList<Transaction>();
        double totalSavings = 0;
        if (sAccounts != null) {
            for (int i = 0; i < sAccounts.length; i++) {
                if (sAccounts[i] != null) {
                    totalSavings += sAccounts[i].getBalance();
                    Collection<Transaction> currentTransactions = sAccounts[i].getTransactions();
                    if (currentTransactions != null) {
                        for (Transaction t : currentTransactions) {
                            if (t != null) {
                                transactions.add(t);
                            }
                        }
                    }
                }
            }
            for (Transaction t : transactions) {
                if (t != null && t.isBefore(dateIn)) {
                    totalSavings += t.getValue();
                }
            }
        }

        return totalSavings;
    }

    private double calculateCreditAtDate(Date dateIn) {
        Account[] cAccounts = Repository.getCreditAccounts();
        Collection<Transaction> transactions = new ArrayList<Transaction>();
        double totalCredit = 0;
        if (cAccounts != null) {
            for (int i = 0; i < cAccounts.length; i++) {
                if (cAccounts[i] != null) {
                    totalCredit -= cAccounts[i].getBalance();
                    Collection<Transaction> currentTransactions = cAccounts[i].getTransactions();
                    if (currentTransactions != null) {
                        for (Transaction t : currentTransactions) {
                            if (t != null) {
                                transactions.add(t);
                            }
                        }
                    }
                }
            }
            for (Transaction t : transactions) {
                if (t != null && t.isAfter(dateIn)) {
                    totalCredit += t.getValue();
                }
            }
        }

        return totalCredit;
    }
}