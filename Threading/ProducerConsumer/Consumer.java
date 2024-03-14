package Threading.ProducerConsumer;

public class Consumer implements Runnable{
    MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(2000);
                queue.consume(); //Consumer is consuming msg every 2000 ms
            }
        } catch (InterruptedException iex){
            iex.printStackTrace();
        }
    }
}
