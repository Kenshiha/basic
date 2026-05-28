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
    public DoublyLinkedList(){
      head = null;
      tail = null;
      size = 0;
    }

    public void addFirst(int val){
      DoublyNode newNode = new DoublyNode(val);

      if(head == null){
          head = newNode;
          tail = newNode;
      }
      else{
          newNode.next = head;
          head.prev = newNode;
          head = newNode;
      }
      size++;
    }
    public void addAt(int index,int val){
      if(index == 0){
          addFirst(val);
      }
      if(index < 0 || index > size){
          throw new IndexOutOfBoundsException();
      }
      DoublyNode newNode = new DoublyNode(val);
      DoublyNode temp = head;

      for(int i = 0; i < index - 1;i++){   //10->20->30->40->null
          temp = temp.next;
      }
      newNode.next = temp.next;
      newNode.prev = temp;

      temp.next.prev = newNode;
      temp.next = newNode;
      size++;
    }
    public void addLast(int val){
      DoublyNode newNode = new DoublyNode(val);
      if(head == null){
          head = newNode;
          tail = newNode;
      }
      else{
          tail.next = newNode;
          newNode.prev = tail;
          tail = newNode;
      }
      size++;
    }
    public void print(){
      DoublyNode temp = head;

      while(temp != null){
          System.out.print(temp.val + "->");
          temp = temp.next;
      }
        System.out.println("null");
    }
    public void removeFirst(){
      if(head == null){
          System.out.println("List is empty");
      }
      else{
          head = head.next;
          head.prev = null;
          size--;
      }
    }
    public int size(){
      return size;
    }
    public static void main(String[] args){

      DoublyLinkedList list = new DoublyLinkedList();

      list.addFirst(10);
      list.addLast(90);
      list.addAt(1,20);
      list.removeFirst();
      list.print();
      System.out.println(list.size());
    }

}
