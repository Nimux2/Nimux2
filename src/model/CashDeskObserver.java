package model;

public interface CashDeskObserver {

	void updateCashTable(Integer nbOfCashedTables, Double beersPrice, Double tartesFlambeesPrice);
	void updateNewProduct(Product product);
    void updateClearProducts();
	void updateReset();

	void updateListTable();

	/**
	 * Regarde la table active dans le model et remet a jour les infos de la vue
	 */
	void updateCurrentTable();

}
