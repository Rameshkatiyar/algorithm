package tech.dsa.strings;

public class StringsTest {
    public static void main(String args[]){
        String text = "abcedeads";
        String pattern = "ced";

        boolean matched = StringsMatching.bruteForce(text, pattern);
        System.out.println("Found: "+matched);
    }
}
