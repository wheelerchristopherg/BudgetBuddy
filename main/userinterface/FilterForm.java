package main.userinterface;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import main.transactionsubsys.TransactionSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import main.repositorysys.Repository;

public class FilterForm extends Form {

    public FilterForm(Window parent) {
        super(parent);

        setGridLayout(6, 3);
        addLabel("Filter Transactions");

//        addTextField("accountName", "Enter Account Name");
        addTextField("accountName", "life_savings");

        addTextArea("TransactionList",100,1,false);


        addTextField("startDate", "01-01-1800");
        addTextField("endDate", "04-27-2018");
//        addTextField("startDate", "Start Date (mm-dd-yyyy)");
//        addTextField("endDate", "End Date (mm-dd-yyyy)");


        addButton("f_byDate", "Filter By Date");

        addTextField("category", "Bill");
//       addTextField("category", "Filter by Category");

        addPlaceholder();
        addButton("f_byCategory", "Filter By Category");
        addPlaceholder();
        addPlaceholder();
        addButton("f_byCategoryDate", "Filter By Date and Category");
        addButton("back", "Back");

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
                    TransactionSystem.getFilterController().FilterByDate(getTextFromInput("accountName"), date1, date2);
                    //TransactionSystem.getFilterController().DisplayFilteredTransactions(this, "TransactionList");
                } catch (ParseException e) {
                    System.out.println("Incorrect date format");
                 }
                break;

            case "f_byCategory":
                System.out.println(getTextFromInput("accountName"));
                System.out.println(getTextFromInput("category"));

                System.out.println(TransactionSystem.getFilterController());
                TransactionSystem.getFilterController().FilterByCategory(getTextFromInput("accountName"), getTextFromInput("category"));
                TransactionSystem.getFilterController().DisplayFilteredTransactions(this, "TransactionList");
                System.out.println("f_byCategory");
                break;

            case "f_byCategoryDate":
                try {
                    DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                    Date date1 = format.parse(getTextFromInput("startDate"));
                    Date date2 = format.parse(getTextFromInput("endDate"));
                    TransactionSystem.getFilterController().FilterByCategoryAndDate(getTextFromInput("accountName"), getTextFromInput("category"), date1, date2);
                    TransactionSystem.getFilterController().DisplayFilteredTransactions(this, "TransactionList");
                    System.out.println("f_byCategoryDate");
                } catch (ParseException e) {
                    System.out.println("Incorrect date format");
                }
                break;
        } // switch

    } // actionPerformed()

} // FilterForm
