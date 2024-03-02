package LLD.ObserverDesignPattern.PublisherSubscriber;
/*
we would implement a simple topic and observers can register to this topic.
Whenever any new message will be posted to the topic, all the registers observers will be notified and
they can consume the message.
Link: https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java
 */
public class Client {
    public static void main(String []args){
        //create publisher - can also be called as topic/subject
        Publisher publisher=new Publisher();

        //create subscribers
        Subscriber subscriber1= new Subscriber("subscriber1");
        Subscriber subscriber2= new Subscriber("subscriber2");
        Subscriber subscriber3= new Subscriber("subscriber3");

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);
        publisher.subscribe(subscriber3);

        publisher.publish("Hello Subscribers");
        publisher.unSubscribe(subscriber1);
        publisher.publish("Goodbye subscriber 1!");
    }
}
