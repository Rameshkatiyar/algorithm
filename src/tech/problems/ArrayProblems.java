package tech.problems;

public class ArrayProblems {
    public static void main(String[] args) {
        double l = 922337203685477580d;
        System.out.println(l+1);

//        findTheSumWindow();
    }

    /**
     * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
     */
    public static void findTheSumWindow(){
//        int a[] = new int[]{2, 3, 4};
        int a[] = new int[]{3, 3, 3, 7};
        int sum = 7;

        //start
        int wStart = 0, wEnd = 0;
        int wSum = a[0];

        while(wEnd < a.length){
            if (sum == wSum){
                break;
            }

            if (wSum < sum){
                wEnd++;
                if (wEnd <= a.length-1){
                    wSum += a[wEnd];
                }
            }

            if (wSum > sum){
                wSum -= a[wStart];
                wStart++;
            }
        }

        System.out.println("Window Sum: "+ wSum);
        System.out.println("Start: "+wStart);
        System.out.println("End: "+wEnd);
    }
}
