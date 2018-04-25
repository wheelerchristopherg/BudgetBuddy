package main.repositorysys;

import java.util.*;

public class Repository{

    // Attribute: Collection of Budgets

    public static Budget createBudget(String inName, Date inStart, Date inEnd, double inSpend){
        return new Budget(inName, inStart, inEnd, inSpend);
    }

    public static BillPayReminder createBillPayReminder(String name, double amount, Date reminderDate) {
        return new BillPayReminder(name, amount,reminderDate);
    }

}