package main.transactionsubsys;

import main.repositorysys.Account;
import main.repositorysys.Repository;
import main.userinterface.Form;
import main.repositorysys.Transaction;
import main.repositorysys.BillPayReminder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionSystem {
    
    private static RecordTransactionController recordTransactionController;
    private static AutomaticBillPayController abp;

    //Loads Bill
    public static void loadCashTransactions() {
        
        String csvFile = "main/data/transactions.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        Account cash = Repository.getAccount("cash");

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
    
    public static void loadBillOnAutoPay() {
        String csvFile = "main/data/billsOnAutopay.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader bra = new BufferedReader(new FileReader(csvFile))) {
            while ((line = bra.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);
                Repository.createAutomaticBillPayReminder(rmdline[0], amount, rmdline[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveBillsOnAutoPay() {
        try {
            PrintWriter pw = new PrintWriter(new File("main/data/billsOnAutopay.csv"));
            for (BillPayReminder r : Repository.getAutomaticBillPayReminders()) {
                StringBuilder sb = new StringBuilder();
                sb.append(r.getName());
                sb.append(',');
                sb.append(r.getAmount());
                sb.append(',');
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                sb.append(sdf.format(r.getReminderDate()));
                sb.append('\n');
                pw.write(sb.toString());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("billreminders.csv Not Found");
        }
    } // saveBillsOnAutoPay()

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
    
    public static void createRecordTransactionController(Form form) {
        recordTransactionController = new RecordTransactionController(form);
    }
    
    public static RecordTransactionController getRecordTransactionController() {
        return recordTransactionController;
    }
    
    public static void createAutomaticBillPayController(Form form) {
        abp = new AutomaticBillPayController(form);
    }
    
    public static AutomaticBillPayController getAutomaticBillPayController() {
        return abp;
    }
}
