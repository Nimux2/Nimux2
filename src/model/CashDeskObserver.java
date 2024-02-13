package model;

public interface CashDeskObserver {

	void updateCashTable(Integer nbOfCashedTables, Double beersPrice, Double tartesFlambeesPrice);
	void updateNewProduct(Product product);
    void updateClearProducts();
	void updateReset();
	void updateStrategy(SortStrategy strategy);
}
