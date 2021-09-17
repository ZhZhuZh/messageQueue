package com.example.demomq.controller;

import com.example.demomq.model.Message;
import com.example.demomq.service.MessageService;
import com.example.demomq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQWebController {

    RabbitMQSender rabbitMQSender;
    MessageService messageService;

    @Autowired
    RabbitMQWebController(RabbitMQSender rabbitMQSender, MessageService messageService) {

        this.rabbitMQSender = rabbitMQSender;
        this.messageService = messageService;

    }

    @PostMapping(value = "/producer")
    public void producer(@RequestBody List<Message> messages) {

        for (Message message: messages) {
            rabbitMQSender.send(message);
        }

        new Thread(() -> {
            for (Message message: messages) {
                message.setSendingTime();
                messageService.addMessage(message);
            }
        }).start();

    }

}
