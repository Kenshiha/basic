package Queue;

public class LinkedListQueue {
        private Node first;
        private Node rear;
        int size;

    private class Node{
            int val;
            Node next;

            Node(int val){
                this.val = val;
                next = null;
            }
    }
    LinkedListQueue(){
        first = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int val){
        Node newNode = new Node(val);

        if(first == null){
            first = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void dequeue(){
        if(first == null){
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        first = first.next;

        if(first == null){
            rear = null;
        }
        size--;
    }
    public void peek(){
        System.out.println(first.val);
    }

    public void print(){
        Node temp = first;

        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return first == null;
    }



    public static void main(String[] args){
        LinkedListQueue list = new LinkedListQueue();

        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(40);
        list.enqueue(50);
        list.print();
        list.dequeue();
        list.print();
        list.peek();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }

}
