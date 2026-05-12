public class ReverseLinkedList {
    public static Node reverse(Node head){

        if(head == null || head.next == null){
            throw new IllegalStateException();
        }
        Node prev = null;
        Node curr = head;

        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args){
        Node head = new Node(1,new Node(2,new Node(3,new Node(4))));

        System.out.println("Before Reverse");
        Node before = head;
        while (before != null){
            System.out.print(before.val + "->");
            before = before.next;
        }
        System.out.println("null");

        Node rev = reverse(head);

        System.out.println("After Reverse");
        Node temp = rev;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }
}
