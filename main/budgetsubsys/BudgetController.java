package main.budgetsubsys;
import main.repositorysys.Repository;
import main.userinterface.Form;
import java.util.*; // REPLACE ME WITH SPECIFIC CLASSES

// TO DO
// import Form (?)
// Does Form need to be an attribute? Somehow we need to know which Form to talk to, right?
// and how talk to repository?

public class BudgetController{

    private int currentState;
    private boolean goalsDone;
    private String budgetName;
    private Date budgetStartDate;
    private Date budgetEndDate;
    private double spendingCap;
    private String[] categoriesList;
    private double[] spendingGoalsData;
    private double sum;

    public  BudgetController(){
        currentState = 1;
        goalsDone = false;
    }

    public void sendBudgetData(){
        this.budgetName = Form.getInput("Input the name of the budget");
        int L = Form.getInput("Input the number of categories");
        categoriesList = new String[L];
        this.budgetStartDate = Form.getInput("Input the budget start date");
        this.budgetEndDate = Form.getInput("Input the budget end date");
        this.spendingCap = Form.getInput("Input the budget's overall spendingCap");
        for (int i = 0; i<L; i++){
            this.categoriesList[i] = Form.getInput("Input a category");
        }
        currentState = 2;
    }

    public void sendSpendingGoals(){
        this.spendingGoalsData = new double[categoriesList.length];
        for (int i = 0; i<categoriesList.length;i++){
            this.spendingGoalsData[i] = Form.getInput("Input the spending goal for this category",categoriesList[i]);
        }
        sum = 0;
        for (int i = 0;i<spendingGoalsData.length-1;i++){
            sum += spendingGoalsData[i];
        }
        currentState = 3;
        if (sum > spendingCap)
            overSum();
        else if (sum < spendingCap)
            underSum();
        else
            exactSum();
    }

    public boolean getGoalsStatus(){
        return goalsDone;
    }

    public int getCurrentState(){
        return currentState;
    }

    public void overSum(){
        //print "Your spending goals sum to more than your spending cap! Retry.";
        for(int i = 0;i < spendingGoalsData.length;i++)
            spendingGoalsData[i] = 0;
    }

    public void underSum() {
        goalsDone = true;
        double difference = spendingCap - sum;

        int i = 0;
        boolean searchDone = false;
        while (!searchDone) {
            if (categoriesList[i] == "Other" || categoriesList[i] == null)
                searchDone = true;
            else
                i++;
        }

        if (i < categoriesList.length) {
            spendingGoalsData[i] = spendingGoalsData[i] + difference;
        } else {
            // concatenate(categoriesList,["Other"])
            categoriesList = Arrays.copyOf(categoriesList, categoriesList.length+1);
            categoriesList[categoriesList.length-1] = "Other";
            // concatenate(spendingGoalsData,[difference]);}
            spendingGoalsData = Arrays.copyOf(spendingGoalsData, spendingGoalsData.length+1);
            spendingGoalsData[spendingGoalsData.length-1] = difference;
            // Finish up
            currentState = 4;
            //Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, categoriesList, spendingCap, spendingGoalsData);
            Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, spendingCap);
        }
    }

    public void exactSum(){
        goalsDone = true;
        currentState = 5;
        //Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, categoriesList, spendingCap, spendingGoalsData);
        Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, spendingCap);
    }
}