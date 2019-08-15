package com.amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {

		// store all the last occurances
		
		List<Integer> res = new ArrayList<>();

		int[] lastOcc = new int[26];

		for (int i = 0; i < S.length(); i++) {
			lastOcc[S.charAt(i) - 'a'] = i;
		}

		int i = 0;

		while (i < S.length()) {

			int end = lastOcc[S.charAt(i) - 'a'];

			int j = i;

			while (j < end) {

				end = Math.max(end, lastOcc[S.charAt(j) - 'a']);
				j++;
			}

			res.add(j - i + 1);
			i = j + 1;
		}

		return res;
	}

}
