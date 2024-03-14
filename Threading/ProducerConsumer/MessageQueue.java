package Threading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue{
    Queue<String> queue;
    int capacity;

    public MessageQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity=capacity;
    }

    synchronized void publish(String message) throws InterruptedException {
        String name=Thread.currentThread().getName();
        if(queue.size()==capacity){ //check if queue is full, can't publish the msg
            System.out.println("Queue Full!"+name+" waiting for message to be consumed...");
            wait(); //queue full-> producer waits for consumer to consume
        }
        queue.add(message); //message added to queue
        System.out.println("Message published:: "+message);
        System.out.println("Queue: "+ queue);
        System.out.println();
        notifyAll();// Notify consumers that a new message is available
    }
    synchronized void consume() throws InterruptedException {
        String name=Thread.currentThread().getName();
        if(queue.isEmpty()) {
            System.out.println(name + " waiting for new message...");
            wait(); //queue empty-> consumer waits for producer to produce
        }
        String msg=queue.poll(); //consume from queue
        System.out.println(name+" has consumed msg:: "+msg);
        System.out.println("Queue: "+ queue);
        System.out.println();
        notifyAll();// Notify producers that space is available in the queue
    }
}
