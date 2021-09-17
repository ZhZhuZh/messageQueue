package com.example.demomq.service;

import com.example.demomq.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    RabbitMQSender(AmqpTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;

    }

    @Value("${mq.rabbitmq.exchange}")
    private String exchange;

    public void send(Message message) {

        rabbitTemplate.convertAndSend(exchange, message.getQueueName(), message);

    }
}
