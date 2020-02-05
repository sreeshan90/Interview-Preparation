package com.epi.warmup;

public class MatrixSymmentry {
    public static void main(String[] args) {

        int[][] arr = {{1,1,1},{1,1,1},{1,0,0}};
        boolean flag = true;
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                if(arr[i][j] != arr[j][i]){
                    flag = false;
                }
            }
        }

        System.out.println(flag);
    }
}
