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


    // Selection sort

    public static int indexOfMinimum(int[] inputArray, int startIndex) {
        int minIndex = startIndex;
        int minValue = inputArray[startIndex];
        for(int i = startIndex + 1; i < inputArray.length; i++) {
            if(inputArray[i] < minValue) {
                minIndex = i;
                minValue = inputArray[minIndex];
            }
        }
        return minIndex;
    }

    public static int[] swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
        return inputArray;
    }

    public static void selectionSort(int[] inputArray) {
        int minValue = inputArray[0];
        int minIndex = 0;
        for(int i = 0; i < inputArray.length; i++) {
            minIndex = indexOfMinimum(inputArray,i);
            inputArray = swap(inputArray,i,minIndex);
        }
        System.out.println(Arrays.toString(inputArray));
    }


    public static void main(String[] args) {

        /*
        // cyclicRotation function section
        int[] inputArray = {3,8,9,0};
        int numberOfShift = 2;
        System.out.println(Arrays.toString(cyclicRotation(inputArray,numberOfShift)));
        */

        /*
        // oddOccurrenceInArray function section
        int[] inputArray = {1000000, 1000000, 1000000, 2000000, 1000000, 30000000, 5000000, 2000000, 30000000};
        System.out.println(oddOccurrenceInArray(inputArray));
        */

        // Selection sort
        int[] inputArray = {22, 11, 99, 88, 9, 7, 42};
        selectionSort(inputArray);
    }
}
