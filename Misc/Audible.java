package com.misc.practice;

import java.util.HashMap;

public class Audible {

	public static void main(String args[]){
		
		int[] a = {7,7,25,63,98,14,75,66,66,15,7};
	
		HashMap<Integer, Integer> map = new HashMap<>();
				
		
		for(int i=0;i<a.length;i++){
			
			if(map.containsKey(a[i])){
				
				map.put(a[i],map.get(a[i])+1);
			}
			else{
				map.put(a[i], 1);
			}
			
			
		}
		
		System.out.println(map);
	}
	
		/*
	 * Method to compute nth largest number in an array
	 * */
	public static int nthLargest(int[] input, int n){
		
		TreeSet<Integer> s = new TreeSet<>();
		
		for(int i = 0 ;i<input.length;i++){
			s.add(input[i]);
		}
			
		if(n > input.length){
			System.out.println("Invalid n");
			return -1;
		}
		else{
			Object[] arr =  s.toArray();
			return (int) arr[n-1];
		}
		
	}
	
		/*
	 * Method to compute index of first non-repeated character
	 * */
	public static int firstNonRepeatedCharIndex(String input){
		
		char[] inArr = input.toCharArray();
		HashMap<Character,Integer> map = new HashMap();
		
		for(int i=0;i<inArr.length;i++){
			if(map.containsKey(inArr[i])){
				map.put(inArr[i], map.get(inArr[i])+1);
			}
			else{
				map.put(inArr[i],1);
			}
		 }
		
		for(int i=0;i<inArr.length;i++){
			
			if(map.get(inArr[i]) == 1){
				return i;
			}
		}
		
			return -1;
		
		
		
		
	}
	
}
