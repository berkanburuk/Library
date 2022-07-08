package com.library.config.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {
    @Autowired
    private RabbitMQQueueConfig rabbitQueue;
    RabbitMQEnum rabbitMQEnum;

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory
                (rabbitMQEnum.RABBIT_MQ_HOSTNAME.getValue(), Integer.parseInt(RabbitMQEnum.RABBIT_MQ_PORT.getValue()));
        connectionFactory.setUsername(rabbitMQEnum.RABBIT_MQ_USERNAME.getValue());
        connectionFactory.setPassword(rabbitMQEnum.RABBIT_MQ_PASSWORD.getValue());
        return connectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(rabbitQueue.queueDeadlineExceeded());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQListener());
        return simpleMessageListenerContainer;
    }


}
