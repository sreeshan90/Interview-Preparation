package com.sreesha.test.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayProblemVisa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {1,2,3,4,5};
		
		Set s = new HashSet<>(Arrays.asList(input));
		
		int sum = 0;
		for(int i : input){
			sum+=i;
		}
		
		for(int i=0;i<input.length;i++){
			input[i] = sum - input[i];
		}
		
		System.out.println(Arrays.toString(input));
	}

}
