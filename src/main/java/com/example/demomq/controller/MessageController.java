package com.example.demomq.controller;

import com.example.demomq.model.Message;
import com.example.demomq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    MessageService messageService;

    @Autowired
    MessageController(MessageService messageService) {

        this.messageService = messageService;

    }


    @GetMapping("/get/{id}")
    public Message getMessageById(@PathVariable("id") Integer id) {

        System.out.println(id);
        return messageService.findMessageById(id);

    }

    @GetMapping("/get")
    public List<Message> getMessagesByQName(String qName) {

        return messageService.findByQName(qName);

    }

    @GetMapping("/get/time")
    public List<Message> getMessagesBySendingTimeBetween(Date fromTime, Date toTime) {

        return messageService.findMessagesBySendingTimeBetween(fromTime, toTime);

    }

}
