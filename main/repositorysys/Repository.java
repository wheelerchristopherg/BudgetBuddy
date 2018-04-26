package main.repositorysys;

import java.util.*;

public class Repository {

    private static Collection<Account> accountCollection;
    private static Collection<Asset> assetCollection;
    private static Collection<Bill> billCollection;
    private static Collection<BillPayReminder> billPayReminderCollection;
    private static Collection<Budget> budgetCollection;
    private static Collection<BudgetReport> budgetReportCollection;
    // Categories are located as a collection within Budget
    private static Collection<FinancialReport> financialReportCollection;
    private static Collection<Loan> loanCollection;
    // Transactions are located as a collection within Account

    public static void init(){
        accountCollection = new ArrayList<Account>();
        assetCollection = new ArrayList<Asset>();
        billCollection = new ArrayList<Bill>();
        billPayReminderCollection = new ArrayList<BillPayReminder>();
        budgetCollection = new ArrayList<Budget>();
        budgetReportCollection = new ArrayList<BudgetReport>();
        financialReportCollection = new ArrayList<FinancialReport>();
        loanCollection = new ArrayList<Loan>();
    }

    public static Budget createBudget(String inName, Date inStart, Date inEnd, double inSpend){
        Budget constructedBudget =  new Budget(inName, inStart, inEnd, inSpend);
        budgetCollection.add(constructedBudget);
        return constructedBudget;
    }
}