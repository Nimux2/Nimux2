package controller;

import model.CashDesk;
import model.ProductFactory;

public class AuBrasseurController {

	private CashDesk _cashDesk;

	private ProductFactory _productFactory;

	public AuBrasseurController( CashDesk cashDesk ) {
		_cashDesk = cashDesk;
		_productFactory = new ProductFactory();
	}

	public void cashTable() {
		_cashDesk.cashTable();
	}

	public void addAlcoholFreeBeer() {
		_cashDesk.addProduct( _productFactory.createAlcoholFreeBeer() );
	}

	public void addIndianPaleAle() {
		_cashDesk.addProduct( _productFactory.createIndianPaleAle() );
	}

	public void addTarteFlambeeTraditional() {
		_cashDesk.addProduct( _productFactory.createTarteFlambeeTraditional() );
	}

	public void addTarteFlambeeMunster() {
		_cashDesk.addProduct( _productFactory.createTarteFlambeeMunster() );
	}

	public void addTarteFlambeeHawaiian() {
		_cashDesk.addProduct( _productFactory.createTarteFlambeeHawaiian() );
	}

    public void clearProducts() {
		_cashDesk.clearProducts();
    }

	public void resetCashDeskAndTables() {
		_cashDesk.resetCashDeskAndTables();
	}
}
