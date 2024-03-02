package LLD.ObserverDesignPattern.PublisherSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher{
    List<Subscriber> subscriberList=new ArrayList<>();
    final Object MUTEX= new Object();
    String message;
    /*
    Notice the boolean variable to keep track of the change in the state of topic and used in notifying observers.
    This variable is required so that if there is no update and somebody calls notifyObservers() method,
    it doesn’t send false notifications to the observers.
     */
    private boolean changed;
    @Override
    public void subscribe(Subscriber subscriber) {
        if(subscriber == null)
            throw new NullPointerException("Null subscriber");
        synchronized (MUTEX) {
            if (!subscriberList.contains(subscriber))
                subscriberList.add(subscriber);
        }
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        synchronized (MUTEX) {
            subscriberList.remove(subscriber);
        }
    }

    /*
    The use of synchronization in notifyObservers() method to make sure the notification is sent only to the observers
    registered before the message is published to the topic.
     */
    @Override
    public void notifySubscribers() {
        List<Subscriber> subscriberListLocal;
        synchronized (MUTEX) {
            if(!changed)
                return;
            subscriberListLocal = new ArrayList<>(this.subscriberList);
            this.changed=false;
        }
        for(Subscriber subscriber:subscriberListLocal){
            subscriber.update(this.message);
        }
    }

    //method to publish message to the subscribers
    public void publish(String msg){
        System.out.println("Message Posted to Subscribers:"+msg);
        this.message=msg;
        this.changed=true;
        notifySubscribers();
    }
}
