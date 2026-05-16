public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

  private static class DoublyNode{
        private int val;
        private DoublyNode prev;
        private DoublyNode next;

        DoublyNode(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        DoublyNode(int val,DoublyNode prev,DoublyNode next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

}
