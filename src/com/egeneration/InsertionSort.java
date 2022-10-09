package com.egeneration;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insert(int[] array, int rightIndex, int value) {
        int index = rightIndex + 1;
        for(int i = rightIndex; i >= 0 && array[i] > value; i--) {
            array[i+1] = array[i];
            index = i;
        }
        array[index] = value;
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array = insert(array,i - 1,array[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {0,-2,2,4,5,7,1,8,4};
        //System.out.println(Arrays.toString(insert(array,7,4)));
        System.out.println(Arrays.toString(insertionSort(array)));
    }

}
