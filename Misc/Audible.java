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
}
