package tech.dsa.strings;

/**
 * Dynamic Programming
 *
 * Formula:
 *         if (input1[i] == input2[j]){
 *              T[i][j] = T[i-1][j-1]+1
 *         }else {
 *              T[i][j] = Max(T[i-1][j], T[i][j-1]) //IMP
 *         }
 *
 * Complexity: O(mn) time and space complexity
 *
 * Video:https://www.youtube.com/watch?v=NnD96abizww&t=2s
 */
public class LongestCommonSubSequence {
    public static void main(String args[]){

    }
}
