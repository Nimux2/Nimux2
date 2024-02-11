package view;

import javax.swing.*;

public class MainWindow extends JFrame {
    
    public MainWindow(AuBrasseurTab auBrasseurTab){
		super("Au Brasseur");
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );

        JTabbedPane onglets = new JTabbedPane();
		onglets.add(AuBrasseurTab.TAB_NAME, auBrasseurTab);

        add(onglets);
		setSize(642, 469);
		setVisible(true);
    }

}