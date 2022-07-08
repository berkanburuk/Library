package com.library.config.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQBindConfig {

    private RabbitMQQueueConfig rabbitQueue;
    private RabbitMQExchangeConfig rabbitExchange;

    @Autowired
    public RabbitMQBindConfig(RabbitMQQueueConfig rabbitQueue, RabbitMQExchangeConfig rabbitExchange) {
        this.rabbitQueue = rabbitQueue;
        this.rabbitExchange = rabbitExchange;
    }

    @Bean
    Binding deadlineExceededBind() {
        return BindingBuilder.
                bind(rabbitQueue.queueDeadlineExceeded())
                .to(rabbitExchange.directDeadLineExceeded())
                .with(RabbitMQEnum.ROUTING_KEY_DEADLINE_EXCEEDED.getValue())
                .noargs();
    }


}
