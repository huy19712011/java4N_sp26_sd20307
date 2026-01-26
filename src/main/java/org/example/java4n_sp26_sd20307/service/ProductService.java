package org.example.java4n_sp26_sd20307.service;

import org.example.java4n_sp26_sd20307.entity.Product;
import org.example.java4n_sp26_sd20307.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {

        return productRepository.getProducts();
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }

    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {

        productRepository.updateProduct(product);
    }
}
