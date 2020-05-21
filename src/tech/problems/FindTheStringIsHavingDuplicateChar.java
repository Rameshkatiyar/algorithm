package tech.problems;

public class FindTheStringIsHavingDuplicateChar {
    public static void main(String[] args) {
        String str = "abcdea";

        //Logic is that get the bit at single position on 32 bit representation.
        //0001 for a
        //0010 for b
        //And then perform the and operation. It will give 0 at the end for all unique char.
        //LIMIT: char should be between a and z.

        for (int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            int bitDiff = ch - 'a';
            System.out.println(ch +" = "+(int)ch+" = "+bitDiff+" = "+(1 << bitDiff)+" = "+Integer.toBinaryString((1 << bitDiff)));
        }

        System.out.println("Result: "+isDuplicate(str));
    }

    public static boolean isDuplicate(String str){
        int checker = 0;
        for (int i=0; i< str.length(); i++){
           int bitDiff = str.charAt(i) - 'a';
            if ((checker & (1 << bitDiff)) > 0)
                return false;
            checker = checker | 1 << bitDiff;

        }

        return true;
    }
}
