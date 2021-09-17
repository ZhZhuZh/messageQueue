package com.example.demomq.repository;

import com.example.demomq.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {

    Message findMessageById(Integer id);

    List<Message> getMessagesByQueueName(String qName);

    List<Message> getMessagesBySendingTimeBetween(Date fromTime, Date toTime);

}
