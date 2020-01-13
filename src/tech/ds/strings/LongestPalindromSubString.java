package tech.ds.strings;

/**
 * Very Important
 * Algorithm: Longest Palindromic Substring O(N) Manacher's Algorithm
 * Video: https://www.youtube.com/watch?v=nbTSfrEfo6M
 */
public class LongestPalindromSubString {

    public static String getPalindrom(String str){
        if(str.isEmpty()){
            return "";
        }

        char[] T = transformString(str);
        int[] P = new int[T.length]; //Palindromic expanded length. (length of palindrom/2) One side length.

        int center = 0, boundary = 0 ;

        for (int i=1; i<T.length-1; i++){

            //Case 1: Check if char is within boundary.
            // If yes then copy the mirror expanded length.
            if (i < boundary){
                int mirror = 2*center - i;
                P[i] = Math.min((boundary-i), P[mirror]);
            }

            //Case 2: Now expand the current char palindromic till it be palindromic.
            // But start from expanded length (P[i]).
            while (T[i + (P[i]+1)] == T[i - (P[i]+1)]){
                P[i]++;
            }

            //Case 3: Check if boundary of i th palindrom > previous center palindrom.
            // If yes then replace center and boundary with i th center and boundary.
            if (i+P[i] > boundary){
                center = i;
                boundary = i+P[i];
            }
        }
        return getPalindromFromTransformString(P, T);
    }

    /**
     * Just get the maximum expanded length index and get palindrom.
     * @param P
     * @param T
     * @return
     */
    private static String getPalindromFromTransformString(int[] P, char[] T){
        int maxIndex = 0, maxValue = 0;
        for (int i=0; i<P.length; i++){
            if (maxValue < P[i]){
                maxValue = P[i];
                maxIndex = i;
            }
        }
        int startIndex = maxIndex - maxValue;
        int endIndex = maxIndex + maxValue;

        String str = "";
        for (int i=startIndex; i<=endIndex; i++){
            if (T[i] != '#'){
                str = str + T[i];
            }
        }
        return str;
    }

//    public static void printP(int[] P){
//        for (int i=0; i<P.length; i++){
//            System.out.print(P[i]+", ");
//        }
//    }
//    public static void printT(char[] T){
//        for (int i=0; i<T.length; i++){
//            System.out.print(T[i]+", ");
//        }
//    }


    /**
     * Add $,# and @, just to make the string as even length and odd length of palindrom.
     * Example: aba => $#a#b#a#@
     * @param s
     * @return
     */
    public static char[] transformString(String s){
        String str = "$#";
        for(int i=0; i<s.length(); i++){
            str = str.concat(s.charAt(i)+"#");
        }
        str = str+"@";
        char[] ch = str.toCharArray();
        return ch;
    }

    public static void main(String args[]){
        String text = "aaabbasdaa";
        String str = getPalindrom(text);
        System.out.println(str);
    }
}
