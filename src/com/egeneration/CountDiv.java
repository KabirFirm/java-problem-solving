package com.egeneration;

// Compute number of integers divisible by k in range [a..b].

/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
 */

public class CountDiv {

    public static int solution(int A, int B, int K) {
        /*// correctness - 100%, performance - 0%, score - 50%
        int countNumber = 0;
        for (int i = A; i <= B; i++){
            if(i % K == 0) countNumber++;
        }

        return countNumber;*/

        int divisors = 0;

        //nothing to do when K > B
        if(K > B) {
            if(A == 0 || B == 0) {
                return 1; //K mod 0 == 0 so count a single divisor
            }
            return 0; //no divisors when A, B both != 0
        }

        if(A == 0) {
            divisors++;  //K mod 0 == 0
        }

        int updatedA = A;
        if(K > A) {
            updatedA = K; //skip checking all values < K
        }

        int firstNonZeroDivisor = 0;
        int lastNonZeroDivisor = 0;

        for(int i=updatedA; i<=B; i++) {
            if(i % K == 0) {
                firstNonZeroDivisor = i;
                break;
            }
        }
        for(int i=B; i>=updatedA; i--) {
            if(i % K == 0) {
                lastNonZeroDivisor = i;
                break;
            }
        }
        if(firstNonZeroDivisor == 0 && lastNonZeroDivisor == 0) {
            divisors = 0;
        }
        else {
            divisors += ((lastNonZeroDivisor - firstNonZeroDivisor) / K) + 1;
        }

        return divisors;
    }

    public static void main(String[] args){
        System.out.println(solution(0,10,3));
    }
}
