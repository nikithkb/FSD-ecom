package com.blueyonder.loginservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blueyonder.loginservice.entities.User;


@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

    User findByUsername(String username);

}
