package com.example.demomq.service;

import com.example.demomq.model.Message;
import com.example.demomq.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    MessageService (MessageRepository messageRepository) {

        this.messageRepository = messageRepository;

    }

    public Message findMessageById(Integer id) {

        return messageRepository.findMessageById(id);

    }

    public void addMessage(Message message) {

        messageRepository.save(message);

    }

    public List<Message> findByQName(String qName) {

        return messageRepository.getMessagesByQueueName(qName);

    }

    public List<Message> findMessagesBySendingTimeBetween(Date fromTime, Date toTime) {

        return messageRepository.getMessagesBySendingTimeBetween(fromTime, toTime);

    }
}
