import userinterface.Window;
import main.repositorysys.BillPayReminder;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    new Window();
                }
            });
    }
}
