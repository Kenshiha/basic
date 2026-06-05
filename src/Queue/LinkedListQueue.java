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

}
