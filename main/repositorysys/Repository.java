package main.repositorysys;

import java.util.*;

public class Repository {

    private static Collection<Account> accounts;
    //private static Collection<Asset> assets;
    //private static Collection<Bill> bills;
    //private static Collection<BillPayReminder> billPayReminders;
    private static Collection<Budget> budgetCollection;
    //private static Collection<BudgetReport> budgetReports;
    // Categories are located as a collection within Budget
    //private static Collection<FinancialReport> financialReports;
    private static Collection<Loan> loans;
    // Transactions are located as a collection within Account

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