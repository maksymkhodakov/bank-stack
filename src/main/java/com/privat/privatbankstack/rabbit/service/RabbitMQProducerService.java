package com.privat.privatbankstack.rabbit.service;

import com.privat.privatbankstack.rabbit.domain.MessageData;

public interface RabbitMQProducerService {
    void sendMessage(MessageData messageData);
}
