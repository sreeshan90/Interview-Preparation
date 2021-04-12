package com.ctci.linkedLists;

import com.leetcode.ListNode;

import java.util.Stack;

public class ListPalindrome {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // if odd number of elements in list
            slow = slow.next;
        }

        while (slow != null) {
            int top = st.pop();

            if (top != slow.val) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

}
