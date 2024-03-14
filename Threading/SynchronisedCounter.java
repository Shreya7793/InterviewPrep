package Threading;

public class SynchronisedCounter extends Thread{
    int counter=0;
    synchronized void increment(){
        ++counter;
    }
    synchronized void decrement(){
        --counter;
    }
    synchronized int getCount() {
        return counter;
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronisedCounter synchronisedCounter=new SynchronisedCounter();
        Thread incrementThread = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100000; i++) {
                    synchronisedCounter.increment();
                }
          }
        };
        Thread decrementThread = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100000; i++) {
                    synchronisedCounter.decrement();
                }
            }
        };
        // Start the threads
        incrementThread.start();
        decrementThread.start();
        // Wait for threads to finish
        incrementThread.join();
        decrementThread.join();

        // Output the final value of the counter
        System.out.println("Final value of counter: " + synchronisedCounter.getCount());

    }
}
