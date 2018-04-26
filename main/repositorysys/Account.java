package main.repositorysys;

public class Account {

    private String name;
    private String type;
    private double balance;
    private double interestRate;
    private Collection<Transaction> transactionCollection;

    public Account(){
        System.out.println("Placeholder...");
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getBalance(){
        return balance
    }
    public double getInterestRate(){
        return interestRate
    }

    public Collection<Transaction> getTransactions(){
        return transactionCollection;
    }
}
