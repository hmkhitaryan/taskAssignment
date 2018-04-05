package com.egs.model;

import com.egs.enums.Type;

import javax.persistence.*;

/**
 * @author Hayk_Mkhitaryan
 */
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private User sender;

    private User receiver;

    private String comment;

    private Type type;

    public Notification(User sender, User receiver, String comment, Type type) {
        this.sender = sender;
        this.receiver = receiver;
        this.comment = comment;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
