package com.blueyonder.shopppingservice.entities;

// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productsData")
public class Product {
    @Id
    private Integer id;
    @NonNull
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    @DBRef
    private List<Category> categories;
}
