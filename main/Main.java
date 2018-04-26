package main;

import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.budgetsubsys.BudgetController;

public class Main {
    public static void main(String[] args) {
        // Program startup check
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new Window();
                    }
                });

}
