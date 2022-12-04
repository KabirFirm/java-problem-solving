package com.egeneration;

/*
Array -> 2,3,5,7,11,13,17,19 === total element 8, so n= 8; target = 10
        step 1: min = 0, max = 7, guess = (7+0)/2 = 3,Array[3] = 7 < 10
        step 2: min = guess + 1 = 4, max = 7, guess = (7+4)/2 = 5, Array[5]=13 > 10
        step 3: min = 4, max = guess -1 = 4, guess = (4+4)/2 = 4, Array[4]=11 > 10
        step 4: min = 4, max = guess - 1 = 3; breaks
        */

import static java.lang.Math.floor;

public class BinarySearch {

    public static int solution(int[] array, int target) {
        int min = 0, max = array.length - 1;
        int guess;
        int count = 0;
        while (min <= max) {
            count++;
            System.out.println("count =" + count);
            guess = (int) (min + max) /2;
            if(array[guess] == target) return guess;
            else if(array[guess] < target){
                min = guess + 1;
            }else {
                max = guess - 1;
            }
        }
        return -1;
    }

/*    public static void pyramid(int n) {
        for(int i = n; i >0; i --){
            for( int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 2 * i; k > 0; k--){
                System.out.print("*");
            }
            System.out.println("");

        }
    }*/


    public static void main(String[] args) {
        int[] array = {2, 3, 5, 7, 11, 13, 17, 19};
        int target = 10;
        System.out.println(solution(array, target));
        //pyramid(10);

    }
}
