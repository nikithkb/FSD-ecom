package com.blueyonder.shopppingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.entities.Product;

@Service
public interface ProductService {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Integer productId);
    public void linkCategory(Integer productId, Category category);
    public List<Product> getAllProducts();
    public List<Product> getProductsByCategory(Integer categoryId);
    public Product getProductByName(String productName);
    public Product getProductById(Integer productId);
    }
    
