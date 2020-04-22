package tech.problems;

public class SubStringProblem {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "for";

        System.out.println(contain(s1, s2));
    }

    /**
     * Complexity = O(m*n)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean contain(String s1, String s2){
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(0)){
                int j;
                int k = i;
                for (j=0; j<s2.length(); j++){
                    if (s2.charAt(j) != s1.charAt(k))
                        break;
                    k++;
                }
                if (j>=s2.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void getLPS(String pattern){
        int i = 1;
        int j = 0;
    }
}
