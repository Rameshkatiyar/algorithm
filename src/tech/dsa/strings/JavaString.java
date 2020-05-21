package tech.dsa.strings;

public class JavaString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");

        System.out.println("S1: "+s1 +"\n"+"S2: "+s2);

        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);

        String ss = "absdsesseghsx";
        System.out.println(ss.charAt(8));
    }
}
