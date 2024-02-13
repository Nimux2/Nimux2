package model;

public class NameStrategy implements SortStrategy {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getName().compareToIgnoreCase(product2.getName());
    }

    @Override
    public String getName() {
        return "Trier par nom";
    }
}
