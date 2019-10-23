package tech.ds.strings;

import tech.util.PrintUtil;

/**
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * O(m+n)
 */
public class KMPSubstringSearch {

    public static boolean findPatternInText(String text, String pattern){
        int[] lps = getLPS(pattern);

        int i = 0, j =0;
        while (i < text.length()){

            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if (j == pattern.length()){
                System.out.println("Pattern found at index: " + (i - j));
                return true;
            }
            else if (text.charAt(i) != pattern.charAt(j)){
                if (j >= 1){
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }

        return false;
    }


    public static int[] getLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int j = 0, i = 1;

        lps[0] = 0;

        while (i < pattern.length()) {

            if (pattern.charAt(j) == pattern.charAt(i)){
                lps[i] = j+1;
                j++;
                i++;
            }else {
                if (j >=1){
                    j = lps[j-1];
                }else {
                    lps[i] = j;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String args[]){
        String text = "aabcaabaaacaabaabaabaaaacabaaaacabaabcaaa;";
        String pattern = "aabaabaaa";
        int[] lps = getLPS(pattern);
        PrintUtil.printArray("LPS:", lps);

        boolean patternInText = findPatternInText(text, pattern);
        System.out.print("Found: " + patternInText);
    }

}
