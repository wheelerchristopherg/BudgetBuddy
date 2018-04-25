package main.repositorysys;

import java.util.*;

public class Budget{
    private String name;
    private Date startDate;
    private Date endDate;
    private double spendingCap;
    private Collection<Category> categoriesList;
    //private double[] spendingGoalsData;

    Budget(String inName, Date inStart, Date inEnd, double inSpend){
        this.name = inName;
        this.startDate = inStart;
        this.endDate = inEnd;
        this.spendingCap = inSpend;
        this.categoriesList = new ArrayList<Category>();
    }

    public String getName(){
        return this.name;
    }

    public Category createCategory(String name, double spendingGoal){
        Category nuevoCategory = new Category(name, spendingGoal);
        categoriesList.add(nuevoCategory);
        return nuevoCategory;
    }

    public Category getCategory(String findMe){
        Iterator<Category> itr = categoriesList.iterator();
        while(itr.hasNext()){
            Category checkMe = itr.next();
            if(findMe.equals(checkMe))
                return checkMe;
        }
        return null;
    }

}
