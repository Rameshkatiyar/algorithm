package tech.dsa.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(10, Heap.HeapType.MAX_HEAP);
//        Heap heap = new Heap();
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(1);
        heap.insert(5);
        heap.insert(8);
        heap.insert(7);

        heap.printHeapArray();

        System.out.println("Top Element: "+heap.getTopElement());
        System.out.println("Size: "+heap.getSize());
        System.out.println("Deleted: "+heap.deleteTopElement());
        System.out.println("Size: "+heap.getSize());

        heap.printHeapArray();
    }
}
