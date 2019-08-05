package com.leetcode;

public class ReverseInteger {

	 public static int reverse(int i) {
	     int in = i;  
		 int digit=0;
		 long res=0;
	        while(i!=0){
	            i = i/10;
	            digit++;
	        }
	      while(in!=0){
	    	  res+=in%10*Math.pow(10, --digit);
	    	  in=in/10;
	    	//  digit--;
	    	  
	      }
	      
	      if(res>Integer.MAX_VALUE) return 0;

			return (int)res;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-123));
	}

}
