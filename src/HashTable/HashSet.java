package HashTable;

public class HashSet {

    class Node{
        int key;
        Node next;

            Node(int key){
                this.key = key;
            }
    }
    private Node[] set;
    private int size = 1009;

        HashSet(){
            set = new Node[size];

            for(int i = 0; i< size; i++){
                set[i] = new Node(-1);
            }
        }

        private int hash(int key){
            return key % size;
        }

        public void add(int key){
            int index = hash(key);
            Node curr = set[index].next;
            
            while(curr != null){
                if(curr.key == key){
                    return;
                }
                curr = curr.next;
            }
            Node newNode = new Node(key);
            newNode.next = set[index].next;
            set[index].next = newNode;

        }

        public boolean contain(int key){
            int index = hash(key);
            Node curr = set[index].next;

            while(curr != null){
                if(curr.key == key){
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public void remove(int key){
            int index = hash(key);

            Node prev = set[index];
            Node curr = prev.next;

            while(curr != null){
                if(curr.key == key){
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr= curr.next;
            }
        }

        public static void main(String[] args){
                HashSet set = new HashSet();

                set.add(1);
                set.add(2);
                set.add(3);
                set.add(4);
                boolean res = set.contain(4);
                boolean res2 = set.contain(5);
                set.remove(3);
                System.out.println(res);
                System.out.println(res2);
        }
}
