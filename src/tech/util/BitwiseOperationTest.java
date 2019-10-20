package tech.util;

public class BitwiseOperationTest {
    public static void main(String args[]){
        int a = 10;
        int b = 15;

        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        System.out.println("Binary of a = "+a+": "+a1);
        System.out.println("Binary of b = "+b+": "+b1);

        int xor = a ^ b;
        System.out.println("XOR: "+xor);
        System.out.println("a XOR a: "+ (a ^ a));

        int and = a & b;
        System.out.println("AND: "+and);

        int or = a | b;
        System.out.println("OR: "+or);

        int complement = ~a;
        System.out.println("2's Complement: "+complement);
    }
}
