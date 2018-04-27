package main.budgetsubsys;
import main.repositorysys.Budget;
import main.repositorysys.Repository;
import main.userinterface.Form;
import java.util.*; // REPLACE ME WITH SPECIFIC CLASSES
import javax.swing.JOptionPane;
//import java.text.DateFormat;

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

    public BudgetController(){
        currentState = 1;
        goalsDone = false;
    }

    public void sendBudgetData(Form someForm){
        this.budgetName = JOptionPane.showInputDialog(someForm, "Input the name of the budget");
        int L = Integer.parseInt(JOptionPane.showInputDialog(someForm, "Input the number of categories"));
        categoriesArray = new String[L];
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        this.budgetStartDate = sdf.parse(JOptionPane.showInputDialog(someForm, "Input the budget start date in the format DD/MM/YYYY")));
        this.budgetEndDate = sdf.parse(JOptionPane.showInputDialog(someForm, "Input the budget end date in the format DD/MM/YYYY")));

        System.out.println(budgetStartDate);
        System.out.println(budgetEndDate);
        
        this.spendingCap = Double.parseDouble(JOptionPane.showInputDialog(someForm, "Input the budget's overall spendingCap"));
        for (int i = 0; i<L; i++){
            this.categoriesArray[i] = JOptionPane.showInputDialog(someForm, "Input a category");
        }
        currentState = 2;
    }

    public void sendSpendingGoals(Form someForm){
        this.spendingGoalsData = new double[categoriesArray.length];
        for (int i = 0; i<categoriesArray.length;i++){
            this.spendingGoalsData[i] = Double.parseDouble(JOptionPane.showInputDialog(someForm,"Input the spending goal for the category \""+categoriesArray[i]+"\""));
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
        //JOptionPane.createDialog("Your spending goals sum to more than your spending cap! Retry.");
        Arrays.fill(spendingGoalsData, 0);
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

