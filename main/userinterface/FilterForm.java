package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

public class FilterForm extends Form {

    public FilterForm(Window parent) {
        super(parent);

        setGridLayout(6, 3);

        // filter transactionsubsys pl txt
        // pl pl pl
        // fliter by date  pl pl
        // d1 d2 filter btn
        // filter by category pl pl
        // category btn
        // back


        addLabel("Filter Transactions");
        addPlaceholder();
        addTextArea("TransactionList",100,1,false);
        addTextField("billpay_name", "Start Date (mm-dd-yyyy)");
        addTextField("billpay_amount", "End Date (mm-dd-yyyy)");
        addButton("submit", "Filter By Date");
        addTextField("billpay_name", "Filter by Category");
        addPlaceholder();
        addButton("submit", "Filter By Category");
        addPlaceholder();
        addPlaceholder();
        addPlaceholder();

        addButton("back", "Back");

    }

    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "back":
                goBack();
                break;
        }
    }
}
