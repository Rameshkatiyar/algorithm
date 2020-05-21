package tech.dsa.strings;

public class StringsMatching {


    //O(n * m)
    public static boolean bruteForce(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i < n; i++){
            int j = 0;
            while (j < m){
                if (text.charAt(i+j) == pattern.charAt(j)){
//                    System.out.println("compare "+text.charAt(i+j)+" == "+pattern.charAt(j));
                    j++;
                }else {
                    break;
                }
            }
            if (j == m){
                return true;
            }
        }
        return false;
    }

    public static boolean rabinKarp(){

        return false;
    }

}
