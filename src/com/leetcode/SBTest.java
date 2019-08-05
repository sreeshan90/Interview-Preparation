package com.sreesha.test;

import java.util.Stack;

public class SBTest {

	 public static void main(String[] args) {
		  
	   /*   StringBuilder str = new StringBuilder("5>-2>-1->");
	      System.out.println("string = " + str.reverse().delete(0, 2));
	      
	      
	      int s = 4;
	      
	      if(s==3){
	    	  System.out.println("IF");
	      }else if (s==4){
	    	  System.out.println(" else IF1 ");
	      }else if(s==4){
	    	  System.out.println("else If 2");
	      }
*/
	    	
		/* System.out.println('5'-'2');
		 
		 int[][] m = new int[3][12];*/
		 
		 
		 String m = "1001001011100001";
		 int count =0;
		 char[] arr = m.toCharArray();
		 
		 
		 int firstOneIndex = 0;
		 int lastOneindex = arr.length-1;
		 
		 for(int i=0;i<arr.length;i++){
			 if(arr[i] == '1'){
				 firstOneIndex = i;
				 break;
			 }
		 }
		 
		 for(int i=arr.length-1;i>=0;i--){
			 if(arr[i] == '1'){
				 lastOneindex = i;
				 break;
			 }
		 }
		 
		 for(int i = firstOneIndex;i<lastOneindex;i++){
			 if(arr[i] == '0'){
				 count++;
			 }
			 
		 }
		 System.out.println(count);
		 
		/* int count =0;
		 char[] arr = m.toCharArray();
		 Stack<Character> st = new Stack<>();
		 
		 for(int i=0;i<arr.length;i++){
			 
			 if(arr[i] == '1' && st.isEmpty()){
				 st.push(arr[i]);
			 } if(arr[i] == '0' && !st.isEmpty()){
				 st.push(arr[i]);
			 }
			  if(arr[i] == '1' && !st.isEmpty()){
				 while(!st.isEmpty()){
					 st.pop();
					 count++;
				 }
	
			
			 }
		 }
		 
		 System.out.println(count);*/
		 
		 
		 
		 
	   }
	 
}
