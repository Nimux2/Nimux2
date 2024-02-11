package model;

public abstract class Product {

	private String _name;
	private Double _price;

	public Product(String name, Double price) {
		this._name = name;
		this._price = price;
	}

	public Double getPrice() {
		return this._price;
	}

	public String getName() {
		return this._name;
	}
}
