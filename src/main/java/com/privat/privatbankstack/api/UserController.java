package com.privat.privatbankstack.api;

import com.privat.privatbankstack.domain.dto.UserDto;
import com.privat.privatbankstack.domain.entities.User;
import com.privat.privatbankstack.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    @CachePut(value = "user", key = "#user.serialNumber")
    public User addNew(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }

    @PostMapping("/process")
    @CachePut(value = "user", key = "#user.serialNumber")
    public void process(@RequestBody UserDto user) {
        userService.processUser(user);
    }

    @GetMapping("/get-by-id")
    @Cacheable(value = "user", key = "#id")
    public User getById(@RequestParam String id){
        return userService.getById(id);
    }

    @PutMapping("/update")
    @CachePut(value = "user", key = "#user.serialNumber")
    public User updateUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete")
    @CacheEvict(value = "user", key = "#id")
    public String deleteById(@RequestParam String id) {
        userService.deleteById(id);
        log.info("user with id: {} successfully deleted", id);
        return id;
    }
}
