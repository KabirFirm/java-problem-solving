package com.egeneration;
import java.util.Arrays;

// Time complexity - O(n*n)

public class SelectionSort {
    public static  int indexOfMinimum(int[] array, int startIndex) {
        int minValue = array[startIndex];
        int minIndex = startIndex;
        for (int i = startIndex; i < array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int[] swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minIndex = indexOfMinimum(array, i);
            if(minIndex > i) {
                array = swap(array,i,minIndex);
            }

        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {22, 11, 99, 88, 9, 7, 42, -3, 0};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
