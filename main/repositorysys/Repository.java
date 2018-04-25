package main.repositorysys;
import java.util.*;

public class Repository{

    // Attribute: Collection of Budgets

    public static Budget createBudget(String inName, Date inStart, Date inEnd, double inSpend){
        return new Budget(inName, inStart, inEnd, inSpend);
    }
}