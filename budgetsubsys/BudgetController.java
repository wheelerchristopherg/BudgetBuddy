package budgetsubsys;
import java.util.*; // REPLACE ME WITH SPECIFIC PACKAGES

// TO DO
// import form (?)
// Does form need to be an attribute? Somehow we need to know which form to talk to, right?
// and how talk to repository?

public class BudgetController{

    private int currentState;
    private boolean goalsDone;
    private Date budgetStartDate;
    private Date budgetEndDate;
    private double spendingCap;
    private String[] categoriesList;
    private double[] spendingGoalsData;
    private double sum;

    public  BudgetController(form Form){
        currentState = 1;
        goalsDone = false;
    }

    public void sendBudgetData(){
        int L = form.getInput("Input the number of categories");
        categoriesList = new String[L];
        this.budgetStartDate = form.getInput("Input the budget start date");
        this.budgetEndDate = form.getInput("Input the budget end date");
        this.spendingCap = form.getInput("Input the budget''s overall spendingCap");
        for (int i = 0; i<L; i++){
            this.categoriesList[i] = form.getInput("Input a category");
        }
        currentState = 2;
    }

    public void sendSpendingGoals(){
        this.spendingGoalsData = new double[categoriesList.length];
        for (int i = 0; i<categoriesList.length;i++){
            this.spendingGoalsData[i] = form.getInput("Input the spending goal for this category",categoriesList[i]);
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
            repository.createBudget(budgetStartDate, budgetEndDate, categoriesList, spendingCap, spendingGoalsData);
        }
    }

    public void exactSum(){
        goalsDone = true;
        currentState = 5;
        repository.createBudget(budgetStartDate,budgetEndDate,categoriesList,spendingCap,spendingGoalsData);
    }
}