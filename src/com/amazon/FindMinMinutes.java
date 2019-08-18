package com.amazon;

import java.util.Collections;
import java.util.List;

public class FindMinMinutes {

	public int findMinDifference(List<String> timePoints) {

		Collections.sort(timePoints, (str1, str2) -> {

			String s1_hour = str1.split(":")[0];
			String s1_min = str1.split(":")[1];

			String s2_hour = str2.split(":")[0];
			String s2_min = str2.split(":")[1];

			if (str1.equals(str2)) {
				return 0;
			}

			if (s1_hour.equals(s2_hour)) {
				// compare minutes
				int s1minute = Integer.parseInt(s1_min);
				int s2minute = Integer.parseInt(s2_min);

				return Integer.compare(s1minute, s2minute);

			} else {
				int s1Hour = Integer.parseInt(s1_hour);
				int s2Hour = Integer.parseInt(s2_hour);

				return Integer.compare(s1Hour, s2Hour);

			}

		});

		int min = Integer.MAX_VALUE;
		int currMin = Integer.MAX_VALUE;

		for (int i = 0; i < timePoints.size(); i++) {

			String curr = timePoints.get(i);
			String next = timePoints.get((i + 1) % timePoints.size());

			currMin = Math.min(1440 - getMinDiff(next, curr), getMinDiff(next, curr));

			min = Math.min(min, currMin);

		}
		return min;
	}

	public int getMinDiff(String str1, String str2) {

		String s1_hour = str1.split(":")[0];
		String s1_min = str1.split(":")[1];
		String s2_hour = str2.split(":")[0];
		String s2_min = str2.split(":")[1];

		int s1Hour = Integer.parseInt(s1_hour);
		int s2Hour = Integer.parseInt(s2_hour);
		int s1minute = Integer.parseInt(s1_min);
		int s2minute = Integer.parseInt(s2_min);

		int diffinMinsFromZero = (s1Hour - s2Hour) * 60 + (s1minute - s2minute);

		if (diffinMinsFromZero < 0) {
			return 1440 + diffinMinsFromZero;
		}
		return diffinMinsFromZero;

	}
}
