package com.egeneration;

// Calculate the values of counters after applying all alternating operations: increase counter by 1;
// set value of all counters to current maximum.

/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */

import java.util.Arrays;
import java.util.HashMap;

public class MaxCounters {

    public static int[] solution(int N, int[] A){

        /*// correctness = 100%, performance = 20%, score = 55%
        int[] result = new int[N]; // create and initiate result array of length N and initial value 0
        HashMap <Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>(); //hash map to set unique number and store max value

        // find unique number from given array A, and set each unique number's max value to 0(zero)
        for (int i = 0; i < A.length; i++){
            if(A[i] <= N) occurrencesMap.put(A[i], 0); //set max counter for i element
        }

        int globalMax = 0; // set globalMax value to 0

        for (int i = 0; i < A.length; i++) {
            int tempValue = A[i];
            // if number of i index is less than or equal to N
            if(A[i] <= N){
                // get this individual number's max value
                int maxNumber = occurrencesMap.get(A[i]);
                maxNumber++; // increment individual number's value by 1

                //update globalMax
                if(globalMax < maxNumber) globalMax = maxNumber;

                // store max number for each individual number
                occurrencesMap.put(A[i],maxNumber);

                result[tempValue - 1] = maxNumber;
            }else if(A[i] == N + 1){ // if number of i index is equal to N + 1

                // set entire result array to max value
                for (int j = 0; j < N; j++){
                    result[j] = globalMax;
                }
                //set each unique number max value to global Max
                for (int num: occurrencesMap.keySet()) {
                    occurrencesMap.put(num,globalMax);
                }
            }
        }
        return result;*/
        int [] counters = new int[N];

        int maxCounter = 0; //for the next re-set will know what high score to set all values
        int lastResetCounter = 0; //for setting values that were never explicitly set - at the end

        for(int i = 0; i < A.length; i++) {
            if(A[i] <= N) {
                if(counters[A[i]-1] < lastResetCounter) {
                    counters[A[i]-1] = lastResetCounter;
                }
                //bring it up to last reset value
                counters[A[i]-1]++;

                // store max counter in case need to set all counters to this value on next reset
                if(counters[A[i]-1] > maxCounter) {
                    maxCounter = counters[A[i]-1];
                }
            } else {
                //keep track of last reset counter
                lastResetCounter = maxCounter;
            }
        }

        //set all values to last reset value that was never explicitly changed after last reset
        for(int i=0; i<counters.length; i++) {
            if(counters[i] < lastResetCounter) {
                counters[i]  = lastResetCounter;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {3,4,4,6,1,4,4})));
    }
}
