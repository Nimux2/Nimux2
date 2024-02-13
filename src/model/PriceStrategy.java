package model;

public class PriceStrategy implements SortStrategy {

    @Override
    public int compare(Product product1, Product product2) {
        return Double.compare(product1.getPrice(), product2.getPrice());
    }

    @Override
    public String getName() {
        return "Trier par prix";
    }
}
