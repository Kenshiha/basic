package stack;

public class ArrayStack {
    private int[] arr;
    private int capacity;
    private int top;

    public ArrayStack(int capacity){
        this.capacity = capacity;
         arr = new int[capacity];
         top = -1;
    }

    public void add(int val){
        if( top == capacity - 1){
            throw new IndexOutOfBoundsException("Stack Overflow");
            //System.out.println("Stack Overflow");
        }
        arr[++top] = val;
    }
    public void pop(){
        if (top == -1){
            throw new IndexOutOfBoundsException("Stack Underflow");
        }
        top--;
    }

    public void display(){
        for(int i = 0; i <= top; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
            ArrayStack list = new ArrayStack(5);

            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
            list.pop();

            list.display();

    }
}
