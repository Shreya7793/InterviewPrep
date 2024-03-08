package LLD.WhatAppMessenger;

public class MessageManager {
    private static MessageManager messageManager;
    // Private constructor to prevent instantiation from other classes
    private MessageManager() {

    }
    // Lazy initialization with double-checked locking for thread safety
    public static MessageManager getInstance(){
        if(messageManager==null){
            synchronized (MessageManager.class){
                if(messageManager==null)
                    messageManager=new MessageManager();
            }
        }
        return messageManager;
    }

    void sendMessage(Message message){

    }
    void receiveMessage(Message message){

    }
}
