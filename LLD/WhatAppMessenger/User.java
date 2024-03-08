package LLD.WhatAppMessenger;

public class User implements NotificationObserver{
    String userId;
    String userName;
    String phoneNumber;
    String password;

    public User(String userId, String userName, String phoneNumber, String password) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void update(User sender, Message message) {
        System.out.println("Message recieved by:"+userName+" " +
                "User " + sender + " sent a new message: " + message.getContent());
    }
}
