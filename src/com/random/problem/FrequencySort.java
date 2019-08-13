package com.random.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	//https://leetcode.com/problems/sort-characters-by-frequency/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(frequencySort("tree"));

	}

	 public static String frequencySort(String s) {

			if (s == null || s.length() <= 2) {
				return s;
			}

			StringBuilder sb = new StringBuilder();

			Map<Character, Integer> map = new HashMap<>();

			char[] cArr = s.toCharArray();

			for (char c : cArr) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));

			for (char c : map.keySet()) {
				heap.offer(c);
			}

			while (!heap.isEmpty()) {
				char c = heap.poll();
				int count = map.get(c);
				while (count != 0) {
					sb.append(c);
	                count--;
				}

			}

			return sb.toString();

		}

}
