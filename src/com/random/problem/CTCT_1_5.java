package com.random.problem;

public class CTCT_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "aabcccccaaaa";
		if(compress(input).length()<input.length()){
			System.out.println(compress(input));
		}
		else{
			System.out.println(input);
		}
	}

	public static String compress(String a) {

		int[] letters = new int[256];
		StringBuilder retValue = new StringBuilder();
		// count the no of occurances of each char in the string

		for (int i = 0; i < a.length(); i++) {
			letters[(int) a.charAt(i)]++;

		}

		for (int i = 0; i < letters.length; i++) {
			
			if(letters[i] > 0){
				retValue.append((char)i);
				retValue.append(letters[i]);
				//letters[i] = -1;
			}
		

		}
		
		return retValue.toString();

	}
	
}
