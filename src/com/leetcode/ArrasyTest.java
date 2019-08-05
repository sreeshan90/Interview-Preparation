package com.sreesha.test;

import java.util.Arrays;

public class ArrasyTest {

	public static void main(String args[]) 
    { 
        int parr[] = {3,9,20,15,7};
        int iarr[] = {9,3,15,20,7};
  
        System.out.println(findRoot(iarr, 3));
        // to index is within the range 
        int[] copy = Arrays.copyOfRange(parr, 1, 2); 
        for (int i : copy) 
            System.out.print(i + "  "); 
  
        System.out.println(); 
        // to index is out of range 
        // It assigns Zero to all the index out of range 
        int[] copy1 = Arrays.copyOfRange(parr, 2, parr.length); 
  
        for (int i : copy1) 
            System.out.print(i + "  "); 
  
        // It throws IIlegalArgumentException 
        // int[] copy2 = Arrays.copyOfRange(arr, 5, 3); 
  
        // It throws ArrayIndexOutOfBoundsException 
        // int[] copy2 = Arrays.copyOfRange(arr, 10, arr.length + 5); 
    } 

	public static int findRoot(int[] inorder, int target){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == target) return i;
        }
        return -1;
    }
}
