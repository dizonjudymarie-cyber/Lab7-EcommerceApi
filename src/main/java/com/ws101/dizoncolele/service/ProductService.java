package com.ws101.dizoncolele.service;

import com.ws101.dizoncolele.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();
    private Long nextId = 1L;

    // Initialize with sample data
    public ProductService() {
        productList.add(new Product(nextId++, "Elegant Summer Dress", "Beautiful summer dress", 599.0, "Clothing", 10, "/frontend/assets/images/logo/dress.jpg"));
        productList.add(new Product(nextId++, "Running Shoes", "Comfortable running shoes", 899.0, "Shoes", 15, "/frontend/assets/images/logo/runnings.jpg"));
        // Add more products here...
    }

    // Get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // Create new product
    public Product createProduct(Product product) {
        product.setId(nextId++);
        productList.add(product);
        return product;
    }

    // Update product
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return getProductById(id).map(existing -> {
            existing.setName(updatedProduct.getName());
            existing.setDescription(updatedProduct.getDescription());
            existing.setPrice(updatedProduct.getPrice());
            existing.setCategory(updatedProduct.getCategory());
            existing.setStockQuantity(updatedProduct.getStockQuantity());
            existing.setImageUrl(updatedProduct.getImageUrl());
            return existing;
        });
    }

    // Delete product
    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    // Filter by category
    public List<Product> filterByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // Filter by price range
    public List<Product> filterByPrice(double min, double max) {
        return productList.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .toList();
    }
}