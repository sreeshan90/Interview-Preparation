package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryGap {

	  public int solution(int N) {
	        // write your code in Java SE 8
	        
	        String input = Integer.toBinaryString(N);
	        
	        int max = 0;
	        
	        char[] in = input.toCharArray();
	        
	        Queue<Character> q = new LinkedList();
	        
	        for(int i=0;i<in.length;i++){
	        
	               q.add(in[i]); 
	            
	        }
	        
	        q.poll(); //gets rid of first 1
	        int count = 0;
	        while(!q.isEmpty()){
	            
	            if(q.poll()!='1'){
	                count++;
	                continue;
	            }else{
	                max = Math.max(count,max);
	                count=0;
	            }
	        }
	        
	        return max;
	    }
}
