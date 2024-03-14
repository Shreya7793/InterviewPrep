package Threading.ProducerConsumer;

public class Producer implements Runnable{
    MessageQueue queue; //Producer has access to the Message queue, which is passed via constructor
    String [] messages;
    public Producer(MessageQueue queue, String[] messages) {
        this.queue = queue;
        this.messages=messages;
    }

    @Override
    public void run() {
        int i=0;
        try{
            while(true){
                Thread.sleep(1000);
                queue.publish(messages[i]); //publisher is publishing msg every 1000 ms
                i=(i+1)%messages.length; // This iterates cyclically through an array or a circular buffer
            }

        } catch (InterruptedException iex){
            iex.printStackTrace();
        }
    }
}
