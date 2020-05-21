package tech.dsa.sorting;

import java.util.Arrays;

/**
 * Quick sort is a divide and conqure algorithm.
 * It's work in 3 parts:
 * 1. Get the partition element. (Pivot)
 * 2. Divide problem on pivot index. (Recursively)
 * 3. Again repeat the step 1 and 2.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 8, 4, 10, 1, 6, 10, 8, 10, 9};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int start, int end){
        if(start < end){
            int pIndex = partion(a, start, end);
            quickSort(a, start, pIndex-1);
            quickSort(a, pIndex+1, end);
        }
    }

    public static int partion(int[] a, int start, int end){
        int pivot = a[end];
        int pIndex = start;
        for(int i=start; i<=end; i++){
            if(a[i] < pivot){
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        swap(a, pIndex, end);
        return pIndex;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
