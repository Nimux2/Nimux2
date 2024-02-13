package model;

public interface SortStrategy {
    int compare(Product product1, Product product2);
    String getName();
}
