package main.assetsubsys;

import main.repositorysys.Loan;
import main.userinterface.AmortizationCalendarForm;
import main.repositorysys.Repository;
import main.graphsubsys.Graph;
import main.graphsubsys.GraphFactory;
import java.util.ArrayList;

public class AmCalController {

    private double balance;
    private double interestRate;
    private double monthlyPayment;
    private ArrayList<Double> principal;

    public AmCalController(AmortizationCalendarForm formIn, String loanNameIn) {
        
        Loan loan = Repository.getLoan(loanNameIn);
        Graph graph = createAmCal(loan);
        formIn.setGraph(graph);
    }

    private Graph createAmCal(Loan loanIn) {
        getInformation(loanIn);
        
        principal = new ArrayList<Double>();

        double currentBalance = balance;
        int i = 0;
        while (currentBalance > 0) {
            principal.add(i, (currentBalance + (currentBalance * interestRate) > monthlyPayment ?
                    monthlyPayment - (currentBalance * interestRate) :
                    currentBalance - (currentBalance * interestRate)));
            currentBalance -= (currentBalance * interestRate) + principal.get(i);
            i++;
        }
        principal.remove(principal.size() - 1);
        principal.add(monthlyPayment);

        
        Double[] principalArrayWrapper = new Double[0];
        principalArrayWrapper = principal.<Double>toArray(principalArrayWrapper);
        double[] principalArray = new double[principalArrayWrapper.length];
        
        for (i = 0; i < principalArray.length; i++) {
            principalArray[i] = principalArrayWrapper[i];
            System.out.println(principalArray[i]);
        }
        
        return GraphFactory.createAmortizationCalendar(monthlyPayment, principalArray);

    }

    private void getInformation(Loan loanIn) {
        this.interestRate = loanIn.getInterestRate();
        this.balance = loanIn.getAmount();
        this.monthlyPayment = loanIn.getMonthlyPayment();

    }

}
