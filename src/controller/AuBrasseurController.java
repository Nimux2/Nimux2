package controller;

import model.CashDesk;
import model.ProductFactory;
import model.Table;

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
	public void setActiveTable(Integer idTable)
	{
		Table tbl = null;
		for(int i = 0; i < this._cashDesk.getAllTables().size() ; i++ )
		{
			if(this._cashDesk.getAllTables().get(i).getId() == idTable)
			{
				tbl = this._cashDesk.getAllTables().get(i);
			}
		}

		if (tbl != null) this._cashDesk.setCurrentTable(tbl);
	}

	/**
	 * Demande la création et l'ajout d'une nouvelle table dans le model
	 */
	public void addTable(){
		this._cashDesk.addTable();
	}

	/**
	 * Supprimer sans encaisser la table courante
	 */
	public void removeTable(){
		this._cashDesk.deleteTable();
	}
}
