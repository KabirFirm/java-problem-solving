package com.egeneration;

// Find the missing element in a given permutation.

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

- N is an integer within the range [0..100,000];
- the elements of A are all distinct;
- each element of array A is an integer within the range [1..(N + 1)].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PermMissingElem {

    public static int solution(int[] A) {
       /* //converting array to list
        ArrayList<Integer> list = new ArrayList<Integer>();
        //Collections.addAll(list, A);
        for (int number: A){
            list.add(number);
        }
        //ArrayList<Integer> list = Arrays.asList(A);
        //System.out.println(list);
        for (int i =1; i<= A.length + 1; i++){
            System.out.println("i = " + i);
            if(list.contains(i) == false){
                System.out.println("not found i = " + i);
                return i;
            }
        }

        return 0; */
        // sum of 1,2,3,....n is => (n * (n + 1)) / 2;
        long length = A.length + 1;
        long sumOfAllElements = (length * (length + 1)) / 2;

        long sum = 0L;

        for (int i: A){
            sum += i; // sum of elements present in Array
        }
        return (int) (sumOfAllElements - sum);
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1,2,4}));
    }
}
