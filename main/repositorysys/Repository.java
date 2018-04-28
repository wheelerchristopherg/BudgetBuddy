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

    private static Repository single_instance = null;

    private static Collection<Account> accountCollection = new ArrayList<Account>();
    private static Collection<Asset> assetCollection = new ArrayList<Asset>();
    //private static Collection<Bill> billCollection;
    private static Collection<BillPayReminder> billPayReminderCollection = new ArrayList<BillPayReminder>();
    private static Collection<Budget> budgetCollection = new ArrayList<Budget>();
    private static Collection<BudgetReport> budgetReportCollection = new ArrayList<BudgetReport>();
    // Categories are located as a collection within Budget
    private static Collection<FinancialReport> financialReportCollection = new ArrayList<FinancialReport>();
    private static Collection<Loan> loanCollection = new ArrayList<Loan>();
    // Transactions are located as a collection within Account

    public static Collection<Asset> getAssets() {
        return assetCollection;
    }

    public static Collection<Account> getAccounts() {
        return accountCollection;
    }

    public static Collection<Account> getSavingsAccounts() {
        Collection<Account> sAccounts = null;
        for (Account a: accountCollection) {
            if(a.isSavings()) {
                sAccounts.add(a);
            }
        }
        return sAccounts;
    }

    public static Collection<Account> getCreditAccounts() {
        Collection<Account> cAccounts = null;
        for (Account a: accountCollection) {
            if(a.isSavings()) {
                cAccounts.add(a);
            }
        }
        return cAccounts;
    }

    public static Collection<Loan> getLoans() {
        return loanCollection;
    }

    public static Loan getLoan(String nameIn) {
        Loan targetLoan = null;
        for (Loan l: loanCollection) {
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

    public static Account createAccount(String inName, String inType, double inBal, double inRate){
        Account zAccount = new Account(inName, inType, inBal, inRate);
        accountCollection.add(zAccount);
        return zAccount;
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
        if (!budgetCollection.isEmpty()) {
            System.out.println("\n");
            for (Budget budg : budgetCollection) {
                Collection<Category> catsList = budg.getCategories();
                System.out.println(budg.getName() + "\n" + budg.getStartDate() + " - " + budg.getEndDate());
                for (Category cat : catsList) {
                    System.out.println("\t" + cat.getName() + "\t| $" + cat.getGoal());
                }
                System.out.println("\tTotal : $" + budg.getSpendingCap() + "\n");
            }
        }
        else
            System.out.println("You don't have any budgets!");
    }
    
    public static void createLoan(String nameIn, double amountIn, double interestRateIn, double monthlyPaymentIn, Date startDateIn) {
        loanCollection.add(new Loan(nameIn, amountIn, interestRateIn, monthlyPaymentIn, startDateIn));
    }

}