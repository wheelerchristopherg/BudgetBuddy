package main.budgetsubsys;

import main.userinterface.Form;
import main.userinterface.BudgetReportForm;
import main.repositorysys.BudgetReport;
import main.repositorysys.Repository;
import main.repositorysys.Account;
import main.repositorysys.Transaction;
import main.repositorysys.Budget;
import main.repositorysys.Category;
import main.graphsubsys.GraphFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class BudgetReportController {

    private BudgetReportForm form;
    private BudgetReport bReport;
    double[] categoryTotals;
    String[] categoryNames;

    public BudgetReportController(Form form) {
        this.form = (BudgetReportForm)form;
        getBudgets();
    }
    
    private void getBudgets() {
        String[] names = Repository.getBudgetNames();
        String textAreaOutput = "";
        
        if (names == null) {
            textAreaOutput = "There currently no budgets.";
        } else {
            textAreaOutput = "Choose one of the following budgets:\n";
            for (int i = 0; i < names.length; i++) {
                textAreaOutput += names[i] + "\n";
            }
        }
        
        form.setText("report", textAreaOutput);
    }
    
    public void generateReport() {
        String name = form.getTextFromInput("budget");
        Budget budget = Repository.getBudget(name);
        
        Collection<Transaction> transactions = new ArrayList<Transaction>();
        Collection<Transaction> old = new ArrayList<Transaction>();
        
        if (budget == null) {
            JOptionPane.showMessageDialog(form, "That budget or budget report does not exist!");
            return;
        }
        for (Account acc : Repository.getAccounts()) {
            for (Transaction t : acc.getTransactions()) {
                if (t.isBefore(budget.getEndDate()) && t.isAfter(budget.getStartDate())) {
                    transactions.add(t);
                }
            }
        }
        
        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
        
        String report = "\"" + budget.getName() + "\" Report:\n";
        
        categoryTotals = new double[budget.getCategories().size()];
        categoryNames = new String[budget.getCategories().size()];
        double total = 0;
        int i = 0;
        for (Category c : budget.getCategories()) {
            report += "Category: " + c.getName() + "\n";
            categoryNames[i] = c.getName();
            for (Transaction t : transactions) {
                if ((t.getCategory().equals(c.getName())) && (!c.getName().equals("Other"))) {
                    if (t.getValue() < 0) {
                        categoryTotals[i] += t.getValue();
                    }
                    old.add(t);
                } else if (c.getName().equals("Other")) {
                    if (t.getValue() < 0) {
                        categoryTotals[i] += t.getValue();
                    }
                }
            }
            
            total += Math.abs(categoryTotals[i]);
            
            for (Transaction t : old) {
                transactions.remove(t);
            }
            report += "    Allotted: " + formatter.format(c.getGoal()) + "\n";
            report += "    Spent:    " + formatter.format(Math.abs(categoryTotals[i])) + "\n";
            i++;
        }
        
        report += "------------------------------------------------------------------------------------------\n";
        
        report += "Total Allotted: " + formatter.format(budget.getSpendingCap()) + "\n";
        report += "Total Spent:    " + formatter.format(total);
        
        bReport = Repository.createBudgetReport(budget.getName(), report);
        outputReport();
    }
    
    public void outputReport() {
        form.setText("report", bReport.getReport());
        form.setGraph(GraphFactory.createPieChart(categoryTotals, categoryNames));
    }
    
    public void exportReport() {
        if (bReport == null) {
            String name = form.getTextFromInput("budget");
            bReport = Repository.getBudgetReport(name);
            if (bReport == null) {
                generateReport();
            }
        }
        
        if (bReport != null) {
            try {
                File file = new File("BudgetReport_" + bReport.getName() + ".txt");

                PrintWriter writer = new PrintWriter(file);
                writer.println(bReport.getReport());
                writer.close();
                JOptionPane.showMessageDialog(form, "Report is saved in BudgetReport_" + bReport.getName() + ".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
