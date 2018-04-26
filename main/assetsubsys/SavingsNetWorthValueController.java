package main.assetsubsys;

import java.util.*;
import main.repositorysys.Account;
import main.repositorysys.Repository;

import main.repositorysys.Asset;
import main.repositorysys.Loan;
import main.repositorysys.Transaction;

public class SavingsNetWorthValueController {

    private Date startDate;

    public void SavingsNetWorthValueController(Date startDateIn) {
        startDate = startDateIn;
    }

    public double[] savingsOverTime(Date startingDateIn) {
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
    }

    public double[] netWorthOverTime() {

    }

    private double calculateAssetsAtDate(Date dateIn) {
        Collection<Asset> assets = Repository.getAssets();
        double totalAssetValue;


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
}