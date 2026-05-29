public class CircularList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    CircularList(){
        head = null;
        size = 0;
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }else{
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            addFirst(val);
            return;
        }
        else{
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }
    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            tail.next = head;
        }
        size--;
    }
    public void removeLast(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
        size--;
    }
    public void print(){
        Node temp = head;
        while(temp != tail){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print(tail.val);
        System.out.println();

    }

    public static void main(String[] args){
        CircularList list = new CircularList();

        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(70);
        list.addLast(80);
        list.addLast(90);
        list.print();
        list.removeFirst();
        list.removeLast();
        list.print();
    }
}
