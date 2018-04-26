package main.repositorysys;

import java.util.*;

public class Loan {

    private double amount;
    private double interestRate;
    private double monthlyPayment;
    private Date startDate;

    public Loan(double amountIn, double interestRateIn, double monthlyPaymentIn, Date startDateIn) {
        amount = amountIn;
        interestRate = interestRateIn;
        monthlyPayment = monthlyPaymentIn;
        startDate = startDateIn;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setMonthlyPayment(double monthlyPaymentIn) {
        this.monthlyPayment = monthlyPaymentIn;
    }

    public boolean isBefore(Date dateIn) {
        return startDate.before(dateIn);
    }
}
