package com.random.problem;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

	public static void main(String args[]) throws IOException{
		
		
	}
	
	  public String customSortString(String S, String T) {
	      
	        Map<Character, Integer> lookup = new HashMap<>();
	        
	        for(int i=0;i<S.length();i++){
	            lookup.put(S.charAt(i), i);
	        }
	        
	        char[] arr = T.toCharArray();
	        
	        Collections.sort( Arrays.asList(arr), ( a , b) -> {
	            
	            int la = lookup.containsKey(a)? lookup.get(a): Integer.MAX_VALUE;
	            int lb = lookup.containsKey(b)? lookup.get(b): Integer.MAX_VALUE;
	            
	            return la-lb;
	            
	        });
	        
	        return arr.toString();
	    }
}
