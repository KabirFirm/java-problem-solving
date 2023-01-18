package com.egeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProductOfThree {

    public static int maxProductOfThree(int[] A) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            arrayList.add(A[i]);
        }
        Collections.sort(arrayList);

        // you can use mergesort to sort

        int product1, product2, product3, product4 = 0;
        product1 = arrayList.get(0) * arrayList.get(1) * arrayList.get(3); //first 3 elements
        product2 = arrayList.get(arrayList.size()-3) * arrayList.get(arrayList.size()-2) * arrayList.get(arrayList.size()-1); //last 3 elements
        product3 = arrayList.get(0) * arrayList.get(1) * arrayList.get(arrayList.size()-1); //first 2 and last element
        product4 = arrayList.get(0) * arrayList.get(arrayList.size()-2) * arrayList.get(arrayList.size()-1); //first and last 2 elements

        int max1 = Math.max(product1, product2);
        int max2 = Math.max(product3, product4);

        return Math.max(max1, max2);

    }

    public static int[] mergeSort(int[] array, int p, int r) {
        // recursive merge till array has less than 2 elements
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q); // left side recursive mergeSort
            mergeSort(array, q+1, r); // right side recursive mergeSort
            merge(array, p, q, r); // merge
        }
        return array;
    }

    public static void merge(int[] array, int p, int q, int r) {

        // initialize lowHalf array and highHalf array with content size
        int[] lowHalf = new int[q-p+1]; // p - q + 1, since sometimes p started from 0, which is 1 less than actual;
        int[] highHalf = new int[r-q]; // highHalf size r-q

        int i,j=0;
        int k = p; // initially k set to p
        // copy to lowHalf
        for (i = 0; k <= q; i++,k++) {
            lowHalf[i] = array[k];
        }
        // copy to highHalf
        for (j = 0; k <= r; j++,k++) {
            highHalf[j] = array[k];
        }

        i = j = 0;
        k = p;
        // copy untaken lower value from lowHalf or highHalf which one is really low after comparing to array
        while (i < lowHalf.length && j < highHalf.length) {
            if(lowHalf[i] <= highHalf[j]) {
                array[k++] = lowHalf[i++];
            }else {
                array[k++] = highHalf[j++];
            }
        }
        // if all elements from highHalf was taken to array, so now copy remaining element from lowHalf to array
        while (i < lowHalf.length) {
            array[k++] = lowHalf[i++];
        }

        // if all elements from lowHalf was taken to array, so now copy remaining element from highHalf to array
        while (j < highHalf.length) {
            array[k++] = highHalf[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {-3, 1, -100, 2, -2, 5, 6};
        System.out.println(maxProductOfThree(array));
    }
}
