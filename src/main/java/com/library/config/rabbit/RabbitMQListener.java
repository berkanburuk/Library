package com.library.config.rabbit;

import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@NoArgsConstructor
public class RabbitMQListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Received a new message = [" + new String(message.getBody() + message.getMessageProperties().toString()) + "]");
    }
}
