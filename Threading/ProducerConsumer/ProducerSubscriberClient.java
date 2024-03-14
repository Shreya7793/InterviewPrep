package Threading.ProducerConsumer;

public class ProducerSubscriberClient {

    public static void main(String []args){
        final String[] messages={"Hi!!", "How are you!!", "I love you!", "What's going on?!!", "That's really funny!!"};
        MessageQueue queue=new MessageQueue(5);
        Thread producer= new Thread(new Producer(queue,messages),"producer"); //producer produces messages
        Thread consumer=new Thread(new Consumer(queue),"consumer");
        //If we need multiple consumers
       /* for(int i=0;i<5;i++){
            new Thread(new Consumer(queue), "Consumer "+i).start();
        }*/

        producer.start();
        consumer.start();
    }

}   
