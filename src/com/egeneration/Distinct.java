package com.egeneration;

import java.util.HashSet;

/*
Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

public class Distinct {

    public static int distinct(int[] array) {
        // HashSet stores only distinct number
        HashSet<Integer> temp = new HashSet<Integer>();
        for(int i = 0; i < array.length; i++){
            temp.add(array[i]);
        }
        return temp.size();
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,2,3,4,1,2,3,4,2,7};
        System.out.println(distinct(array));
    }
}
