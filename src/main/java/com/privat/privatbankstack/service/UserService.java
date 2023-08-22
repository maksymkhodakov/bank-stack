package com.privat.privatbankstack.service;

import com.privat.privatbankstack.domain.dto.UserDto;
import com.privat.privatbankstack.domain.entities.User;

public interface UserService {
    User getById(String id);
    User saveUser(UserDto user);
    void processUser(UserDto user);
    void deleteById(String id);
}
