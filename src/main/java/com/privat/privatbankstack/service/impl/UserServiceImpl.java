package com.privat.privatbankstack.service.impl;

import com.privat.privatbankstack.domain.dto.UserDto;
import com.privat.privatbankstack.domain.entities.User;
import com.privat.privatbankstack.rabbit.domain.MessageData;
import com.privat.privatbankstack.rabbit.service.RabbitMQProducerService;
import com.privat.privatbankstack.repository.UserRepository;
import com.privat.privatbankstack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routing-key}")
    private String routingKey;

    private final UserRepository userRepository;
    private final RabbitMQProducerService producerService;

    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(UserDto user) {
        return userRepository.save(new User(user));
    }

    @Override
    public void processUser(UserDto user) {
        final User payload = saveUser(user);
        final MessageData messageData = MessageData.builder()
                .payload(payload.toString())
                .exchange(exchange)
                .routingKey(routingKey)
                .build();
        producerService.sendMessage(messageData);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
