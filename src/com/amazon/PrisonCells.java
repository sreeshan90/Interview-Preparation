package com.amazon;

import java.util.Arrays;

public class PrisonCells {

	public static void main(String[] args) {
		
		int[] input = {1,0,0,1,0,0,1,0};
		int length = 1000000000;
		System.out.println(Arrays.toString(prisonAfterNDays(input,length)));

	}
	
	public static int[] prisonAfterNDays(int[] cells, int N) {
	     
        int[] temp = new int[cells.length];
        temp[0] = 0;
        temp[cells.length-1] = 0;
        
        while(N!=0){
            
            //perform
            
            for(int i=1;i<=cells.length-2;i++){
                if(cells[i-1] == cells[i+1]){
                    temp[i] = 1;
                }else{
                    temp[i] = 0;
                }
            }
            
               for(int j=0;j<temp.length;j++){
                   cells[j]=temp[j];
               }
            temp = new int[cells.length];
            N = (N - 1)%14;
           // N--;
        }
        
        return cells;
    }

}
