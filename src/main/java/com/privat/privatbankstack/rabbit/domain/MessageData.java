package com.privat.privatbankstack.rabbit.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageData {
    private String payload;
    private String exchange;
    private String routingKey;
}
