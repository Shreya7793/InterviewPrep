package Stack;

import java.util.Queue;

/*
Ref: https://www.youtube.com/watch?v=lPL-pmBm04Q
In this deque takes O(n) Time complexity. to make it to O(1) use circular array
 */
public class QueueUsingArray {
    int arr[];
    int capacity;
    int rear;
    QueueUsingArray(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        rear=-1;
    }
    void enqueue(int item){
        if(rear==capacity-1)
            throw new IllegalStateException("Queue is full");
        ++rear;
        arr[rear]=item;
    }
    int dequeue(){
        if(rear==-1)
            throw new IllegalStateException("Queue is Empty");
        int res=arr[0];
        for(int i=0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        --rear;
        return res;
    }
    int peek(){
        if(rear==-1)
            throw new IllegalStateException("Queue is Empty");
        return arr[0];
    }
    public static void main(String []args) {
        QueueUsingArray queueUsingArray = new QueueUsingArray(3);
        queueUsingArray.enqueue(3);
        queueUsingArray.enqueue(4);
        queueUsingArray.enqueue(5);
        System.out.println("Peek: " + queueUsingArray.peek()); // Should print 1

        System.out.println("Dequeue: " + queueUsingArray.dequeue()); // Should print 1
        System.out.println("Dequeue: " + queueUsingArray.dequeue()); // Should print 2

        queueUsingArray.enqueue(4);

        System.out.println("Peek: " + queueUsingArray.peek()); // Should print 3
        System.out.println("Dequeue: " + queueUsingArray.dequeue()); // Should print 3
        System.out.println("Dequeue: " + queueUsingArray.dequeue()); // Should print 4
        queueUsingArray.dequeue(); //exception
    }
}
