package com.privat.privatbankstack.rabbit.service.impl;

import com.privat.privatbankstack.rabbit.domain.MessageData;
import com.privat.privatbankstack.rabbit.service.RabbitMQProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageData messageData) {
        rabbitTemplate.convertAndSend(messageData.getExchange(), messageData.getRoutingKey(), messageData.getPayload());
    }
}
