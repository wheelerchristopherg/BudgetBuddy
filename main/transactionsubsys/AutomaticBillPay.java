package main.transactionsubsys;
//import main.repositorysys.Bill;

import java.util.*;

// ********************
// this will be deleted
// *******
class Bill {
    public Date dueDate;
    public void Bill() { }
    public int compareTo(Bill b) { return 0; }
}

class Form {
    public void Form() { }
}
// ****************************


public class AutomaticBillPay {
    private ArrayList<Bill> billsOnAutoPay;
    private int currentState;
    private Form form;

    public void AutomaticBillPay(Form form) {

        this.form = form;

        // ****
        // ADD REPO INFO TO `billsOnAutoPay`
        // ****

    } // AutomaticBillPay()


    public void setAutomaticBillPay(Bill bill) {

        // ****
        // ADD info to REPO about adding autopay to this bill
        // ****

        billsOnAutoPay.add(bill);

    } // setAutomaticBillPay()


    public void payBill(Bill bill) {

        // ****
        // ADD info to REPO about paying the bill
        // ****

        cancelAutomaticBillPay(bill);

    } // payBIll()


    public void checkBillDates() {

        Date today = new Date();

        for (Bill b : billsOnAutoPay) {
            if (b.dueDate.before(today)) {
                payBill(b);
            } // if dates
        } // for : b

    } // checkBillDates()


    public boolean cancelAutomaticBillPay(Bill bill) {

        for (Bill b : billsOnAutoPay) {
            if (b.compareTo(bill) == 0) {
                billsOnAutoPay.remove(b);
                b = null;
                return true;
            } // if compare
        } // for : b

        return false;
    } // cancelAutomaticBillPay()

} // AutomaticBillPay
