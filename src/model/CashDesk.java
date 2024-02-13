package model;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {

	private Double _priceOfSoldBeers;
	private Double _priceOfSoldTartesFlambees;

	private Table _activeTable;
	private List<Table> _cashedTables;
	private List<CashDeskObserver> _observers;
	private SortStrategy _strategy;

	public CashDesk() {
		_priceOfSoldBeers = 0.;
		_priceOfSoldTartesFlambees = 0.;
		_activeTable = new Table();
		_cashedTables = new ArrayList<>();
		_observers = new ArrayList<>();
		setStrategy(new NameStrategy());
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
		_activeTable = new Table();
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

	public void setStrategy(SortStrategy strategy) {
		_strategy = strategy;
		sortProducts();
		notifyStrategy(_strategy);
	}

	public void notifyStrategy(SortStrategy strategy) {
		for (CashDeskObserver observer: _observers) {
			observer.updateStrategy(strategy);
		}
	}

	public void sortProducts() {
		if (_strategy != null) {
			_activeTable.get_products().sort(_strategy::compare);
		}
	}

	public Table get_activeTable() {
		return _activeTable;
	}

	public SortStrategy get_strategy() {
		return _strategy;
	}
}
