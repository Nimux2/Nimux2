import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import controller.AuBrasseurController;
import model.CashDesk;
import view.AuBrasseurTab;
import view.MainWindow;

public class App {

    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        UIManager.put("TabbedPane.tabAreaAlignment", "fill");

		CashDesk model = new CashDesk();
		AuBrasseurController controller = new AuBrasseurController(model);
		AuBrasseurTab view = new AuBrasseurTab(model,controller);
		model.addObserver(view);

        new MainWindow(view);
    }
}
