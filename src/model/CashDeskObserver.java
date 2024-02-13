package model;

import java.util.ArrayList;
import java.util.List;

public interface CashDeskObserver {

	void updateCashTable(Integer nbOfCashedTables, Double beersPrice, Double tartesFlambeesPrice);
	void updateNewProduct(Product product);
    void updateClearProducts();
	void updateReset();

	void updateListTable(List<Table> allTables);

	/**
	 * Regarde la table active dans le model et remet a jour les infos de la vue
	 */
	void updateCurrentTable(Table table);

}
