package model;

public class ProductFactory {

	public Product createIndianPaleAle() {
		return new Beer("Indian Pale Ale", 6.);
	}

	public Product createAlcoholFreeBeer() {
		return new Beer("Bière sans alccol", 4.5);
	}

	public Product createTarteFlambeeTraditional() {
		return new TarteFlambee("Tarte flambée traditionnelle", 5.);
	}

	public Product createTarteFlambeeMunster() {
		return new TarteFlambee("Tarte flambée au munster", 6.);
	}

	public Product createTarteFlambeeHawaiian() {
		return new TarteFlambee("Tarte flambée hawaïenne", 6.5);
	}
}
