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

    private static Collection<Account> accountCollection;
    private static Collection<Asset> assetCollection;
    //private static Collection<Bill> billCollection;
    private static Collection<BillPayReminder> billPayReminderCollection;
    private static Collection<Budget> budgetCollection;
    private static Collection<BudgetReport> budgetReportCollection;
    // Categories are located as a collection within Budget
    private static Collection<FinancialReport> financialReportCollection;
    private static Collection<Loan> loanCollection;
    // Transactions are located as a collection within Account

    public static Collection<Asset> getAssets() {
        return assets;
    }

    public static Collection<Account> getAccounts() {
        return accounts;
    }

    public static Collection<Account> getSavingsAccounts() {
        Collection<Account> sAccounts = null;
        for (Account a: accounts) {
            if(a.isSavings()) {
                sAccounts.add(a);
            }
        }
        return sAccounts;
    }

    public static Collection<Account> getCreditAccounts() {
        Collection<Account> cAccounts = null;
        for (Account a: accounts) {
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

    public static void init(){
        accountCollection = new ArrayList<Account>();
        assetCollection = new ArrayList<Asset>();
        //billCollection = new ArrayList<Bill>();
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

    public static FinancialReport createFinancialReport(String inText){
        FinancialReport returnMe = new FinancialReport(inText);
        financialReportCollection.add(returnMe);
        return returnMe;
    }

    public static Account getAccount(String findMe){
        Iterator<Account> itr = accountCollection.iterator();
        while(itr.hasNext()){
            Account checkMe = itr.next();
            if (findMe.equals(checkMe.getName()))
                    return checkMe;
        }
        return null;
    }

    public static Collection<Account> getAccountCollection(){
        return accountCollection;
    }

    public static void printBudgetCollection(){
        System.out.println("\n");
        for(Budget budg : budgetCollection){
            Collection<Category> catsList = budg.getCategories();
            System.out.println(budg.getName());
                    for (Category cat : catsList){
                        System.out.println("\t" + cat + " | " + cat.getGoal());
                    }
            System.out.println("\n");
        }
    }

}