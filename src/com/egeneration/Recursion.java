package com.egeneration;

public class Recursion {
    // iterative factorial
    public static int IterativeFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    // recursive factorial
    public static int RecursiveFactorial(int n) {
        // base case
        if(n == 0){
            return 1;
        }
        // recursive case
        return n * RecursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 4;
        //System.out.println(IterativeFactorial(number));
        System.out.println(RecursiveFactorial(number));
    }
}
