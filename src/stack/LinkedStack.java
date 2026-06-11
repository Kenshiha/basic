package stack;

// Linked list based stack

public class LinkedStack {
    private Node top;
    private int size;

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            next = null;
        }
    }

    LinkedStack(){
        top = null;
        size = 0;
    }

    public void push(int val){
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void peek(){
        if(top == null){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        System.out.println(top.val);
    }

    public void pop(){
        if(top == null){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        top = top.next;
        size--;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node temp = top;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args){
        LinkedStack list = new LinkedStack();

        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.pop();
        list.print();
        list.peek();

        int r = list.size();
        System.out.println(r);
    }
}
