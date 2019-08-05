package com.leetcode;

public class RemoveKDigits {

	public static void main(String args[]){


		String num = "10";
		int k = 2;
		
		for(int i=0;i<k;i++){
            num = retMinOne(num);
        }
		
		System.out.println(num);
		
	}
	
	
	public static String retMinOne(String n){
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n.length();i++){
			
			String str = n.substring(0, i)+n.substring(1+i,n.length());
		//	System.out.println(n.substring(0, i)+n.substring(1+i,n.length()));
			
			if(str.length() == 0) return "0";
			min = Math.min(min, Integer.parseInt(str));
		}
		
		//System.out.println("MIN "+min);
		return min+"";
	}
}
