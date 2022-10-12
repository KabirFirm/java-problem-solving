package com.egeneration;

/*     A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

        For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains
        two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15
        has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

        Write a function:
        class Solution { public int solution(int N); }

        that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

        For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
        Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

        sample input = 1041, 15, 32, 6291457, 74901729, 1610612737

        */

public class BinaryGap {
    public static int solution(int N){
        int binaryGap = 0, tempCount = 0;
        int startIndex = -1;

        // convert integer to binary String
        String binary = Integer.toBinaryString(N);

        // check every character of binary string
        for (int i = 0; i < binary.length(); i++){
            // if binary character is 1
            if(binary.charAt(i) == '1'){
                // set binaryGap value if tempCount is greater than ( 0 and binaryGap)
                if(tempCount > 0 && binaryGap < tempCount){
                    binaryGap = tempCount;
                }
                // reset tempCount to 0 and startIndex to binary string index
                tempCount = 0;
                startIndex = i;

            }else { // if binary character is 0
                // if there is 1 before this 0 then increase tempCount
                if(startIndex >=0){
                    tempCount += 1;
                }
            }
        }

        return binaryGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(1376796946));
    }
}
