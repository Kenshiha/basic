package Queue;

// Array based queue

public class MyQueue {
    private int[] arr;
    private int capacity;
    private int first;
    private int rear;

    MyQueue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        first = -1;
        rear = -1;
    }

    public void enqueue(int val){

        if(rear == capacity - 1){
            throw new IndexOutOfBoundsException("Queue is Full");
        }

        if(first == -1){
            first = 0;
        }

        arr[++rear] = val;
    }

    public void dequeue(){
        if(first == -1){
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        first++;

        if(first > rear){
            first = -1;
            rear = -1;
        }
    }
    public void peek(){
        if(rear == -1){
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        System.out.println(arr[first]);
    }
    public boolean isEmpty(){
        return first == -1;
    }
    public void print(){
        while (first != capacity){
            System.out.println(arr[first] + " ");
            first++;
        }
    }
    public static void main(String[] args){

        MyQueue list = new MyQueue(5);

        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(40);
        list.enqueue(50);
        list.dequeue();
        list.enqueue(60);

        list.print();
    }
}
