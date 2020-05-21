package tech.dsa.bit;

public class BitOperationTest {
    public static void main(String[] args) {
        oneAndTwoSComplement();
//        xorOperation();
//        leftShift();
//        rightShift();
//        andOperation();
//        orOperation();
    }


    /**
     * one's complement = Invert the each bits
     * ~n = - (n+1)
     *
     * two's complement = one's complement + 1
     *  = (-(n+1))+1
     *
     * Application: Two's complement use to store the negative number in memory.
     */
    public static void oneAndTwoSComplement(){
        int n = 0;
        System.out.println(n);

        int oneS = ~n;
        System.out.println(oneS);

        int twoS = oneS+1;
        System.out.println(twoS);

    }

    /**
     * For different bits, its 1 and for same bits its 0
     *
     * Application: Use for encryption
     */
    public static void xorOperation(){
        int n = 2, m = 3;
        System.out.println(n^m);

        //Encryption
        int key = 555;
        int msg = 12345;

        int cipher = msg ^ key;
        System.out.println("Encryption: "+ cipher);

        int plain = cipher ^ key;
        System.out.println("Plain: "+ plain);
    }

    /**
     * If we shift bit with k position then it's multiply with 2^k.
     *
     *  n << k = n * (2^k)
     */
    public static void leftShift(){
        int n = 5;

        System.out.println(n);
        System.out.println(n<<1);
        System.out.println(n<<2);
        System.out.println(n<<3);
    }

    /**
     * If we shift bit with k position then it's divide with 2^k.
     *
     *  n << k = n / (2^k)
     */
    public static void rightShift(){
        int n = 10;

        System.out.println(n);
        System.out.println(n>>1);
        System.out.println(n>>2);
        System.out.println(n>>3);
        System.out.println(n>>4);
    }

    /**
     * Application: Make the bit as 1 in any position using masks.
     * Example:
     * value: 0000 here If we want to make second bit as 1.
     * mask: 0010
     *
     * Or both the value and mask.
     *
     */
    public static void orOperation(){
        int a = 5;
        int b = 6;

        System.out.println(a | b);
    }

    /**
     * Application: To check if any bit is one or not using masks.
     * Example:
     * Value: 0010 here if we want to check the 2nd bit is 1 or not.
     * mask: 0010
     *
     * And both value and mask.
     */
    public static void andOperation(){
        int a = 5;
        int b = 6;

        System.out.println(a & b);
    }
}
