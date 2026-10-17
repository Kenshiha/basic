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

    void heapifyDown(int[] heap, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < n && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            //swap(heap,largest, i);

            heapifyDown(heap, n, largest);

        }
    }

    void swap(int[] heap, int i, int j){
        int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
    }
}
