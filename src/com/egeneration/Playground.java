package com.egeneration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Playground {

    // cyclicRotation
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

    // OddOccurrenceInArray

    public static int oddOccurrenceInArray(int[] A) {
        HashMap<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(occuranceMap.containsKey(A[i])) {
                int occurance = occuranceMap.get(A[i]);
                occurance++;
                occuranceMap.put(A[i],occurance);
            }else {
                occuranceMap.put(A[i],1);
            }
        }
        for(Object keySet : occuranceMap.keySet()){
            int occurances = occuranceMap.get(keySet);
            if(occurances % 2 != 0) return (int) keySet;
        }
        return 0;
        //throw new RuntimeException("you must get this");
    }


    public static void main(String[] args) {

        /*
        // cyclicRotation function section
        int[] inputArray = {3,8,9,0};
        int numberOfShift = 2;
        System.out.println(Arrays.toString(cyclicRotation(inputArray,numberOfShift)));
        */

        // oddOccurrenceInArray function section
        int[] inputArray = {1000000, 1000000, 1000000, 2000000, 1000000, 30000000, 5000000, 2000000, 30000000};
        System.out.println(oddOccurrenceInArray(inputArray));
    }
}
