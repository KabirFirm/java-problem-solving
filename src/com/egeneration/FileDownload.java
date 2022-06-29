package com.egeneration;

public class FileDownload {
    public static void main(String args[]) {
        System.out.println(soln(100, new int []{10, 6,6,8}, 2) );
    }
    public static int soln(int X, int B[], int Z) {
        int rem = X;
        for (int size : B) {
            rem -= size;
        }
        int sum = 0;
        for (int i = 0; i < Z; i++ ) {
            sum += B[B.length-1-i];
        }

        int avg = sum / Z;

        return rem / avg;

    }
}
