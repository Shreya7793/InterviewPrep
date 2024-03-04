package Threading;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Im running using Runnable!");
    }
    public static void main(String []args){
        ThreadDemo threadDemo=new ThreadDemo();
        new Thread(threadDemo).start();
    }
}
