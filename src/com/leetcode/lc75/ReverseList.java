package com.leetcode.lc75;

public class ReverseList {
    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
