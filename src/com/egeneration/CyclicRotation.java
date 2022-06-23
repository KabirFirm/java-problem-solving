package com.egeneration;

import java.util.Arrays;

/*
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index,
and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
(elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:
class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
*/

public class CyclicRotation {

    public static int[] solution(int[] A, int K){
        // if given array contains no element or only one element, just return same array.
        if(A.length <= 1) return A;

        // temp to store last element of given array
        int temp = 0;
        // how many shifting required
        for(int i = 0; i < K; i++){
            // rotate array from last element and decrease
            for(int j = A.length - 1; j > 0; j--){
                // assign last element to temp
                if(j == A.length - 1) {
                    temp = A[j];
                }
                // assign a element to next index.
                A[j] = A[j-1];
            }
            // assign temp to first element of given array
            A[0] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        /*int[] result = solution(new int[]{1, 2, 3, 4},2);
        for (int a: result
             ) {
            System.out.println(a);
        }*/
        System.out.println(Arrays.toString(solution(new int[]{1},2)));
    }
}
