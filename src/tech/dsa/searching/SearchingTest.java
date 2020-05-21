package tech.dsa.searching;

import tech.util.PrintUtil;
import tech.util.TestDataProvider;

public class SearchingTest {
    public static void main(String args[]){
        int[] input = TestDataProvider.getOrderedNumberArray(10);
        int data = 3;
        PrintUtil.printArray("Input", input);

        long startTime1 = System.nanoTime();
        int recIndex = BinarySearch.searchIteratively(input, data);
        long endTime1 = System.nanoTime();
        System.out.println("BS Itr Found At: " + recIndex + " Time: "+(endTime1 - startTime1));


        long startTime2 = System.nanoTime();
        int itrIndex = BinarySearch.searchRecursively(input, data, 0, 9);
        long endTime2 = System.nanoTime();
        System.out.println("BS Recr Found At: " + itrIndex+ " Time: "+(endTime2 - startTime2));

        long startTime3 = System.nanoTime();
        int interpolationIndex = InterpolationSearch.search(input, data);
        long endTime3 = System.nanoTime();
        System.out.println("BS Recr Found At: " + interpolationIndex+ " Time: "+(endTime3 - startTime3));
    }
}
