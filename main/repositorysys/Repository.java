package main.repositorysys;

import java.util.*;
import main.repositorysys.Asset;
import main.repositorysys.Account;
import main.repositorysys.Loan;
import main.repositorysys.Bill;
import main.repositorysys.BillPayReminder;
import main.repositorysys.Budget;
import main.repositorysys.BudgetReport;
import main.repositorysys.FinancialReport;


public class Repository {

    private static Collection<Account> accounts;
    private static Collection<Asset> assets;
    private static Collection<Loan> loans;
    private static Collection<Bill> bills;
    private static Collection<BillPayReminder> billPayReminders;
    private static Collection<Budget> budgetCollection;
    private static Collection<BudgetReport> budgetReports;
    // Categories are located as a collection within Budget
    private static Collection<FinancialReport> fReports;
    //private static Collection<FinancialReport> financialReports;
    // Transactions are located as a collection within Account

    public static Collection<Asset> getAssets() {
        return assets;
    }

    public static Collection<Account> getAccounts() {
        return accounts;
    }

    public static Collection<Account> getSavingsAccounts() {
        Collection<Account> sAccounts = null;
        Iterator i = accounts.iterator();
        while(i.hasNext()) {
            Account a = i.next();
            if(a.isSavings()) {
                sAccounts.add(a);
            }
        }
        return sAccounts;
    }

    public static Collection<Account> getCreditAccounts() {
        Collection<Account> cAccounts = null;
        Iterator i = accounts.iterator();
        while(i.hasNext()) {
            Account a = i.next();
            if(a.isSavings()) {
                cAccounts.add(a);
            }
        }
        return cAccounts;
    }

    public static Collection<Loan> getLoans() {
        return loans;
    }

    public static Loan getLoan(String nameIn) {
        Loan targetLoan;
        for (Loan l: loans) {
            if(l.getName().equals(nameIn)) {
                targetLoan = l;
            }
        }
        return targetLoan;
    }

    public static void init() {
        accounts = new ArrayList<Account>();
        //assets = new ArrayList<Assets>();
        //bills = new ArrayList<Bill>();
        //billPayReminders = new ArrayList<BillPayReminder>();
        budgetCollection = new ArrayList<Budget>();
        //budgetReports = new ArrayList<BudgetReport>();
        //financialReports = new ArrayList<FinancialReport>();
        loans = new ArrayList<Loan>();
    }

    public static Budget createBudget(String inName, Date inStart, Date inEnd, double inSpend){
        Budget constructedBudget =  new Budget(inName, inStart, inEnd, inSpend);
        budgetCollection.add(constructedBudget);
        return constructedBudget;
    }

    public static void printBudgetCollection() {
        System.out.println(budgetCollection);
    }

}