    package com.ctci.arraysAndStrings;

    public class ZeroMatrix {

        public void setZeroes(int[][] matrix) {

            boolean firstRowHasZero = false;
            int n = matrix.length;
            int m = matrix[0].length;

            for (int j=0; j< matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    firstRowHasZero = true;
                }
            }

            //if any row has 0, mark the top row as zero - this nis to mark the columns
            for(int i=0; i<matrix.length; i++) {
                for (int j=0; j< matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                    }
                }
            }

            // for each subsequent rows, check if any value in the row has a zero
            for(int i = 1; i<n ;i++){

                boolean rowHasZero = false;
                for(int j = 0; j<m; j++){
                    if(matrix[i][j] == 0){
                        rowHasZero = true;
                    }
                }

                for(int j = 0; j<m; j++){
                    if(rowHasZero || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }

            if(firstRowHasZero){
                for(int j = 0; j<m ;j++){
                    matrix[0][j] = 0;
                }
            }
        }
    }
