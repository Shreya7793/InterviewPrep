package Stack;
/*
Ref: https://www.youtube.com/watch?v=lPL-pmBm04Q
Use front and rear pointer
 */
public class CircularQueueUsingArray {
    int arr[];
    int size;
    int front=-1,rear=-1;
    CircularQueueUsingArray(int size){
        arr=new int[size];
        this.size=size;
    }
    void enqueue(int item){//add to rear
        if((rear+1)%size==front)
            throw new IllegalStateException("Queue is full");
        if(front==-1)
            front=0; //only for first time insert
        rear=(rear+1)%size; //because of this modulo operation it moves in circular order
        arr[rear]=item;
    }
    int deque(){ //remove from front - Queue follows FIFO
        if(front==-1)
            throw new IllegalStateException("Queue is Empty");
        int result=arr[front];
        if(front==rear) //means queue is empty
            front=rear=-1;
        else
            front=(front+1)%size;
        return result;
    }


}
