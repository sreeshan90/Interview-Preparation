package com.ctci.arraysAndStrings;

public class RotateMatrx {
    public void rotate(int[][] matrix) {

        // Take a transpose

        for (int i=0; i<matrix.length; i++) {
            for (int j=i; j<matrix[i].length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row

        for (int i=0; i<matrix.length; i++) {
            int j=0, k=matrix[i].length-1;

            while(j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }

        }
    }
}
