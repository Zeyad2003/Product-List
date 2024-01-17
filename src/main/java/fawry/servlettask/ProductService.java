package fawry.servlettask;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepo;

    public ProductService() {
        this.productRepo = new ProductRepository();
    }

    public void addProduct(Product product) {
        if(product.getPrice() < 0) throw new NumberFormatException("Invalid price");
        productRepo.addProduct(product);
    }

    public List<Product> listProducts() {
        return productRepo.findProducts();
    }

    public void removeProduct(int id) {
        productRepo.deleteProduct(id);
    }
}
