package LLD.ObserverDesignPattern.PublisherSubscriber;

public class Subscriber implements ISubscriber{
    private String name;
    Subscriber(String name){
        this.name=name;
    }
    @Override
    public void update(String msg) {
        System.out.println(name + " received message: " + msg);
    }
}
