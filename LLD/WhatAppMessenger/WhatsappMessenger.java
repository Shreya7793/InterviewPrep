package LLD.WhatAppMessenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WhatsappMessenger {
    public static void main(String []args){
        // textMessage = MessageFactory.createMessage(MessageFactory.MessageType.TEXT, messageId, receivers, sender, content, timestamp, isRead, isDelivered);
        // Create users
        User user1 = new User("user1", "john.doe", "12345","password1");
        User user2 = new User("user2", "alice.smith", "12347","password2");

        List<User> chatParticipantList=new ArrayList<>();
        chatParticipantList.add(user1);
        chatParticipantList.add(user2);

        // Create message objects use factory method
        Message message1 = MessageFactory.createMessage(MessageType.TEXT,"msg1",List.of(user1),user2, "Hi Alice, how are you?", LocalDateTime.now());
     //   Message message2 = MessageFactory.createMessage(MessageType.TEXT,"msg2",List.of(user1),user2, "Hi John, I'm doing well.", LocalDateTime.now());

        //Create single instance
        ChatRoom chatRoom=ChatRoom.getInstance(List.of(user1));
        MessageManager messageManager=MessageManager.getInstance();

        chatRoom.register(chatParticipantList);
        messageManager.sendMessage(message1);
        chatRoom.notify(user1,message1);

    }
}
