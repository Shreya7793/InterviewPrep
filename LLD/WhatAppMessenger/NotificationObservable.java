package LLD.WhatAppMessenger;

import java.util.List;

public interface NotificationObservable {
    void register(List<User> receivers);
    void unregister(User receiver);
    void notify(User sender,Message message);
}
