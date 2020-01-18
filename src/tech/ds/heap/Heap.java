package tech.ds.heap;

public class Heap {
    private int[] array;
    private int capacity = 16; //Default value
    private int size;
    private HeapType heapType;

    public Heap(int capacity, HeapType heapType){
        array = new int[capacity];
        this.capacity = capacity;
        this.heapType = heapType;
        this.size = 0;
    }

    public Heap(){
        array = new int[capacity];
        this.heapType = HeapType.MIN_HEAP;
        this.size = 0;
    }

    //O(log n)
    public boolean insert(int v){
        if (size >= capacity){
            return false;
        }
        array[size] = v;
        heapifyingPercolateUp(size); //O(log n): Insertion use the Percolate up
        size++;
        return true;
    }

    //O(log n)
    //TODO: Here we should delete any element from heap. Left and right child need to use.
    public void delete(int v){

    }

    //O(log n)
    public int deleteTopElement(){
        int topElement = getTopElement();
        swapValue(0, size-1);
        this.size--;
        heapifyingPercolateDown(0);//O(log n): Deletion use the Percolate down
        return topElement;
    }

    //O(1)
    public int getTopElement(){
        if (size > 0){
            return array[0];
        }
        return -1;
    }

    //O(log n)
    public void heapifyingPercolateDown(int index){
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int maxIndex = index;
        if (leftChildIndex < 0 && rightChildIndex > 0){
            maxIndex = rightChildIndex;
        }
        else if (leftChildIndex > 0 && rightChildIndex < 0){
            maxIndex = leftChildIndex;
        }
        else if (leftChildIndex > 0 && rightChildIndex > 0){
            if (array[leftChildIndex] > array[rightChildIndex]){
                maxIndex = leftChildIndex;
            }else {
                maxIndex = rightChildIndex;
            }
        }
        else if (leftChildIndex < 0 && rightChildIndex < 0){
            return;
        }

        if (maxIndex < size && heapType.equals(HeapType.MAX_HEAP) && array[maxIndex] > array[index]){
            swapValue(maxIndex, index);
            heapifyingPercolateDown(maxIndex);
        }
        if (maxIndex < size && heapType.equals(HeapType.MIN_HEAP) && array[maxIndex] < array[index]){
            swapValue(maxIndex, index);
            heapifyingPercolateDown(maxIndex);
        }
    }

    //O(log n)
    public void heapifyingPercolateUp(int index){
        int parentIndex = getParentIndex(index);
        if (parentIndex < 0){
            return;
        }
        if (heapType.equals(HeapType.MAX_HEAP) && array[parentIndex] < array[index]){
            swapValue(index, parentIndex);
            heapifyingPercolateUp(parentIndex);
        }
        if (heapType.equals(HeapType.MIN_HEAP) && array[parentIndex] > array[index]){
            swapValue(index, parentIndex);
            heapifyingPercolateUp(parentIndex);
        }
    }

    public int getSize(){
        return this.size;
    }

    private void swapValue(int index, int parent) {
        int temp = array[parent];
        array[parent] = array[index];
        array[index] = temp;
    }

    //O(n)
    public void printHeapArray(){
        for(int i=0; i<this.size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public enum HeapType{
        MAX_HEAP,
        MIN_HEAP
    }

    private int getParentIndex(int index){
        if (index < 0 || index > size){
            return -1;
        }
        return (index-1)/2;
    }

    private int getLeftChildIndex(int index){
        if (index >= this.size){
            return -1;
        }
        return (index*2)+1;
    }

    private int getRightChildIndex(int index){
        if (index >= this.size){
            return -1;
        }
        return (index*2)+2;
    }
}
