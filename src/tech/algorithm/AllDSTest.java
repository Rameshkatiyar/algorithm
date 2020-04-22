package tech.algorithm;

import java.util.*;

public class AllDSTest {
    public static void main(String args[]){
        //String
        String str = "abc";
        str.length(); //Only string has the length() method.
        str.isEmpty();


        //Array
        Integer[] a = new Integer[10];
        int[] b = new int[10];
        a[0] = 123;
        b[0] = 123;
        int length = a.length; //Only Array has the length variable.
        int length1 = b.length;

        //Collection:
        List<String> listOfValue = new LinkedList<String>();
        listOfValue.add("Abc");
        int size = listOfValue.size();//All collection has size() method in collection.
        listOfValue.isEmpty(); // isEmpty() method available for each collections.


        Map<String, String> mapVal = new HashMap<>();
        mapVal.put("abc", "123");
        int size1 = mapVal.size();
        mapVal.isEmpty();
        mapVal.replace("abc" ,"456");

        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.pop();
//        stk.peek();
        int size2 = stk.size();
        stk.isEmpty();

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.remove();
        que.peek();
        que.isEmpty();
        int size3 = que.size();

        ArrayList<Integer> ar = new ArrayList<>(2);
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.size();
        ar.remove(1);
        System.out.println(ar.get(1));

    }
}
