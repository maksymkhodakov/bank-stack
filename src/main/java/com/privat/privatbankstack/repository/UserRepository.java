package com.privat.privatbankstack.repository;

import com.privat.privatbankstack.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
