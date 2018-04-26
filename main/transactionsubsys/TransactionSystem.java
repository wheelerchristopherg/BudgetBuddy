package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Transaction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionSystem {
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void TransactionSystem() {

    }

    //Loads Bill
    public void loadTransactions() {
        String csvFile = "transactions.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);
                Transaction temprmd = new Transaction(rmdline[0], amount, rmdline[2]);
                addTransaction(temprmd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save BillReminders
    public void saveTransactions() {
        try {
            PrintWriter pw = new PrintWriter(new File("transactions.csv"));
            for (Transaction t : transactions) {
                StringBuilder sb = new StringBuilder();
                sb.append(t.getType());
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

    public void addTransaction(Transaction transaction) {
       transactions.add(transaction);
    }


    // This is where all transactions are stored
}
