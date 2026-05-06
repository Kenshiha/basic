class Node {
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
//    Node(int val,Node next){
//        this.val = val;
//        this.next = next;
//    }
}

public class linkedList {
  private Node head;
  private int size;

  public linkedList(){
      head = null;
      size = 0;
  }
  public void addFirst(int val){
      Node newNode = new Node(val);    //10->15->20->null
      newNode.next = head;
      head = newNode;
      size++;

  }
  public void addLast(int val){
      Node newNode = new Node(val);     // 5->10->15->20->null

      if(head == null){
          head = newNode;
          size++;
          return;
      }
      Node temp = head;
      while (temp.next != null){
          temp = temp.next;
      }
      temp.next = newNode;
      size++;
  }

  public void addAt(int index,int val){
      if(index == 0){
          addFirst(val);
          return;
      }
      if(index < 0 || index > size){
          throw new IndexOutOfBoundsException("Invalid Index");
      }
      Node newNode = new Node(val);
      Node temp = head;

      for(int i = 0; i < index - 1; i++){
          temp = temp.next;
      }
      newNode.next = temp.next;
      temp.next = newNode;
      size++;
  }

  private void removeFirst(){
      if(head == null) {
          throw new IllegalStateException("List is empty");
      }
      head = head.next;
      size--;
  }

  private void removeLast(){    //5->10->15->20->null
      if(head == null){
          throw new IllegalStateException("List is empty");
      }
      if(head.next == null){
          head = null;
          size--;
          return;
      }
      Node temp = head;
      while(temp.next.next != null){
          temp = temp.next;
      }
      temp.next = null;
      size--;
  }

  public void removeAt(int index){        //5->10->15->20->25->null
      if(index < 0 || index >= size){
          throw new IndexOutOfBoundsException("Invalid Index");
      }
      if(index == size - 1){
          removeLast();
          return;
      }
      if(index == 0){
          removeFirst();
          return;
      }
      Node temp = head;
      for(int i = 0; i < index - 1;i++){
          temp = temp.next;
      }
      temp.next = temp.next.next;
      size--;
  }

  public void print(){
      Node temp = head;
      while (temp != null){
          System.out.print(temp.val + "->");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public void set(int index,int val){         //5->10->15->20->25->null
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
            temp.val = val;
  }

  public int size(){
      return size;
  }
  public int get(int index){  //5->10->15->20->25->null
      if(index < 0 || index >= size){
          throw new IndexOutOfBoundsException("Invalid Index");
      }
      Node temp = head;
      for(int i = 0; i < index;i++){
          temp = temp.next;
      }
      return temp.val;
  }

  public static void main(String[] args){

        linkedList list = new linkedList();

        list.addFirst(10);
        list.addFirst(5);
        list.addLast(15);
        list.addLast(20);
       // list.addAt(2,200);
        list.print();
        list.removeAt(4);
       // list.set(3,99);
        list.print();
        System.out.println(list.size());
        System.out.println(list.get(0));

  }
}
