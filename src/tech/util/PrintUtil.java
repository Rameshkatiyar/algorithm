package tech.util;

public class PrintUtil {

    public static void printArray(int[] a){
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
        System.out.println("");
    }
}
