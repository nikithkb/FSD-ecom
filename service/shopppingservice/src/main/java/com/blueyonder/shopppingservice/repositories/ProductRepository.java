package com.blueyonder.shopppingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blueyonder.shopppingservice.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    List<Product> findByCategoriesCategoryId(Integer categoryId);
    List<Product> findByCategoriesCategoryName(String categoryName);
    Product findByName(String name);
}
