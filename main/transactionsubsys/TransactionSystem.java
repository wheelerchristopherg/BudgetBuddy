package main.transactionsubsys;


import main.repositorysys.Account;
import main.repositorysys.Transaction;
import main.repositorysys.Bill;
import main.repositorysys.Repository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionSystem {
/*<<<<<<< HEAD
=======*/
    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    private static FilterController filterController = new FilterController();


    public TransactionSystem() { }

    // this is a helper method for parseBills()
    // inputs: filepath of csv file
    // outputs: 2d list of data in csv file
    public static ArrayList<String[]> parseGenericCSV(String filepath) {
        String line = "";
        ArrayList<String[]> result = new ArrayList<String[]>();

        try (BufferedReader bra = new BufferedReader(new FileReader(filepath))) {
            while ((line = bra.readLine()) != null) {
                result.add(line.split(","));
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        } // catch

        return result;
    } // parseGenericCSV


    public static void parseBills() {
        String billFilePath = "./main/data/bank/bills.csv";

        ArrayList<String[]>  parsedData = parseGenericCSV(billFilePath);

        for (String[] dat : parsedData) {
            Double value = Double.parseDouble(dat[1]);
            Bill b = new Bill(dat[0], value, dat[2]);
            Repository.addBill(b);
        } // for

    } // paseBills()


    public static void createFilterController() {
        filterController = new FilterController();
    }
//>>>>>>> 37feee6b15ba45956702cad76aece2d26bb10756

    public static FilterController getFilterController() {
        return filterController;
    }



    public static String getAllTransactionsString() {
        String ret = "";
        for (Transaction t : transactions) {
            ret += t.getTransactionString() + "\n";
        }
        return ret;
    }


    //Loads Bill
/*<<<<<<< HEAD
    public static void loadCashTransactions() {
        
=======*/
    public static void loadTransactions() {
//>>>>>>> 37feee6b15ba45956702cad76aece2d26bb10756
        String csvFile = "main/data/transactions.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        Account cash = Repository.createAccount("cash", "cash", 0.0, 0.0);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);
                cash.createTransaction(rmdline[0], amount, rmdline[2]);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadBillOnAutoPay() {
        String csvFile = "main/data/billsOnAutopay.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader bra = new BufferedReader(new FileReader(csvFile))) {
            while ((line = bra.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);
                Bill bill = new Bill(rmdline[0], amount, rmdline[2]);
                setAutomaticBillPay(bill);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save BillReminders
    public static void saveTransactions() {
        
        Account cash = Repository.getAccount("cash");
        
        try {
            PrintWriter pw = new PrintWriter(new File("main/data/transactions.csv"));
            for (Transaction t : cash.getTransactions()) {
                StringBuilder sb = new StringBuilder();
                sb.append(t.getCategory());
                sb.append(',');
                sb.append(t.getValue());
                sb.append(',');
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                sb.append(sdf.format(t.getDate()));
                sb.append('\n');
                pw.write(sb.toString());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("transactions.csv Not Found");
        }
    }
//<<<<<<< HEAD
//=======

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


    // This is where all transactions are stored
//>>>>>>> 37feee6b15ba45956702cad76aece2d26bb10756
}
