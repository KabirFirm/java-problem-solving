package com.egeneration;

import java.util.HashSet;

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
