public class DynamicArrayList<T> {
    private Object[] arr;
    private int size;
    private int capacity;

    public DynamicArrayList(){
        capacity = 2;
        size = 0;
        arr = new Object[capacity];
    }
    //Insert at the end of an array
    public void add(T val){
        if(size == capacity){
            grow();
        }
        arr[size++] = val;

    }
    //Insert at the specific index
    public void addAt(int index,T val){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if(size == capacity){
            grow();
        }
        for(int i = size ; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = val;
        size++;
    }
    //Updating an elemment
    public void updateAt(int index,T val){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        arr[index] = val;
    }
    //Remove an element from an array
    public void remove(){
        if(size == 0){
            throw new IllegalStateException("Array is Empty");
        }
        size--;
        if(capacity > 2 && size <= capacity/4){
            shrink();
        }
    }
    //Remove from index
    public void removeAt(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        if(capacity > 2 && size <= capacity/4){
            shrink();
        }
    }
    //Display array
    public void display(){
        System.out.print("Array : ");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("| capacity : "+ capacity);

    }
    // To expand array to double of its size
    private void grow(){
        capacity = capacity * 2;
        Object[] newArr = new Object[capacity];
//            for (int i = 0; i < arr.length; i++){
//                newArr[i] = arr[i];
//            }
        System.arraycopy(arr, 0,newArr,0, size);
        arr = newArr;
    }

    private void shrink(){
        capacity = capacity / 2;
        Object[] newArr = new Object[capacity];
        System.arraycopy(arr,0,newArr,0,size);
        arr = newArr;
    }

    //Contains element
    public boolean contains(T val){
        for(int i = 0; i < size; i++){
            if(arr[i].equals(val)){
                return true;
            }
        }
        return false;
    }
    //Index of element
    public int indexOf(T val){
        for(int i = 0; i < size; i++){
            if(arr[i].equals(val)){
                return i;
            }
        }
        return -1;
    }
    //clear list
    public void clear(){
        size = 0;
    }

    //Editional
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return (T) arr[index];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(arr[i]);
            if(i < size -1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //Ensure Capacity Ahead
    public void ensureCapacity(int minCapacity){
        if(capacity >= minCapacity){
            return;
        }
        while (capacity < minCapacity){
            capacity *= 2;
        }
        Object[] newArr = new Object[capacity];
        System.arraycopy(arr,0,newArr,0,size);
        arr = newArr;
    }

    public static void main(String[] args){
        DynamicArrayList<Integer> nums = new DynamicArrayList<>();
        DynamicArrayList<String> list = new DynamicArrayList<>();

        nums.add(10);
        nums.add(20);
        nums.display();
        nums.add(30);
        nums.add(40);
        nums.add(50);
        nums.display();
        nums.remove();
        nums.display();

        int x = nums.get(1);

        System.out.println(x);
        System.out.println(nums.size());
        System.out.println(nums.isEmpty());

        System.out.println(nums);

        list.add("Hi");
        list.add("hello");
        list.add("H");
        System.out.println(list);

    }
}
