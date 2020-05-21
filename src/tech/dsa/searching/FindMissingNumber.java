package tech.dsa.searching;

/**
     * Finding the Missing Number: We are given a list of n – 1 integers and these
     * integers are in the range of 1 to n. There are no duplicates in the list. One of the integers is
     * missing in the list. Given an algorithm to find the missing integer.
     */
    public class FindMissingNumber {

        //Using here xor operation.
        public static void find(int[] a, int n){
            int array_xor = a[0];

            for(int i = 1; i < a.length; i++){
                int num = a[i];
                array_xor = (array_xor ^ num);
            }

            int n_xor = 1;
            for(int i = 2; i <= n; i++){
                n_xor = (n_xor ^ i);
            }

            System.out.println("Missing Number: "+ (array_xor ^ n_xor));
        }

    public static void main(String args[]){
        int[] a = {1,2,3,4,5,7,8};
        //4 is missing here.
        find(a, 8);
        // n+n complexity.
    }
}
