package com.sreesha.test;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubString {

	public static void main(String[] args) {
		
System.out.println(lengthOfLongestSubstring("anviaj"));

	}
	
	public static int lengthOfLongestSubstring(String s) {
        
		if(s.length() == 0){
			return 0;
		}
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 0,i=0,j=0;
        for(char c:arr){
        	
        	if(!set.contains(c)){
        		
        		set.add(c);
        		j++;
        		max = Math.max(max, j-i);
        		
        	}else{
        		i++;
        		
        		set.remove(c);
        	}
        	
        	
        }
        
        return max;
    }

}
