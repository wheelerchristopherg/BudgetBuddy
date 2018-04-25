package main.assetsubsys;

import main.repositorysys.Loan;

public class AmCalController {
    private Loan loan;
    private double balance;
    private double interestRate;
    private double monthlyPayment;
    private double totalAmountPaid;
    private double[] principal = new double[1200];
    private double[] interest = new double[1200];

    public void createAmCal(Loan loanIn) {
        getInformation(loanIn);

        double currentBalance = balance;
        for(int i = 0; i < 1200 && currentBalance > 0; i++) {
            interest[i] = currentBalance * interestRate;
            principal[i] = (currentBalance + (currentBalance * interestRate) > monthlyPayment ?
                    monthlyPayment - (currentBalance * interestRate) :
                    currentBalance - (currentBalance * interestRate));
            currentBalance -= principal[i];
        }

        for(int i = 0; i < 1200; i++) {
            totalAmountPaid += principal[i];
            totalAmountPaid += interest[i];
        }



    }

    private void getInformation(Loan loanIn) {
        this.interestRate = loanIn.getInterestRate();
        this.balance = loanIn.getAmount();
        this.monthlyPayment = loanIn.getMonthlyPayment();

    }

}
