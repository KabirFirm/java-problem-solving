package com.egeneration;
/*
Integer to Roman - https://leetcode.com/problems/integer-to-roman/
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
*/

public class IntToRoman {

    public static String solution(int number) {
        String romanNumerals = "";
        while (number > 0){
            if(number >= 1000){
                romanNumerals += "M";
                number -= 1000;
            }else if(number >= 900) {
                romanNumerals += "CM";
                number -= 900;
            }else if(number >= 500) {
                romanNumerals += "D";
                number -= 500;
            }else if(number >= 400) {
                romanNumerals += "CD";
                number -= 400;
            }else if(number >= 100) {
                romanNumerals += "C";
                number -= 100;
            }else if(number >= 90) {
                romanNumerals += "XC";
                number -= 90;
            }else if(number >= 50) {
                romanNumerals += "L";
                number -= 50;
            } else if(number >= 40) {
                romanNumerals += "XL";
                number -= 40;
            }else if(number >= 10) {
                romanNumerals += "X";
                number -= 10;
            }else if(number >= 9) {
                romanNumerals += "IX";
                number -= 9;
            }else if(number >= 5) {
                romanNumerals += "V";
                number -= 5;
            }else if(number >= 4) {
                romanNumerals += "IV";
                number -= 4;
            }else {
                romanNumerals += "I";
                number -= 1;
            }
        }
        return romanNumerals;
    }

    public static void main(String[] args) {
        int number = 3999;
        System.out.println(solution(number));
    }

    /*
   Runtime: 12 ms, faster than 42.65% of Java online submissions for Integer to Roman.
   Memory Usage: 45.5 MB, less than 56.25% of Java online submissions for Integer to Roman.
 */
}
