package com.random.problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

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
	
		/*
	 * Method to find the missing num in an array of n consecutive numbers
	 * */
	public static int missingNum(int[] inArr){
		
		TreeSet<Integer> set = new TreeSet<>();
		
		//get rid of duplicates if any and get it sorted
		
		for(int i=0;i<inArr.length;i++){
			
			set.add(inArr[i]);
		}
		
		int start = set.first();
		
		Iterator it = set.iterator();
		//skip first elem
		it.next();
		
		while(it.hasNext()){
	
			int num = (int) it.next();
			start++;	
			
			if(num != start){
				return start;
			}
			else{
				continue;
			}
			
		}
		return -1;

	}
	
}
