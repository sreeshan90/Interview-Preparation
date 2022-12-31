package com.leetcode.lc75;

public class FirstBadVersion {
    // https://leetcode.com/problems/first-bad-version/

    public int firstBadVersion(int n) {

        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            // if true, check the left
            if (isBad) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    // Mock method - check problem description
    private boolean isBadVersion(int mid) {
        return true;
    }
}
