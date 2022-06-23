package com.egeneration;

/*
A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1).
Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river
from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river
is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
 */

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    //Find the earliest time when a frog can jump to the other side of a river.

    public static int solution(int X, int[] A) {

        /*// correctness = 50%, performance = 0%, score = 27%
        int nextFind = 1, foundIndex = 0;
        int i;
        for(i =0; i < A.length; i++){
            //System.out.println("i er value = " + i + ", searching = " + nextFind);
            if(nextFind == A[i] && nextFind == X){
                foundIndex = i;
                break;
            }
            if(nextFind == A[i] && nextFind != X){
                nextFind++;
                i = -1;
            }
            if( i == A.length - 1){
                foundIndex = -1;
            }
        }
        return foundIndex;*/

        Set requiredLeavesSet = new HashSet();
        for(int i=1; i<=X; i++) {
            requiredLeavesSet.add(i);
        }

        Set currentLeavesSet = new HashSet();

        for(int p = 0; p < A.length; p++) {
            currentLeavesSet.add(A[p]);
            //keep adding to current leaves set until it's at least the same size as required leaves set
            if(currentLeavesSet.size() < requiredLeavesSet.size()) continue;

            if(currentLeavesSet.containsAll(requiredLeavesSet)) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, new int[]{7,5,2,5,3,2,4,6,2,8}));
    }
}
