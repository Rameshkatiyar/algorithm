package tech.ds.searching;

public class BinarySearch {
    public static int searchIteratively(int[] array, int data){
        int low = 0, high = array.length-1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (array[mid] == data){
                return mid;
            }else {
                if (data < array[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //TODO: Need to work on this.
    public static int searchRecursively(int[] array, int data, int low, int high){
        int mid = low + (high - low)/2;
        if (low > high){
            return -1;
        }
        if (array[mid] == data){
            return mid;
        }else {
            if (data < array[mid]){
                searchRecursively(array, data, low, mid - 1);
            }else {
                searchRecursively(array, data, mid + 1, high);
            }
        }
        return -1;
    }
}
