package com.egeneration;

import java.util.Arrays;


public class MergeSort {

    public static void merge(int[] array, int p, int q, int r) {

        // Find sizes of two subarrays to be merged
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] lowHalf = new int[n1];
        int[] highHalf = new int[n2];

        int i = 0 ,j = 0;
        int k = p; // initially, k is set to p
        // insert elements into lowHalf
        for(i = 0; k <= q; i++,k++) {
            lowHalf[i] = array[k];
        }
        // insert elements into highHalf
        for(j = 0; k <= r; j++,k++) {
            highHalf[j] = array[k];
        }

        k = p;
        i = 0;
        j = 0;
        // repeatedly choose lowest untaken element from lowHalf or highHalf which one is really small
        while(i < lowHalf.length && j < highHalf.length) {
            if(lowHalf[i] <= highHalf[j]) {
                array[k++] = lowHalf[i++];
            }else {
                array[k++] = highHalf[j++];
            }
        }

        // if any of lowHalf or highHalf array is empty, then copy remaining elements from lowHalf/highHalf to array

        while(i < lowHalf.length) {
            array[k++] = lowHalf[i++];
        }

        while (j < highHalf.length) {
            array[k++] = highHalf[j++];
        }
    }

    public static int[] mergeSort(int[] array, int p, int r) {
        if(p < r) {
            int q = (r + p) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q+1, r);
            merge(array, p, q, r);
        }

        return array;
    }


    public static void main(String[] args) {
        int[] array = {12,3,4,-1,0,-2,2,1};
        System.out.println(Arrays.toString(mergeSort(array,0,7)));
    }
}
