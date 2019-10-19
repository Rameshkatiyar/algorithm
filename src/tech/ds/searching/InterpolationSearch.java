package tech.ds.searching;

public class InterpolationSearch {

    public static int search(int[] a, int data){
        int low = 0, high = a.length - 1, mid;

        while (a[low] <= data && data <= a[high]){
            if (a[high] - a[low] == 0){
                return (high + low)/2;
            }

            mid = low + (((data - a[low])*(high - low))/(a[high] - a[low]));

            if (a[mid] == data){
                return mid;
            }else {
                if (data < a[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

}
