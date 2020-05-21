package tech.util;

import java.util.Arrays;
import java.util.List;

public class PrintUtil {

    public static void printArray(String msg, int[] a){
        System.out.print(msg + " ");
        System.out.println(Arrays.toString(a));
    }

    public static void printList(List<Integer> listOfInteger){
        listOfInteger.stream()
                .forEach(System.out::println);
    }
}
