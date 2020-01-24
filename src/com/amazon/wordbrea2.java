package com.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordbrea2 {

	// Given a dictionary of words and single string of letters, find all
	// possible sentences that can be constructed from the input.

	public static Map<Integer, List<String>> map = new HashMap<>();
	
	public static void main(String args[]) throws Exception{
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak("catsanddog",dict,0));
	}

	public static  List<String> wordBreak(String input, Set<String> dictionary, int index) throws Exception {

		// base cases

		if (dictionary.isEmpty()) {

			throw new Exception("Invalid input");
		}

		if (map.containsKey(index)) {
			return map.get(index);
		}

		List<String> res = new LinkedList<>();

		int length = input.length();

		for (int i = index + 1; i <= length; i++) {

			String prefix = input.substring(index, i);

			if (dictionary.contains(prefix)) {
				res.add(prefix);
			}

			else {
				String remainder = input.substring(i, length);
				List<String> remainderSet = wordBreak(remainder, dictionary, i);
				if (!remainderSet.isEmpty()) {
					for (String word : remainderSet) {
						res.add(prefix + " " + word);
					}
				}
			}

			map.put(i, res);
		}

		return res;
	}

}
