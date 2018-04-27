package main.repositorysys;

public class Category  {

    private String name;
    private double spendingGoal;

    public Category(String inName, double inSpend){
        this.name = inName;
        this.spendingGoal = inSpend;
    }

    public String getName(){
        return name;
    }

    public double getGoal() {
        return spendingGoal;
    }
}
