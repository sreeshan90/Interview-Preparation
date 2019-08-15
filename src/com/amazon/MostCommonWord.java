package com.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String args[]){
		
		String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		System.out.println(mostCommonWord(p, banned));
		
	}
	
	
	public static String mostCommonWord(String paragraph, String[] banned) {

        paragraph += ".";
        
		Map<String, Integer> map = new HashMap<>();
		int freq = 0;
		String res = "";
		Set<String> set = new HashSet<>();

		for (String word : banned) {
			set.add(word);
		}

		StringBuilder word = new StringBuilder();

		for (char c : paragraph.toCharArray()) {

			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {

				String fWord = word.toString();
				if (!set.contains(fWord)) {
					map.put(fWord, map.getOrDefault(fWord, 0) + 1);

                        if (map.get(fWord) > freq) {
                        freq = map.get(fWord);
                        res = fWord;
                    }
				}
                
                word = new StringBuilder();
				
			}
		}

		return res;

	}

}
