package tech.dsa.strings;

//TODO
public class LongestPalindromSubSequence {
    private static int MAX_LENGHT = 0;

    public static int getLCS(String str1){
        String str2 = str1;

        int[][] a = new int[str2.length()+1][str1.length()+1]; // a[row][column]
        for (int i=0; i<str1.length(); i++){
            a[0][i] = 0;
        }
        for (int i=0; i<str2.length(); i++){
            a[i][0] = 0;
        }

        for (int i=1; i<=str2.length(); i++){//Row
            for (int j=1; j<=str1.length(); j++){//Column
                if (str1.charAt(j-1) == str2.charAt(i-1)){
                    a[i][j] = a[i+1][j-1] + 2;
                    updateMax(a[i][j]);
                }else {
                    a[i][j] = Math.max(a[i][j-1], a[i+1][j]);// This for longest common sub-sequence.
                }
            }
        }

        printArray(str1, str2, a);
        return MAX_LENGHT;
    }

    private static void printArray(String str1, String str2, int[][] a) {
        for (int i=0; i<=str2.length(); i++){
            for (int j=0; j<=str1.length(); j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void updateMax(int a){
        if (MAX_LENGHT < a){
            MAX_LENGHT = a;
        }
    }

    public static void main(String args[]){
        String str = "fabcaf";

        System.out.println("LPS Length: "+getLCS(str));
    }
}
