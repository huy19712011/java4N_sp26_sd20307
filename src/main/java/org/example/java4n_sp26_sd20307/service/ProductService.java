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
}
