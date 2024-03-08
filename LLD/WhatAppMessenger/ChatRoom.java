package LLD.WhatAppMessenger;

import java.util.ArrayList;
import java.util.List;

/*
Singleton Instance, uses singleton and observer pattern to send notifications
 */
public class ChatRoom implements NotificationObservable{ //Chatroom implements NotificationObservable and has
    List<NotificationObserver> notificationObservers;
    List<User> participants;
    private static ChatRoom chatRoom;

    private ChatRoom(List<User> participants) {
        this.notificationObservers=new ArrayList<>();
        this.participants = participants;
    }

    // Lazy initialization with double-checked locking for thread safety
    public static ChatRoom getInstance(List<User> participants){
        if(chatRoom==null){
            synchronized (ChatRoom.class){
                if(chatRoom==null)
                    chatRoom=new ChatRoom(participants);
            }
        }
        return chatRoom;
    }

    @Override
    public void register(List<User> participants) {
        notificationObservers.addAll(participants);
    }

    @Override
    public void unregister(User participant) {
        notificationObservers.remove(participant);

    }

    @Override
    public void notify(User sender, Message message) {
        for(NotificationObserver notificationObserver:notificationObservers){
            notificationObserver.update(sender,message);
        }
    }
}
