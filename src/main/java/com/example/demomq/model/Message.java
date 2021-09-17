package com.example.demomq.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Table(name = "message")
@Entity
@Setter
@Getter
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String queueName;

    private String body;

    private Date sendingTime;

    public void setSendingTime() {

        Calendar calendar = new GregorianCalendar();
        this.sendingTime = calendar.getTime();

    }

    public String toString() {
        return this.id + " " + this.queueName + ": " + this.body;
    }
}
