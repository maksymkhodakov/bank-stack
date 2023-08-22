package com.privat.privatbankstack.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableRabbit
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbit.queue}")
    public void processMyQueue(String message) {
        log.info("Received from myQueue : {}", new String(message.getBytes()));
    }

}
