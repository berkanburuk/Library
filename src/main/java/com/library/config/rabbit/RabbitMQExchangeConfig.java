package com.library.config.rabbit;

import lombok.NoArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class RabbitMQExchangeConfig {

    @Bean
    public Exchange directDeadLineExceeded(){
        return ExchangeBuilder
                .directExchange(RabbitMQEnum.DIRECT_DEADLINE_EXCEEDED.getValue())
//                .durable(true)
//                .internal()
//                .autoDelete()
                .build();
    }



}
