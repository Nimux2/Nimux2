package view;

import controller.AuBrasseurController;
import model.CashDesk;
import model.CashDeskObserver;
import model.Product;

import javax.swing.*;
import java.awt.*;

public class AuBrasseurTab extends JPanel implements CashDeskObserver {

	public static final String TAB_NAME = "My Active Tables";

	private JPanel _panelCurrentTableProducts;
	private JLabel _labelNbPayedTables;
	private JLabel _labelNbActiveTables;
	private JLabel _labelAmountTotalBeerPrice;
	private JLabel _labelAmountTotalTartesFlambeesPrice;
	private JComboBox<Integer> _listIdOfActiveTable;

	public AuBrasseurTab(CashDesk cashDesk, AuBrasseurController controller) {
		setLayout(new BorderLayout());
		
		// *****************************************************************************************
		// Panneau de la sélection de la table courante
		JPanel panelListOfActiveTable = new JPanel();
		panelListOfActiveTable.setLayout(new BoxLayout(panelListOfActiveTable, BoxLayout.X_AXIS));
		panelListOfActiveTable.add(new JLabel("Liste des tables actives :\n"));
		_listIdOfActiveTable = new JComboBox<Integer>();
		panelListOfActiveTable.add(_listIdOfActiveTable);
		// Bouton pour choisir une table active
		JButton buttonSelectTable = new JButton("Sélectionner");
		panelListOfActiveTable.add(buttonSelectTable);
		add(panelListOfActiveTable, BorderLayout.NORTH);


		// *****************************************************************************************
		// Panneau de la table courante
		JPanel panelCurrentTable = new JPanel();
		panelCurrentTable.setLayout(new BoxLayout(panelCurrentTable, BoxLayout.Y_AXIS));
		panelCurrentTable.add(new JLabel("Produits de la table courante :\n"));
		_panelCurrentTableProducts = new JPanel();
		_panelCurrentTableProducts.setLayout(new BoxLayout(_panelCurrentTableProducts, BoxLayout.Y_AXIS));
		panelCurrentTable.add(_panelCurrentTableProducts);
		add(panelCurrentTable, BorderLayout.CENTER);


		// *****************************************************************************************
		// Panneau des boutons des bières et des tartes flambées
		JPanel panelProductButtons = new JPanel(new GridLayout(0, 1));

		// Boutons des bières
		panelProductButtons.add(new JLabel("Ajouter une bière :"));
		// Bouton pour la IPA
		JButton buttonBeerIPA = new JButton("Indian Pale Ale");
		buttonBeerIPA.addActionListener(event -> controller.addIndianPaleAle());
		panelProductButtons.add(buttonBeerIPA);
		// Bouton pour la bière sans alcool
		JButton buttonBeerAlcoholFree = new JButton("Bière sans alcool");
		buttonBeerAlcoholFree.addActionListener(event -> controller.addAlcoholFreeBeer());
		panelProductButtons.add(buttonBeerAlcoholFree);

		// Panneau des tartes flambées
		panelProductButtons.add(new JLabel("Ajouter une tarte flambée :"));
		// Bouton pour la tarte flambée traditionnelle
		JButton buttonTarteFlambeeTraditional = new JButton("Traditionnelle");
		buttonTarteFlambeeTraditional.addActionListener(event -> controller.addTarteFlambeeTraditional());
		panelProductButtons.add(buttonTarteFlambeeTraditional);
		// Bouton pour la tarte flambée munster
		JButton buttonTarteFlambeeMunster = new JButton("Munster");
		buttonTarteFlambeeMunster.addActionListener(event -> controller.addTarteFlambeeMunster());
		panelProductButtons.add(buttonTarteFlambeeMunster);
		// Bouton pour la tarte flambée hawaienne
		JButton buttonTarteFlambeeHawaiian = new JButton("Hawaïenne");
		buttonTarteFlambeeHawaiian.addActionListener(event -> controller.addTarteFlambeeHawaiian());
		panelProductButtons.add(buttonTarteFlambeeHawaiian);
		
		// Ajout du panneau
		add(panelProductButtons, BorderLayout.WEST);


		// *****************************************************************************************
		// Panneau d'actions sur les tables
		JPanel panelTableButtons = new JPanel(new GridLayout(0, 1));
		panelTableButtons.add(new JLabel("Gérer les tables :"));
		// Bouton pour ajouter une nouvelle table active
		JButton buttonAddTable = new JButton("Ajouter une table");
		panelTableButtons.add(buttonAddTable);
		// Bouton pour supprimer une table active
		JButton buttonDeleteTable = new JButton("Supprimer une table");
		panelTableButtons.add(buttonDeleteTable);
		// Bouton d'encaissement
		panelTableButtons.add(new JLabel("Encaissement :"));
		JButton buttonCashTable = new JButton("Encaisser la table");
		buttonCashTable.addActionListener(event -> controller.cashTable());
		panelTableButtons.add(buttonCashTable);
		// Bouton pour retirer les produits d'une table
		JButton buttonClearProductsOfTable = new JButton("Retirer les produits");
		buttonClearProductsOfTable.addActionListener(event -> controller.clearProducts());
		panelTableButtons.add(buttonClearProductsOfTable);
		// Bouton pour reset l'application
		panelTableButtons.add(new JLabel("Remise à zéro :"));
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(event -> controller.resetCashDeskAndTables());
		panelTableButtons.add(buttonReset);
		add(panelTableButtons, BorderLayout.EAST);


		// *****************************************************************************************
		// Panneau des tables
		JPanel panelTables = new JPanel();
		panelTables.setLayout(new BoxLayout(panelTables, BoxLayout.X_AXIS));
		panelTables.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Nombre de tables encaissées
		panelTables.add(new JLabel("Nombre de tables encaissées : "));
		_labelNbPayedTables = new JLabel("0");
		panelTables.add(_labelNbPayedTables);
		panelTables.add(new JLabel("    "));
		// Nombre de tables actives
		panelTables.add(new JLabel("Nombre de tables actives : "));
		_labelNbActiveTables = new JLabel("0");
		panelTables.add(_labelNbActiveTables);
		

		// *****************************************************************************************
		// Panneau des prix
		JPanel panelPrices = new JPanel();
		panelPrices.setLayout(new BoxLayout(panelPrices, BoxLayout.X_AXIS));
		panelPrices.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Prix des bières
		panelPrices.add(new JLabel("Prix total des bières : "));
		_labelAmountTotalBeerPrice = new JLabel("0 €");
		panelPrices.add(_labelAmountTotalBeerPrice);
		panelPrices.add(new JLabel("    "));
		// Prix des tartes flambées
		panelPrices.add(new JLabel("Prix total des tartes flambées : "));
		_labelAmountTotalTartesFlambeesPrice = new JLabel("0 €");
		panelPrices.add(_labelAmountTotalTartesFlambeesPrice);
		

		// *****************************************************************************************
		// Ajout du panneau des prix et des tables
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.add(panelTables);
		infoPanel.add(panelPrices);
		add(infoPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void updateCashTable(Integer nbOfCashedTables, Double beersPrice, Double tartesFlambeesPrice) {
		_panelCurrentTableProducts.removeAll();
		_labelNbPayedTables.setText(nbOfCashedTables.toString());
		_labelAmountTotalBeerPrice.setText(""+ beersPrice.toString() +" €");
		_labelAmountTotalTartesFlambeesPrice.setText(""+ tartesFlambeesPrice.toString() +" €");
		_panelCurrentTableProducts.revalidate();
	}

	@Override
	public void updateNewProduct(Product product) {
		_panelCurrentTableProducts.add(new JLabel(product.getName()));
		_panelCurrentTableProducts.revalidate();
	}

	@Override
	public void updateClearProducts() {
		_panelCurrentTableProducts.removeAll();
		_panelCurrentTableProducts.revalidate();
	}

	@Override
	public void updateReset() {
		_panelCurrentTableProducts.removeAll();
		_labelNbPayedTables.setText("0");
		_labelAmountTotalBeerPrice.setText("0 €");
		_labelAmountTotalTartesFlambeesPrice.setText("0 €");
		_panelCurrentTableProducts.revalidate();
	}

}
