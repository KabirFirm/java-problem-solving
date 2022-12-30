package com.egeneration;

import java.util.*;

import static java.lang.Math.abs;

public class Playground {
    // cyclicRotation
    public static int[] cyclicRotation(int[] A, int K) {
        if(A.length < 2 || K == 0)  return A;
        for(int i = 0; i < K; i++) {
            int temp = A[A.length - 1];
            for(int j = A.length - 1; j >0; j--){
                A[j] = A[j-1];
            }
            A[0] = temp;
        }
        return A;
    }

    // OddOccurrenceInArray

    public static int oddOccurrenceInArray(int[] A) {
        HashMap<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(occuranceMap.containsKey(A[i])) {
                int occurance = occuranceMap.get(A[i]);
                occurance++;
                occuranceMap.put(A[i],occurance);
            }else {
                occuranceMap.put(A[i],1);
            }
        }
        for(Object keySet : occuranceMap.keySet()){
            int occurances = occuranceMap.get(keySet);
            if(occurances % 2 != 0) return (int) keySet;
        }
        return 0;
        //throw new RuntimeException("you must get this");
    }


    // Selection sort

    public static int indexOfMinimum(int[] inputArray, int startIndex) {
        int minIndex = startIndex;
        int minValue = inputArray[startIndex];
        for(int i = startIndex + 1; i < inputArray.length; i++) {
            if(inputArray[i] < minValue) {
                minIndex = i;
                minValue = inputArray[minIndex];
            }
        }
        return minIndex;
    }

    public static int[] swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
        return inputArray;
    }

    public static void selectionSort(int[] inputArray) {
        int minValue = inputArray[0];
        int minIndex = 0;
        for(int i = 0; i < inputArray.length; i++) {
            minIndex = indexOfMinimum(inputArray,i);
            if(minIndex > i) {
                inputArray = swap(inputArray,i,minIndex);
            }
        }
        System.out.println(Arrays.toString(inputArray));
    }

    // FrogJmp
    public static int frogJump(int X, int Y, int D) {

        /*
        // this also works but score = 11%. what a shame !
        int minimalNumberOfJumps = 0;
        int distanceCovered = X;
        while (distanceCovered <= Y) {
            minimalNumberOfJumps++;
            distanceCovered += D;
        }
        return minimalNumberOfJumps;*/
        return (int) Math.ceil((double)( Y - X ) / D );

    }

    // PermMissingElem

    public static int permMissingElem(int[] A) {
        long length = A.length + 1;

        long sumOfAllElement = length * (length + 1) /2;
        long sum = 0L;
        for(int i: A){
            sum += i;
        }

        return (int) (sumOfAllElement - sum);
    }

    public static int tapeEquilibrium(int[] A) {
        long sumOfAllElement = 0L;
        for(int i: A) {
            sumOfAllElement += i;
        }

        int minDifference = Integer.MAX_VALUE;
        int currentDifference = Integer.MAX_VALUE;
        long sumOfFirstPart = 0L;

        for(int i = 0; i < A.length - 1; i++){
            sumOfFirstPart += A[i];
            long sumOfSecondPart = sumOfAllElement - sumOfFirstPart;
            currentDifference = (int) abs(sumOfFirstPart - sumOfSecondPart);
            minDifference = Math.min(minDifference, currentDifference);
        }

        return minDifference;
    }

    public static int frogRiverOne(int X, int[] A) {
        HashSet<Integer> currentNumbers = new HashSet<Integer>();
        HashSet<Integer> requiredNumbers = new HashSet<Integer>();

        for(int j = 1; j <= X; j++) {
            requiredNumbers.add(j);
        }
        for (int i = 0; i < A.length; i++) {
            currentNumbers.add(A[i]);
            if(currentNumbers.size() < requiredNumbers.size()) continue;
            if(currentNumbers.containsAll(requiredNumbers)){
                return i;
            }
        }
        return -1;
    }

    public static int permCheck(int[] A) {
        int isPermutation = 0;
        HashSet<Integer> requiredNumbers = new HashSet<Integer>();
        HashSet<Integer> currentNumbers = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            currentNumbers.add(A[i]);
            requiredNumbers.add(i+1);
        }
        if(currentNumbers.containsAll(requiredNumbers)) {
            isPermutation = 1;
        }


        return isPermutation;
    }

    public static int[] maxCounters(int N, int[]A) {
        int[] resultArray = new int[N];
        int maximumValue = 0;
        int lastResetCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] <= N){
                if(resultArray[A[i]-1] < lastResetCounter) {
                    resultArray[A[i]-1] = lastResetCounter;
                }
                resultArray[A[i] - 1]++;
                if(resultArray[A[i] - 1] > maximumValue) maximumValue = resultArray[A[i] - 1];
                System.out.println("resultArray = " + Arrays.toString(resultArray) + " maximumValue = " + maximumValue);
            }else {
                lastResetCounter = maximumValue;
                System.out.println("lastResetCounter = " + lastResetCounter);
            }

        }
        for(int i = 0; i < N; i++) {
            if(resultArray[i] < lastResetCounter) {
                resultArray[i] = lastResetCounter;
            }
        }
        return resultArray;
    }

    public static int[] insertionSort(int array[]) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int value = array[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > value) {
                    int temp = array[j];
                    array[j] = value;
                    array[index] = temp;
                    index = j;
                }
            }
        }
        return array;
    }

    public static void twoDArray(int[][] A) {
        int length = A[0].length;
        // iterate each row of the array
        for (int i = 0; i < A.length; i++) {
            // iterate each column of a specific row
            for (int j = 0; j < length; j++) {
                System.out.print(A[i][j]); // print each item
                if(j == length - 1) { // each item of a row print already
                    // go to diagonal down
                    for (int k = i+1; k < A.length; k++) {
                        System.out.print(A[k][j]);
                    }
                }
            }
            length--;
        }
    }


    public static int factorial(int number) {
        int result = 1;

        if( number == 0){
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            // Removing first and last character
            // of a string using substring() method
            str = str.substring(1, str.length() - 1);
            isPalindrome(str);
        }else {
            return false;
        }
        return true; // already return result.this line will be never executed
    }

    public static int missingInteger(int[] A) {

        HashSet<Integer> singleOccurance = new HashSet<Integer>();
        for(int i =0 ; i < A.length; i++) {
            if(A[i] > 0) singleOccurance.add(A[i]);
        }
        int missingElement = 1;

        for (int i = 1; i <= singleOccurance.size(); i++){
            if (singleOccurance.contains(missingElement)) missingElement++;
            else return missingElement;
        }

        /*
        // Score - 33%, correctness- 40%,performance - 25%
        int singleOccuranceLength = singleOccurance.size();
        double allNumberSum = 0d;
        allNumberSum = ((singleOccuranceLength + 1) * (singleOccuranceLength + 2)) / 2;
        double actualSum = 0d;
        for(int obj: singleOccurance){
            actualSum+= obj;
        }

        return (int)(allNumberSum - actualSum);*/

        return missingElement;
    }

    public static int countDiv(int A, int B, int K) {
        // Add 1 explicitly as A is divisible by M
        if(A % K == 0) {
            return (B/K) - (A/K) + 1;
        }
        // A is not divisible by M
        return (B/K) - (A/K);
    }

    public static double powRecursiveA(int x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 1 / powRecursiveA(x,abs(n));
        }
        return x * powRecursiveA(x, n - 1);
    }

    public static double powRecursiveB(int x, int n) {
        // https://www.khanacademy.org/computing/computer-science/algorithms/recursive-algorithms/a/computing-powers-of-a-number
        if(n == 0) {
            return 1;
        }
        if(n > 0) {
            if( n % 2 == 0){
                double half = powRecursiveB(x, n / 2);
                return half * half;
            }else {
                return x * powRecursiveB(x, n - 1);
            }

        }else {
            return 1 / powRecursiveB(x, abs(n));
        }
    }

    public static int minAvgTwoSlice(int [] A) {
        double average1 = Double.MAX_VALUE;
        double average2 = Double.MAX_VALUE;
        double average3 = Double.MAX_VALUE;
        double minimumAverage = Double.MAX_VALUE;
        int sum1, sum2, sum3;
        int minimumIndex = 0; // this is always true for two element of array

        for (int i = 0; i < A.length - 2; i++) {

            // two consecutive numbers
            sum1 = A[i] + A[i+1];
            average1 = sum1 / 2.0d;

            //check minimumAverage
            if(minimumAverage > average1) {
                minimumAverage = average1;
                minimumIndex = i;
            }
            // three consecutive numbers
            sum2 = sum1 + A[i+2];
            average2 = sum2 / 3.0d;

            //check minimumAverage
            if(minimumAverage > average2) {
                minimumAverage = average2;
                minimumIndex = i;
            }
        }

        sum3 = A[A.length - 2] + A[A.length -1];
        average3 = sum3 / 2.0d;

        //check minimumAverage
        if(minimumAverage > average3) {
            minimumIndex = A.length - 2;
        }

        return minimumIndex;
    }

    public static void main(String[] args) {

        /*
        // cyclicRotation function section
        int[] inputArray = {3,8,9,0};
        int numberOfShift = 2;
        System.out.println(Arrays.toString(cyclicRotation(inputArray,numberOfShift)));
        */

        /*
        // oddOccurrenceInArray function section
        int[] inputArray = {1000000, 1000000, 1000000, 2000000, 1000000, 30000000, 5000000, 2000000, 30000000};
        System.out.println(oddOccurrenceInArray(inputArray));
        */

        /*
        // Selection sort
        int[] inputArray = {22, 11, 99, 88, 9, 7, 42};
        selectionSort(inputArray);
        */

        /*
        // FrogJmp
        int startingPoint = 10;
        int endingPoint = 85;
        int singleJumpDistance = 30;
        System.out.println(frogJump(startingPoint,endingPoint,singleJumpDistance));
        */

        /*
        // PermMissingElem
        System.out.println(permMissingElem(new int[] {2,3,1,5}));
        */

        /*// tapeEquilibrium
        System.out.println(tapeEquilibrium(new int[] {3,1,2,4,3}));*/

        /*// frogRiverOne
        System.out.println(frogRiverOne(5,new int[] {1,4,3,3,6,9,7,4,8,1,5}));*/

        /*// frogRiverOne
        System.out.println(permCheck(new int[] {2,3,4,1,3}));*/

        /*// maxCounters
        System.out.println(Arrays.toString(maxCounters(5,new int[] {3,4,4,6,1,4,4})));*/

        /*// insertion sort from Mahua apa
        int array[] = {9, 10, 3, 2, 3, 5, 1, 7, 9};
        array = insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

        /*// 2D array
        int[][] myNumbers = { {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5} };
        twoDArray(myNumbers);*/

        /*// factorial, recursion
        System.out.println(factorial(4));*/

        /*// palindrome
        System.out.println(isPalindrome("RR"));*/

        /*// missingInteger
        System.out.println(missingInteger(new int[] {-1,-3}));*/

        //countDiv
        System.out.println(countDiv(6,11,3));
        // power recursive
        // Algorithm A is O(n) while Algorithm B is, in fact, O( log(n) ).
        //This makes a big difference if n is large.

        /*A method:
        x^8= x^7 * x (need to find x^7)
        x^7= x^6 * x (need to find x^6)
        x^6= x^5 * x (need to find x^5)
        x^5= x^4 * x (need to find x^4)
        x^4= x^3 * x (need to find x^3)
        x^3= x^2 * x (need to find x^2)
        x^2= x^1 * x (need to find x^1)
        x^1= x^0 * x (need to find x^0)
        x^0 = 1

        B method:
        x^8= x^4 * x^4 (need to find x^4)
        x^4= x^2 * x^2 (need to find x^2)
        x^2= x^1 * x^1 (need to find x^1)
        x^1= x^0 * x (need to find x^0)
        x^0 = 1*/
        System.out.println(powRecursiveA(2,0));
        System.out.println(powRecursiveB(2,0));
    }
}
