package com.egeneration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Set;

public class OddOccurrenceInArray {

    public static int solution(int[] A) {

        /*

        // this solution fails on performance test

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

        int temp = list.get(0);
        boolean notFound = false;
        for(int i = 0; i < list.size(); i++){
            System.out.println("outer loop, temp = " + list.get(0) + ", i = " + i);
            temp = list.get(0);
            for(int j = i + 1; j < list.size(); j++){
                System.out.println("j = " + j + " temp = " + temp + " dealing with = " + list.get(j));
                if(list.get(i).equals(list.get(j)) ) {
                    list.remove(j);
                    list.remove(0);
                    i--;
                    System.out.println("complete removing = " + list);
                    break;
                }
                if(j == list.size() - 1){
                    System.out.println("not found");
                    notFound = true;
                    break;
                }
            }
            if(notFound) break;
            if(list.size() == 1) break;
        }
        if(list.size() == 1){
            return list.get(0);
        }else {
            return temp;
        }*/

        HashMap <Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();

        for(int i=0; i<A.length; i++) {
            if(occurrencesMap.containsKey(A[i])) {
                int occurrences = occurrencesMap.get(A[i]);
                occurrences++;
                occurrencesMap.put(A[i], occurrences); //increment occurrence counter and store it
            }
            else {
                occurrencesMap.put(A[i], 1); //1st occurrences of this value
            }
        }

        System.out.println(occurrencesMap);

        Set keySet = occurrencesMap.keySet();

        for(Object currentKey : keySet) {
            int occurrences = occurrencesMap.get(currentKey);

            //if occurs odd number of times, we found the unpaired value - no need to continue checking
            if(occurrences % 2 != 0) return (int) currentKey;
        }
        //should never get to here
        throw new RuntimeException("shouldn't get to here - should've return unpaired value by now");
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1000000, 1000000, 1000000, 2000000, 1000000, 30000000, 5000000, 2000000, 30000000}));
    }
}
