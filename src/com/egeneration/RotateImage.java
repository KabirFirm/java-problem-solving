package com.egeneration;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int a =0;
        int length = (matrix.length * matrix.length);
        int[] temp = new int[length];
        for(int i = matrix.length-1; i >= 0; i--){
            for(int j = 0; j < matrix.length; j++){
                temp[a] = matrix[i][j];
                //System.out.println("dealing with " + temp[a] + " index = " + j + " " + a);
                a++;
            }
        }
        a = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[j][i] = temp[a];
                //System.out.println("dealing with " + temp[a] + " index = " + j + " " + a);
                a++;
            }
        }
        /*System.out.println(Arrays.toString(temp));
        System.out.println(temp[0]);
        System.out.println(temp[8]);*/

        System.out.println(Arrays.deepToString(matrix)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(input)
                .replace("],","\n").replace(",","\t| ")
                .replaceAll("[\\[\\]]", " "));
        System.out.println("output\n");
        rotate(input);
    }
}
