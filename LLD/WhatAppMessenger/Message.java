package LLD.WhatAppMessenger;

import java.time.LocalDateTime;
import java.util.List;

public class Message {

    String messageId;
    List<User> receivers;
    User sender;
    String content;
    LocalDateTime timestamp;
    boolean isRead;
    boolean isDelivered;

    public Message(String messageId, List<User> receivers, User sender, String content, LocalDateTime timestamp) {
        this.messageId = messageId;
        this.receivers = receivers;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.isRead = false;
        this.isDelivered = false;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
