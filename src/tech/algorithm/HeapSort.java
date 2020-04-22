package tech.algorithm;

public class HeapSort {
    public  static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            swap(arr, i , largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] a, int x, int y){
        int val = a[x];
        a[x] = a[y];
        a[y] = val;
    }


    public static void buildHeap(int[] a){
        int startIndex = a.length/2-1;

        //start with last non leaf node and heapify till starting node.
        for(int i = startIndex; i>=0; i--){
            heapify(a, a.length, i);
        }
    }

    public static void heapSort(int[] a){
        //Create Heap nlogn
        buildHeap(a);

        //replace first element with last element and reduce the size of array for heapify
        for (int i = a.length-1; i > 0; i--){
            swap(a, i, 0);
            heapify(a, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,6,1,4,8};
        pringArray(a);
//        buildHeap(a);
        heapSort(a);
        System.out.println("\n");
        pringArray(a);
    }

    private static void pringArray(int[] a) {
        for (int i=0; i<a.length;i++){
            System.out.print(a[i] + "  ");
        }
    }
}
