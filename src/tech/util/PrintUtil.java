package tech.util;

public class PrintUtil {

    public static void printArray(String msg, int[] a){
        System.out.print(msg + " ");
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
        System.out.println("");
    }
}
