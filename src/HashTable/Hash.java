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



        public static void main(String[] args){

        }

}
