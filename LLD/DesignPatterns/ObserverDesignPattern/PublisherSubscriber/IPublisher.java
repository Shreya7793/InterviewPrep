package LLD.DesignPatterns.ObserverDesignPattern.PublisherSubscriber;

public interface IPublisher {
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscribers();
}
