package HashTable;

public class Hash {
        Node[] table;
        int size;

        class Node{
            String key;
            int val;
            Node next;

            Node(String key, int val){
                this.key = key;
                this.val = val;
            }
        }

        Hash(){
            table = new Node[10];
        }

        private int getIndex(String key){
            return Math.abs(key.hashCode()) % table.length;
        }

        void put(String key, int val){
            int index = getIndex(key);
            Node newNode = new Node(key, val);

            if(table[index] == null){
                table[index] = newNode;
                return;
            }
                Node temp = table[index];

                while(true){
                    if(temp.key.equals(key)){
                        temp.val = val;
                        return;
                    }

                    if(temp.next == null){
                        break;
                    }
                temp = temp.next;
            }
                temp.next = newNode;
        }

        Integer get(String key){
            int index = getIndex(key);
            Node temp = table[index];

            while(temp != null){
                if(temp.key.equals(key)){
                    return temp.val;
                }
                temp = temp.next;
            }
            return null;

        }
        void remove(String key){
            int index = getIndex(key);
            Node temp = table[index];
            Node prev = null;

            while(temp != null){

                if(temp.key.equals(key)){
                    if(prev == null){
                        table[index] = temp.next;
                    }else{
                        prev.next = temp.next;
                    }
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        public void display(){

    }

        public static void main(String[] args){
            Hash myMap = new Hash();

            myMap.put("apple", 10);
            myMap.put("banana",20);
            myMap.put("c",30);
            myMap.put("d",40);
            myMap.remove("c");
            System.out.println(myMap.get("d"));
        }

}
