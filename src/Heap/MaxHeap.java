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
        createHeap();
    }

    private void createHeap(){
        int i = size - 1;

        while ( i > 0 && heap[i] > heap[(i-1)/2]){
            int parent = (i - 1) / 2;

            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;

            i = parent;
        }
    }

    public int deleteMax(){
        if(size <= 0 ){
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapifyDown(heap, size, 0);

        return root;
    }

    void buildHeap(int[] heap){
        int n = heap.length;

        for(int i = (n/2) - 1;i >= 0; i--){
            heapifyDown(heap, n, i);
        }
    }

    void heapSort(){
        if(size <= 0){
            return;
        }
        while (size != 0) {
            swap(heap,0,size - 1 );
            size--;

            heapifyDown(heap, size, 0);
        }
    }

    private void swap(int[] heap,int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyDown(int[] heap,int n,int i){
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < n && heap[left] > heap[largest]){
                largest = left;
            }
            if(right < n && heap[right] > heap[largest]){
                largest = right;
            }
            if(largest != i){
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                heapifyDown(heap, n, largest);
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
