package com.egeneration;

// Find the smallest positive integer that does not occur in a given sequence

/*

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

import java.util.HashMap;
import java.util.HashSet;

public class MissingInteger {
    public static int solution(int[] A) {
        /*// correctness - 100%, performance - 25%, score - 66%
        int missingElement = 1;

        for (int i = 0; i < A.length; i++){
            if(A[i] == missingElement){
                missingElement++;
                i = - 1;
            }
        }
        return missingElement;*/

        int missingElement =1;

        HashSet<Integer> singleOccurance = new HashSet<Integer>();
        for(int i =0 ; i < A.length; i++) {
            if(A[i] > 0) singleOccurance.add(A[i]);
        }

        for (int i = 1; i <= singleOccurance.size(); i++){
            if (singleOccurance.contains(missingElement)) missingElement++;
            else return missingElement;
        }

        /*HashMap<Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++){
            if(occurrencesMap.containsKey(A[i])){
                int occurrences = occurrencesMap.get(A[i]);
                occurrences++;
                occurrencesMap.put(A[i],occurrences);
            }else {
                occurrencesMap.put(A[i],0);
            }
        }
        for (int i = 0; i < occurrencesMap.size(); i++){
            if(occurrencesMap.containsKey(missingElement)){
                missingElement++;
            }else {
                return missingElement;
            }
        }*/

        return missingElement;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {1,2,3,4,5,6}));
    }
}
