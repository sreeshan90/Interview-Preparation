package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hiretual {
	
	public static void main(String[] args) {

		System.out.println(count_working_months());

	}

	public static long count_working_months() {

		long res = 0;

		List<Interval> intervalList = new ArrayList<>();

		intervalList.add(new Interval(1, 8));
		intervalList.add(new Interval(7, 10));
		intervalList.add(new Interval(5, 6));

		List<Interval> merged = mergeInput(intervalList);

		for (Interval interval : merged) {

			res += interval.end - interval.start;

		}

		return res;

	}

	public static List<Interval> mergeInput(List<Interval> input) {

		LinkedList<Interval> res = new LinkedList<>();

		// 1. sort based on beginning

		Collections.sort(input, (in1, in2) -> (Long.compare(in1.end, in2.start)));

		for (Interval inter : input) {

			if (res.isEmpty() || res.getLast().end < inter.start) { // no overlap

				res.add(inter);
				
			} else {
	
				res.getLast().end = Math.max(res.getLast().end, inter.end);

			}
		}

		return res;

	}

	public static class Interval {

		long start;
		long end;

		public Interval(long start, long end) {

			this.start = start;
			this.end = end;
		}

	}
}
