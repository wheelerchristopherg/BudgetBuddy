package main.repositorysys;

public class Category  {

    String name;
    double spendingGoal;

    public Category(String inName, double inSpend){
        this.name = inName;
        this.spendingGoal = inSpend;
    }

    public String getName(){
        return name;
    }
    
    public double getSpendingGoal() {
        return this.spendingGoal;
    }
}
