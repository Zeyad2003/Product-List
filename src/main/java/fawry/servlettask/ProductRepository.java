package fawry.servlettask;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private int sequence = 1;

    List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(sequence++, "Product A", 100));
        products.add(new Product(sequence++, "Product B", 150));
        products.add(new Product(sequence++, "Product C", 170));
        products.add(new Product(sequence++, "Product D", 80));
        products.add(new Product(sequence++, "Product E", 120));
        products.add(new Product(sequence++, "Product F", 50));
        products.add(new Product(sequence++, "Product G", 150));
        products.add(new Product(sequence++, "Product H", 150.5));
    }

    public List<Product> findProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
