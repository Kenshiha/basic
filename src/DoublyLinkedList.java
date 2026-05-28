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
    public void removeFirst(){
      if(head == null && tail == null){
          System.out.println("List is empty");
      }
      else{
          head = head.next;
          head.prev = null;
          size--;
      }
    }
    public void removeLast(){
      if(tail == null && head == null){
          System.out.println("List is Empty");
      }
      else{
          tail = tail.prev;
          tail.next = null;
          size--;
      }
    }
    public void removeAt(int index){             //10->20->30->40->50->null
      if(index < 0 || index >= size){
          throw new IndexOutOfBoundsException();
      }
      if(index == size - 1){
          removeLast();
      }
      if(index == 0){
          removeFirst();
      }
      DoublyNode temp = head;
      for(int i = 0;i < index - 1;i++){
       temp = temp.next;
      }
      temp.next.next.prev = temp;
      temp.next = temp.next.next;
      size--;
    }
    public void print(){
        DoublyNode temp = head;

        System.out.print("null<->");
        while(temp != null){
            System.out.print(temp.val + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public int size(){
      return size;
    }

    public void reverse(){
        if(head == null || head.next == null){
            throw new IllegalStateException();
        }

        DoublyNode prev = null;     //null<-10-><-20-><-30->null
        DoublyNode temp = head;
        while (temp != null){

            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;

            temp = temp.prev;
        }
        this.head = prev.prev;
    }
    public void reversePrint(){
        DoublyNode temp = tail;
        System.out.print("null<->");
        while (temp != null){
            System.out.print(temp.val + "<->");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public static void main(String[] args){

      DoublyLinkedList list = new DoublyLinkedList();

      list.addFirst(20);
      list.addFirst(10);
      list.addLast(90);
      list.addAt(2,30);
      //list.removeAt(2);
      list.reverse();
     // list.reversePrint();
      list.print();
      System.out.println(list.size());
        System.out.println(list.head.val);
    }

}
