package com.blueyonder.shopppingservice.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "categoriesData")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    private Integer categoryId;
    private String categoryName;
    @Nullable
    private String categoryDescription;
    @Nullable
    private List<Product> products;
}
