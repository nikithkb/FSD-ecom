package com.blueyonder.loginservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "userData")
public class User {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String password;
    private boolean isAdmin;
}
