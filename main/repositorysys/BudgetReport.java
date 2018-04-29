package main.repositorysys;

public class BudgetReport {

    private String name;
    private String reportText;

    public BudgetReport(String nameIn, String inText){
        name = nameIn;
        reportText = inText;
    }

    public String getReport(){
        return reportText;
    }
    
    public String getName() {
        return name;
    }
}