package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int res = 0;
		Set<String> set = new HashSet<>(wordList);

		if (!set.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();

		queue.offer(beginWord);

		while (!queue.isEmpty()) {

			//for (int i = 0; i < queue.size(); i++) {

				String word = queue.poll();

				if (word.equals(endWord)) {
					return res;
				}

				for (int k = 0; k < word.length(); k++) {
					char[] cArr = word.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {

						cArr[k] = ch;

						String s = new String(cArr);

						if (s.equals(endWord)) {
							return res+1;
						}
						
						if (set.contains(s) && !s.equals(word)) {
							queue.offer(s);
							set.remove(s);
						}
					}
				}

			//}

			res++;

		}

		return 0;

	}

	public int ladderLengthWorking(String start, String end, List<String> wordList) {

		Set<String> dict = new HashSet<>(wordList);

		Queue<String> queue = new LinkedList<String>();

		queue.add(start);
		queue.add(null);

		// Mark visited word
		Set<String> visited = new HashSet<String>();
		visited.add(start);

		int level = 1;

		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str != null) {
				// Modify str's each character (so word distance is 1)
				for (int i = 0; i < str.length(); i++) {
					char[] chars = str.toCharArray();

					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;

						String word = new String(chars);

						// Found the end word
						if (word.equals(end))
							return level + 1;

						// Put it to the queue
						if (dict.contains(word) && !visited.contains(word)) {
							queue.add(word);
							visited.add(word);
						}
					}
				}
			} else {
				level++;

				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}

		return 0;

	}
}
