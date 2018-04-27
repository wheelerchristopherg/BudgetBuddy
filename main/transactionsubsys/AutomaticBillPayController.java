package main.transactionsubsys;
import main.repositorysys.Bill;
import main.repositorysys.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class AutomaticBillPayController {
    private ArrayList<Bill> billsOnAutoPay = new ArrayList<Bill>();

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
    public void saveBillsOnAutoPay() {
        try {
            PrintWriter pw = new PrintWriter(new File("main/data/billsOnAutopay.csv"));
            for (Bill r : billsOnAutoPay) {
                StringBuilder sb = new StringBuilder();
                sb.append(r.getName());
                sb.append(',');
                sb.append(r.getValue());
                sb.append(',');
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                sb.append(sdf.format(r.getDueDate()));
                sb.append('\n');
                pw.write(sb.toString());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("billreminders.csv Not Found");
        }
    } // saveBillsOnAutoPay()


    public void setAutomaticBillPay(Bill bill) {

        billsOnAutoPay.add(bill);
        //saveBillsOnAutoPay();

    } // setAutomaticBillPay()


    public void payBill(Bill bill) {
        cancelAutomaticBillPay(bill);
        saveBillsOnAutoPay();
    } // payBIll()


    public void checkBillDates() {

        Date today = new Date();

        for (Bill b : billsOnAutoPay) {
            if (b.getDueDate().before(today)) {
                payBill(b);
            }
        }
    }

    TransactionSystem transys = new TransactionSystem();

    public void checkSingleDate(Bill bill) {
        Date today = new Date();
        if(bill.getDueDate().before(today)) {
            sendNotification(bill);
            transys.loadTransactions();
            Transaction transaction = new Transaction(bill.getName(), bill.getValue(), bill.getDateString());
            transys.addTransaction(transaction);
            transys.saveTransactions();
        }
    }

    public void sendNotification(Bill bill) {
        JOptionPane.showMessageDialog(null, "Pay Bill: "+ bill.getName() + "!");
    }


    public boolean cancelAutomaticBillPay(Bill bill) {

        for (Bill b : billsOnAutoPay) {
            if (b.equals(bill)) {
                billsOnAutoPay.remove(b);
                b = null;
                return true;
            } // if compare
        } // for : b

        return false;
    } // cancelAutomaticBillPay()

} // AutomaticBillPay
