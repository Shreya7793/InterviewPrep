package Stack;

import java.util.Stack;
/*
Use to stacks:
Push: stack1:
Pop, peek-> copy items from Stack 1 to stack 2. pop/peek stack2.
 */
public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    QueueUsingStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    void enqueue(int item){
        stack1.push(item);
    }
    int dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    int peek(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    boolean isEmpty(){
        return stack1.isEmpty()&&stack2.isEmpty();
    }
    public static void main(String []args){
        QueueUsingStack queueUsingStack=new QueueUsingStack();
        queueUsingStack.enqueue(3);
        queueUsingStack.enqueue(4);
        queueUsingStack.enqueue(5);
        System.out.println("Peek: " + queueUsingStack.peek()); // Should print 1

        System.out.println("Dequeue: " + queueUsingStack.dequeue()); // Should print 1
        System.out.println("Dequeue: " + queueUsingStack.dequeue()); // Should print 2

        queueUsingStack.enqueue(4);

        System.out.println("Peek: " + queueUsingStack.peek()); // Should print 3
        System.out.println("Dequeue: " + queueUsingStack.dequeue()); // Should print 3
        System.out.println("Dequeue: " + queueUsingStack.dequeue()); // Should print 4
        queueUsingStack.dequeue(); // This will throw an exception as the queue is empty

    }
}
