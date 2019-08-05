package com.leetcode;

import java.util.Stack;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(longestPalindrome("babad"));
		
		int i = 901000;
		
		StringBuilder str = new StringBuilder(String.valueOf(i));
		str.reverse();
		System.out.println(str);
		int j;
		for(j=0;j<=str.length()-1;j++){
			
			System.out.println("Char at "+j+" "+str.charAt(j));
			
			if(str.charAt(j) == '0'){
				if(str.length() == 1){
					System.out.println("breaking coz len 1");
					break;
				}
				System.out.println("deleting char at "+j+ " "+str.charAt(j));
				str.deleteCharAt(j);
				System.out.println("str "+str);
			}else{
				System.out.println("breaking");
				break;
			}
		}
		
		System.out.println("out of loop "+j);

		if(str.charAt(str.length()-1) == '-'){
			
			str.insert(0, '-');
			str.deleteCharAt(str.length()-1);
			
		}
		System.out.println(str);
		
	

	}
	
	public static String longestPalindrome(String s) {
        
        
        //1. push to stack - if already contains, start popping until u find the chRCTER
        StringBuilder max = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		int begin = 0;
		for(int i=0;i<s.length();i++)
        
			if(!st.contains(s.charAt(i))){
				st.push(s.charAt(i));
			}
			else{
				//pop until you find the char
				StringBuilder str = new StringBuilder();
				str.append(s.charAt(i));
				while(s.charAt(i)!=st.peek()){
				
					str.append(st.pop());
				}
				
				str.append(st.pop());
				
				if(str.toString().equalsIgnoreCase(s.substring(begin, i))){
					if(max.length()<s.substring(begin,i).length()){
						max = new StringBuilder(s.substring(begin,i));
						begin = i;
					}
					
				}
			}
		return max.toString();
    }

}
