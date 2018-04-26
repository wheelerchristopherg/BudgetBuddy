package main.transactionsubsys;
import main.repositorysys.Bill;
import main.userinterface.Form;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class AutomaticBillPayController {
    private ArrayList<Bill> billsOnAutoPay;
    private int currentState;
    private Form form;

    //Loads Bill
    public void loadBillOnAutoPay() {
        String csvFile = "billsOnAutoPay.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);

                String startDateString = rmdline[2];
                DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                Date startDate = new Date();
                try {
                    startDate = df.parse(startDateString);
                    String newDateString = df.format(startDate);
                    System.out.println(newDateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                billsOnAutoPay.add(new Bill(rmdline[0], amount, startDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // loadBillOnAutoPay()

    // Save BillReminders
    public void saveBillsOnAutoPay() {
        try {
            PrintWriter pw = new PrintWriter(new File("billreminders.csv"));
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

    public void AutomaticBillPay(Form form) {

        this.form = form;
        loadBillOnAutoPay();

    } // AutomaticBillPay()


    public void setAutomaticBillPay(Bill bill) {

        billsOnAutoPay.add(bill);
        saveBillsOnAutoPay();

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
            } // if dates
        } // for : b

    } // checkBillDates()


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
