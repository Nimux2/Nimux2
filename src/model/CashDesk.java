package model;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {

	private Double _priceOfSoldBeers;
	private Double _priceOfSoldTartesFlambees;
	private Table _activeTable;
	private List<Table> _cashedTables;
	private List<CashDeskObserver> _observers;
	private List<Table> _allTables;

	public CashDesk() {
		_priceOfSoldBeers = 0.;
		_priceOfSoldTartesFlambees = 0.;
		_activeTable = new Table();
		_cashedTables = new ArrayList<>();
		_observers = new ArrayList<>();
		_allTables = new ArrayList<>();
	}

	public void cashTable() {
		// Marquer la table pour encaissement
		_activeTable.cashTable();
		// Mettre à jour la caisse avec la table à encaisser
		_priceOfSoldBeers += _activeTable.getBeerPrice();
		_priceOfSoldTartesFlambees += _activeTable.getTarteFlambeePrice();
		// Ajouter la table active à la liste des tables encaissées
		_cashedTables.add(_activeTable);
		// Créer une nouvelle table active
		// Notifier les opbserveurs
		notifyCashTable(_cashedTables.size(), _priceOfSoldBeers, _priceOfSoldTartesFlambees);
	}

	public void addProduct(Product product) {
		_activeTable.addProduct(product);
		notifyNewProduct(product);
	}

	public void clearProducts() {
		_activeTable.clearProducts();
		notifyClearProducts();
	}

	public void resetCashDeskAndTables() {
		_priceOfSoldBeers = 0.;
		_priceOfSoldTartesFlambees = 0.;
		_activeTable = new Table();
		_cashedTables.clear();
		notifyReset();
	}

	public void addObserver(CashDeskObserver observer) {
		_observers.add(observer);
	}

	private void notifyCashTable(Integer nbOfCashedTables, Double priceOfSoldBeers, Double priceOfSoldTartesFlambees) {
		for (CashDeskObserver observer : _observers) {
			observer.updateCashTable(nbOfCashedTables, priceOfSoldBeers, priceOfSoldTartesFlambees);
		}
	}

	private void notifyNewProduct(Product product) {
		for (CashDeskObserver observer : _observers) {
			observer.updateNewProduct(product);
		}
	}

	private void notifyClearProducts() {
		for (CashDeskObserver observer : _observers) {
			observer.updateClearProducts();
		}
	}

	private void notifyReset() {
		for (CashDeskObserver observer : _observers) {
			observer.updateReset();
		}
	}

	public void setCurrentTable(Table table) {
		this._activeTable = table;
		notifyChangeTable();
	}

	public void deleteTable()
	{
		if(this._activeTable != null)
		{
			this._allTables.remove(_activeTable);
		}
		notifyModifyListTable();
	}

	public List<Table> getAllTables() {
		return this._allTables;
	}

	public void addTable() {
		this._allTables.add(new Table());
		notifyModifyListTable();
	}

	private void notifyModifyListTable() {
		for (CashDeskObserver observer : _observers) {
			observer.updateListTable(this._allTables);
		}
	}

	private void notifyChangeTable(){
		for (CashDeskObserver observer : _observers) {
			observer.updateCurrentTable(this._activeTable);
		}
	}
}
