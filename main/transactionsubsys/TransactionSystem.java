package main.transactionsubsys;

import main.repositorysys.Account;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionSystem {

    //Loads Bill
    public static void loadCashTransactions() {
        
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
}
