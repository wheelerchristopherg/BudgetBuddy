package main.budgetsubsys;
import main.repositorysys.Budget;
import main.repositorysys.Repository;
import main.userinterface.Form;
import java.util.*; // REPLACE ME WITH SPECIFIC CLASSES

// TO DO
// import Form (?)
// Does Form need to be an attribute? Somehow we need to know which Form to talk to, right?
// What about categories?

public class BudgetController{

    private int currentState;
    private boolean goalsDone;
    private String budgetName;
    private Date budgetStartDate;
    private Date budgetEndDate;
    private double spendingCap;
    private String[] categoriesArray;
    private double[] spendingGoalsData;
    private double sum;

    BudgetController(){
        currentState = 1;
        goalsDone = false;
    }

    public void sendBudgetData(){
        this.budgetName = Form.getInput("Input the name of the budget"); // .getInput is a placeholder
        int L = Form.getInput("Input the number of categories"); // .getInput is a placeholder
        categoriesArray = new String[L];
        this.budgetStartDate = Form.getInput("Input the budget start date"); // .getInput is a placeholder
        this.budgetEndDate = Form.getInput("Input the budget end date"); // .getInput is a placeholder
        this.spendingCap = Form.getInput("Input the budget's overall spendingCap"); // .getInput is a placeholder
        for (int i = 0; i<L; i++){
            this.categoriesArray[i] = Form.getInput("Input a category"); // .getInput is a placeholder
        }
        currentState = 2;
    }

    public void sendSpendingGoals(){
        this.spendingGoalsData = new double[categoriesArray.length];
        for (int i = 0; i<categoriesArray.length;i++){
            this.spendingGoalsData[i] = Form.getInput("Input the spending goal for this category",categoriesArray[i]); // .getInput is a placeholder
        }
        sum = 0;
        for (int i = 0;i<spendingGoalsData.length;i++){
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

    private void overSum(){
        //print "Your spending goals sum to more than your spending cap! Retry.";
        for(int i = 0;i < spendingGoalsData.length;i++)
            spendingGoalsData[i] = 0;
    }

    private void underSum() {
        goalsDone = true;
        double difference = spendingCap - sum;

        int i = 0;
        boolean searchDone = false;
        while (!searchDone) {
            if (categoriesArray[i].equals("Other") || categoriesArray[i] == null)
                searchDone = true;
            else
                i++;
        }

        if (i < categoriesArray.length-1){
            spendingGoalsData[i] = spendingGoalsData[i] + difference;
        }else{
            // concatenate(categoriesArray,["Other"])
            categoriesArray = Arrays.copyOf(categoriesArray, categoriesArray.length+1);
            categoriesArray[categoriesArray.length-1] = "Other";
            // concatenate(spendingGoalsData,[difference]);}
            spendingGoalsData = Arrays.copyOf(spendingGoalsData, spendingGoalsData.length+1);
            spendingGoalsData[spendingGoalsData.length-1] = difference;
            currentState = 4; // Update State
        }

        Budget nuevoBudget = Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, spendingCap); //
        // Categories?
        for(int e = 0; e < categoriesArray.length; e++){
            nuevoBudget.createCategory(categoriesArray[e],spendingGoalsData[e]);
        }
    }

    private void exactSum(){
        goalsDone = true;
        currentState = 5;
        //Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, categoriesArray, spendingCap, spendingGoalsData);
        Budget nuevoBudget = Repository.createBudget(budgetName, budgetStartDate, budgetEndDate, spendingCap);
        // Categories?
        for(int e = 0; e < categoriesArray.length; e++){
            nuevoBudget.createCategory(categoriesArray[e],spendingGoalsData[e]);
        }
    }
}