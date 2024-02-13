package model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private static Integer _count = 0;

	private final Integer _id;
	private Boolean _cashed;

	private List<Product> _products;

	public Table() {
		_id = ++_count;
		_cashed = false;
		_products = new ArrayList<>();
	}

	public List<Product> get_products() {
		return _products;
	}

	public Integer getId() {
		return _id;
	}

	public void cashTable(){
		_cashed = true;
	}
	
	public Boolean getCashed() {
		return _cashed;
	}

	public void addProduct(Product product) {
		_products.add(product);
	}

	public Double getBeerPrice() {
		Double price = 0.;
		for (Product product : _products) {
			if (product instanceof Beer)
				price += product.getPrice();
		}
		return price;
	}

	public Double getTarteFlambeePrice() {
		Double price = 0.;
		for (Product product : _products) {
			if (product instanceof TarteFlambee)
				price += product.getPrice();
		}
		return price;
	}

	public void clearProducts() {
		_products.clear();
	}
}
