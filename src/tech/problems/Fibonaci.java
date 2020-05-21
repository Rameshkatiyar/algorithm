package tech.problems;

public class Fibonaci {
    public static int fib(int n){
        //Exit Condition
        if(n == 0)
            return 0;
        if (n == 1)
            return 1;

        //Call with Logic + Return
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Fib: "+fib(6));
    }
}
