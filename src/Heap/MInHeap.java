package Heap;

public class MInHeap {
    int[] heap;
    int size;
    int cap;

    MInHeap(int cap){
        heap = new int[cap];
        size = 0;
        this.cap = cap;

    }

    public void add(int val){
        if(size >= cap){
            throw new IndexOutOfBoundsException();
        }
        heap[size++] = val;

    }
}
