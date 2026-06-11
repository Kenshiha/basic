package stack;

// Array based stack

public class ArrayStack {
    private int[] arr;
    private int capacity;
    private int top;

    public ArrayStack(int capacity){
        this.capacity = capacity;
         arr = new int[capacity];
         top = -1;
    }

    public void push(int val){
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
    public void peep(){
        if(top == -1){
            throw new IndexOutOfBoundsException("Stack is Empty");
        }
        System.out.println(arr[top]);
    }

    public void display(){
        for(int i = 0; i <= top; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
            ArrayStack list = new ArrayStack(5);

            list.push(10);
            list.push(20);
            list.push(30);
            list.push(40);
            list.push(50);
            list.pop();
            list.peep();

            list.display();

    }
}
