package tech.dsa.bit;

public class BitProblems {
    public static void main(String[] args) {
//        countBits(12);
//        getFirstSetBitPosition(18);
//        getFirstDifferentBitPosition(11, 9);
        flipBitsInRange(17 ,2 ,3);
    }

    public static void flipBitsInRange(int n, int l, int r){
        System.out.println(Integer.toBinaryString(n));
        int numberOfWidth = countBits(n);

        int inverse = n ^ (getAllSetBit(numberOfWidth));
        int mask = getAllSetBit(r-l+1);
        mask = mask << (numberOfWidth-r);
        mask = mask | inverse;
        System.out.println(Integer.toBinaryString(mask));

        System.out.println(n ^ mask);
    }

    public static int getAllSetBit(int width){
        int mask = 1;
        for (int i=0; i<width ; i++){
            mask = mask | (1 << i);
        }
        return mask;
    }

    public static int getFirstSetBitPosition(int n){
        int countBits = countBits(n);
        for (int i = 0; i<= countBits; i++){
            int temp = (int) Math.pow(2, i);
            if ((temp & n) == temp){
                System.out.println("First Set Bit: "+(i+1));
                return (i+1);
            }
        }
        return -1;
    }

    public static int countBits(int n){
        int count  = 0;
        while (n != 0){
            n = n>>1;
            count++;
        }
        return count;
    }

    public static int getFirstDifferentBitPosition(int a, int b){
        int max = Math.max(countBits(a), countBits(b));
        for (int i=0; i<=max; i++){
            int posMask = 1 << i;
            if (((a & posMask) ^ (b & posMask)) != 0){
                System.out.println(i+1);
                return i+1;
            }
        }
        return -1;
    }
}
