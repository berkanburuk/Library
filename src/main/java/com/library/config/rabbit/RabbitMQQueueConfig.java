package com.library.config.rabbit;

import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class RabbitMQQueueConfig {

    @Bean
    public Queue queueDeadlineExceeded() {
        return QueueBuilder.durable(RabbitMQEnum.QUEUE_DEADLINE_EXCEEDED.getValue())
                .autoDelete()
                .exclusive()
                .build();
    }

}
