package Heap;

//  Heap
//  for left child      2 * i + 1
//  for right child     2 * i + 2
// for parent           (i - 1) / 2

public class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity){
        this.capacity = capacity;
        size = 0;
        heap = new int[capacity];
    }

    public void insert(int val){

        if(size >= capacity){
            throw new IndexOutOfBoundsException();
        }

        heap[size++] = val;
        heapify();
    }

    private void heapify(){
        int i = size - 1;

        while ( i > 0 && heap[i] > heap[(i-1)/2]){
            int parent = (i - 1) / 2;

            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;

            i = parent;
        }
    }

    public void display(){
        for(int i = 0;i <= size - 1; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args){

            MaxHeap myHeap = new MaxHeap(8);

            myHeap.insert(10);
            myHeap.insert(20);
            myHeap.insert(30);
            myHeap.insert(40);
            myHeap.insert(50);
            myHeap.display();
    }
}
