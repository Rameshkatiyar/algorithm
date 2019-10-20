package tech.ds.searching;

import tech.util.PrintUtil;

import java.util.Arrays;

public class SearchingProblems {

    /**
     *Given an array A[] and a number x, check for pair in A[] with sum as x
     * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
     */
    public static boolean findPairsWhichSumIsX(int[] a, int sum){
        //1. Sort the array in increasing order.
        PrintUtil.printArray("Input", a);
        Arrays.sort(a);
        PrintUtil.printArray("Sorted", a);

        int left = 0, right = a.length-1;

        while (left < right){
            if ((a[left] + a[right]) == sum){
                System.out.println("Result index are "+left + " And " + right);
                return true;
            }else {
                if ((a[left] + a[right]) < sum){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return false;
    }


    public static void main(String args[]){
        int[] a = {2,3,1,6,4,8,5,6};
        boolean pairsWhichSumIsX = findPairsWhichSumIsX(a, 7);
        System.out.print("Found: "+pairsWhichSumIsX);
    }
}
