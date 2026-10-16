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
        createHeap();
    }

    void createHeap(){
        int i = size - 1;

        while(i > 0 && heap[i] < heap[(i-1)/2]){
            int parent = (i - 1)/2;
            swap(heap, i, parent);
            i = parent;
        }
    }

    void swap(int[] heap, int i, int j){
        int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
    }
}
