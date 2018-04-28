package main.userinterface;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import main.transactionsubsys.TransactionSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FilterForm extends Form {

    private TransactionSystem transactionSystem;



    public FilterForm(Window parent) {
        super(parent);

        setGridLayout(6, 3);
        addLabel("Filter Transactions");
        addTextField("accountName", "Enter Account Name");
        addTextArea("TransactionList",100,1,false);
        addTextField("startDate", "Start Date (mm-dd-yyyy)");
        addTextField("endDate", "End Date (mm-dd-yyyy)");
        addButton("fByDate", "Filter By Date");
        addTextField("category", "Filter by Category");
        addPlaceholder();
        addButton("f_byCategory", "Filter By Category");
        addPlaceholder();
        addPlaceholder();
        addButton("f_byCategoryDate", "Filter By Date and Category");
        addButton("back", "Back");

    //    String all = transactionSystem.getAllTransactionsString();
    //    this.setText("TransactionList", all);
    } // FilterForm()

    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "back":
                goBack();
                break;

            case "f_byDate":
                try {
                    DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                    Date date1 = format.parse(getTextFromInput("startDate"));
                    Date date2 = format.parse(getTextFromInput("endDate"));
                    transactionSystem.filterController.FilterByDate(getTextFromInput("accountName"), date1, date2);
                    transactionSystem.filterController.DisplayFilteredTransactions(this, "TransactionList");
                    System.out.println("f_byDate");
                } catch (ParseException e) { }
                break;

            case "f_byCategory":
                transactionSystem.filterController.FilterByCategory(getTextFromInput("accountName"), getTextFromInput("category"));
                transactionSystem.filterController.DisplayFilteredTransactions(this, "TransactionList");
                System.out.println("f_byCategory");
                break;

            case "f_byCategoryDate":
                try {
                    DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                    Date date1 = format.parse(getTextFromInput("startDate"));
                    Date date2 = format.parse(getTextFromInput("endDate"));
                    transactionSystem.filterController.FilterByCategoryAndDate(getTextFromInput("accountName"), getTextFromInput("category"), date1, date2);
                    transactionSystem.filterController.DisplayFilteredTransactions(this, "TransactionList");
                    System.out.println("f_byCategoryDate");
                } catch (ParseException e) { }
                break;
        } // switch

    } // actionPerformed()

} // FilterForm
