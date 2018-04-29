package main.repositorysys;
import java.util.*;
import java.text.*;

public class Budget{
    private String name;
    private Date startDate;
    private Date endDate;
    private double spendingCap;
    private Collection<Category> categoriesList;
    //private double[] spendingGoalsData;

    public Budget(String inName, Date inStart, Date inEnd, double inSpend){
        this.name = inName;
        this.startDate = inStart;
        this.endDate = inEnd;
        this.spendingCap = inSpend;
        this.categoriesList = new ArrayList<Category>();
    }

    public String getName(){
        return this.name;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public String getStartDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.getDateInstance().format(this.startDate);
    }

    public String getEndDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.getDateInstance().format(this.endDate);
    }

    public Category getCategory(String findMe){
        Iterator<Category> itr = categoriesList.iterator();
        while(itr.hasNext()){
            Category checkMe = itr.next();
            if(findMe.equals(checkMe.getName()))
                return checkMe;
        }
        return null;
    }

    public double getSpendingCap(){
        return this.spendingCap;
    }

    public Collection<Category> getCategories(){
        return categoriesList;
    }

    public Category createCategory(String name, double spendingGoal){
        Category nuevoCategory = new Category(name, spendingGoal);
        categoriesList.add(nuevoCategory);
        return nuevoCategory;
    }

}
