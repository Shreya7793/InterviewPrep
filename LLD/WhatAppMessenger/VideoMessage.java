package LLD.WhatAppMessenger;

import java.time.LocalDateTime;
import java.util.List;

public class VideoMessage extends Message{
    public VideoMessage(String messageId, List<User> receivers, User sender, String content, LocalDateTime timestamp) {
        super(messageId, receivers, sender, content, timestamp);
    }
}
