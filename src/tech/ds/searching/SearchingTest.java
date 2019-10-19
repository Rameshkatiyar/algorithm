package tech.ds.searching;

import tech.util.PrintUtil;
import tech.util.TestDataProvider;

public class SearchingTest {
    public static void main(String args[]){
        int[] input = TestDataProvider.getOrderedNumberArray(10);
        int data = 7;
        PrintUtil.printArray(input);
        int recIndex = BinarySearch.searchIteratively(input, data);
        System.out.println("Itr Found At: " + recIndex);
        int itrIndex = BinarySearch.searchRecursively(input, data, 0, 9);
        System.out.println("Recr Found At: " + itrIndex);
    }
}
