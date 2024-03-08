package LLD.WhatAppMessenger;

import java.time.LocalDateTime;
import java.util.List;

public class MessageFactory {
    // Factory method to create instances of different message types based on input
    public static Message createMessage(MessageType type, String messageId, List<User> receivers, User sender, String content, LocalDateTime timestamp){
        switch(type){
            case TEXT -> {
                return new TextMessage(messageId,receivers,sender,content,timestamp);
            }
            case VIDEO -> {
                return new VideoMessage(messageId,receivers,sender,content,timestamp);
            }
            case IMAGE -> {
                return new ImageMessage(messageId,receivers,sender,content,timestamp);
            }
            default -> throw new IllegalArgumentException("Invalid Message type");
        }
    }
}
