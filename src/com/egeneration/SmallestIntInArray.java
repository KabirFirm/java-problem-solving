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

package com.egeneration;
import java.util.Arrays;
public class SmallestIntInArray {

    public static int solution(int[] A){
        Arrays.sort(A);
        int smallestInt = 1;
        for(int i = 0; i < A.length; i++) {
            if (A[i] > 0 && smallestInt < A[i]) {
                return smallestInt;
            }else if(A[i]==smallestInt){
                ++smallestInt;
            }
        }
        return smallestInt;

        /*int smallestInt = 1;
        List<Integer> arrayElementsList = Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int i = 1; i <= 1000000; i++){
            System.out.println("i value outside = " + i);
            if(arrayElementsList.contains(i) == false){
                System.out.println("i value = " + i);
                smallestInt = i;
                break;
            }
        }
        return smallestInt;*/
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,-1}));
    }
}
