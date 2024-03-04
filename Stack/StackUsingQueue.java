package Stack;

import java.util.LinkedList;
import java.util.Queue;
/*
Ref: https://www.geeksforgeeks.org/implement-stack-using-queue/
Use two queues: q1,q2
peek and pop from q1
push:
step1: insert to q2
step2: copy remaining elements from q1 to q2
step3: swap q1, q2
 */
public class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    StackUsingQueue(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }
    void push(int item){
        // Enqueue the new item to queue2
        queue2.offer(item);
        // Move all remaining elements in Q1 to Q2
        if(!queue1.isEmpty()) {
            while (!queue1.isEmpty())
                queue2.offer(queue1.poll());
        }
        // Swap queue1 and queue2
        Queue<Integer> tempQueue=queue1;
        queue1=queue2;
        queue2=tempQueue;
    }
    int pop(){
        if(queue1.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return queue1.poll();
    }
    int peek(){
        if(queue1.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return queue1.peek();
    }
    public static void main(){
        StackUsingQueue stackUsingQueue=new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        System.out.println("Peek: " + stackUsingQueue.peek()); // Should print 3

        System.out.println("Pop: " + stackUsingQueue.pop()); // Should print 3
        System.out.println("Pop: " + stackUsingQueue.pop()); // Should print 2

        stackUsingQueue.push(4);

        System.out.println("Peek: " + stackUsingQueue.peek()); // Should print 4
        System.out.println("Pop: " + stackUsingQueue.pop()); // Should print 4
        System.out.println("Pop: " + stackUsingQueue.pop()); // Should print 1
        // stack.pop(); // This will throw an exception as the stack is empty
    }
}
