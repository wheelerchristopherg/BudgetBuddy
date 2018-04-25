package main.repositorysys;

import java.util.*;

public class Repository {

    static Collection<Account>
    static Collection<Asset>
    static Collection<Bill>
    static Collection<BillPayReminder>
    static Collection<Budget> budgetCollection;
    static Collection<BudgetReport>
    // Categories are located as a collection within Budget
    static Collection<FinancialReport>
    static Collection<Loan>
    // Transactions are located as a collection within Account

    public static Budget createBudget(String inName, Date inStart, Date inEnd, double inSpend){
        Budget constructedBudget =  new Budget(inName, inStart, inEnd, inSpend);
        budgetCollection.add(constructedBudget);
        return constructedBudget;
    }

}