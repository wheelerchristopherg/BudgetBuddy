package main.assetsubsys;

import main.repositorysys.Loan;
import main.userinterface.Form;
import main.repositorysys.Repository;
import main.graphsubsys.Graph;

public class AmCalController {

    private double balance;
    private double interestRate;
    private double monthlyPayment;
    private double totalAmountPaid;
    private double[] principal = new double[1200];
    private double[] interest = new double[1200];

    public AmCalController(AmortizationCalendarForm formIn, String loanNameIn) {
        Loan loan = Repository.getLoan(loanNameIn);
        Graph graph = createAmCal(loan);
        formIn.setGraph(graph);
    }

    private Graph createAmCal(Loan loanIn) {
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
