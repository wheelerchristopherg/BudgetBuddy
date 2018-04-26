package main.transactionsubsys;

import main.repositorysys.Transaction;
import java.util.Random;


public class BankDataInterface {
    TransactionSystem tsys = new TransactionSystem();
    //RecordTransactionController rtc = new RecordTransactionController();

    // Generate Transactions from bank
    public void generateTransactions(int numOfTransactions) {
        for(int i = 0; i <= numOfTransactions; i++) {

            //Generate Random Type
            String randString = getRandomWord(5); //Replace with categories

            //Generate Random Value
            double upper = 1000;
            double lower = -1000;
            double randValue = (double) Math.round( (Math.random() * (upper - lower) + lower) * 100.0) / 100.0;

            //Generate Random Date
            Random rand = new Random();
            int dateHighm = 12;
            int dateLowm = 1;
            int randDatd_month = rand.nextInt((dateHighm - dateLowm) + 1) + dateLowm;

            int dateHighd = 30;
            int dateLowd = 1;
            int randDatd_day = rand.nextInt((dateHighd - dateLowd) + 1) + dateLowd;

            int dateHighy = 18;
            int dateLowy = 10;
            int randDatd_year = rand.nextInt((dateHighy - dateLowy) + 1) + dateLowy;

            Transaction tempTransaction = new Transaction(randString, randValue,
                    randDatd_month + "-" + randDatd_day + "-20" + randDatd_year);
            tsys.addTransaction(tempTransaction);
        }
        tsys.saveTransactions(); //Save the transactions

    }

   private String getRandomWord(int length) {
        String[] list = {"Food", "Services", "Games", "Item", "Groceries", "Bill"
                , "Gift", "Automotive", "Fuel", "Medical", "Insurance"
                , "Office", "Supplies", "Home", "Pet Care", "Mortgage"
                , "Rent", "Loan", "Personal", "Cable", "Phone", "Reward"
                , "Entertainment", "Recreation"}; //23
        Random rand = new Random();
        int high = 12;
        int low = 1;
        int randN = rand.nextInt((high - low) + 1) + low;
        return list[randN];
    }


}
