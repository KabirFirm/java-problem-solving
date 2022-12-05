package com.egeneration;

import java.util.Arrays;

public class Playground {
    public static int[] cyclicRotation(int[] A, int K) {
        if(A.length < 2 || K == 0)  return A;
        for(int i = 0; i < K; i++) {
            int temp = A[A.length - 1];
            for(int j = A.length - 1; j >0; j--){
                A[j] = A[j-1];
            }
            A[0] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] inputArray = {3,8,9,0};
        int numberOfShift = 2;
        System.out.println(Arrays.toString(cyclicRotation(inputArray,numberOfShift)));
    }
}
