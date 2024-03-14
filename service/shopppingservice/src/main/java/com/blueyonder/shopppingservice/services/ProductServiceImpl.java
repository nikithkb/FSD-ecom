package com.blueyonder.shopppingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.entities.Product;
import com.blueyonder.shopppingservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopppingservice.exceptions.ProductNotFoundException;
import com.blueyonder.shopppingservice.repositories.CategoryRepository;
import com.blueyonder.shopppingservice.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    public void linkCategory(Integer productId, Category category) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.getCategories().add(category);
            productRepository.save(product);
        } else {
            // Handle product not found error
            try {
                throw new ProductNotFoundException("Product not found with id: " + productId);
            } catch (ProductNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Integer categoryId) {
        return productRepository.findByCategoriesCategoryId(categoryId);
    }

    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    public Product getProductById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        try {
            return optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
        } catch (ProductNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void addCategory(Integer categoryId, String categoryName, String categoryDescription) {
        Category category = new Category(categoryId, categoryName, categoryDescription, null);
        categoryRepository.save(category);
    }
    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public void updateCategory(Integer categoryId, String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(categoryName);
            categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException("Category not found with id: " + categoryId);
        }
    }

    public void deleteCategoryByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category != null) {
            categoryRepository.delete(category);
        } else {
            throw new CategoryNotFoundException("Category not found with name: " + categoryName);
        }
    }

    public void updateCategoryByName(String categoryName, Integer newCategoryId, String newCategoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category != null) {
            category.setCategoryId(newCategoryId);
            category.setCategoryName(newCategoryName);
            categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException("Category not found with name: " + categoryName);
        }
    }
}

