package com.blueyonder.shopppingservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blueyonder.shopppingservice.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, Integer>{
    Category findCategoryByName(String categoryName);
}
