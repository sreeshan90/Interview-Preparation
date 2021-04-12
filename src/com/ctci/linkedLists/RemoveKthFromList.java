package com.ctci.linkedLists;

import com.leetcode.ListNode;

public class RemoveKthFromList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        int i = 0;
        ListNode tempHead = head;

        while (tempHead!=null) {
            length++;
            tempHead = tempHead.next;
        }

        if (n > length) {
            return null;
        }

        if (n == length) {
            return head.next;
        }

        //have tow pointers .. move the second pointer n positions

        ListNode first = head, second = head;
        ListNode prev = null;

        while (i<n) {
            second = second.next;
            i++;
        }

        while (second != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }

        prev.next = first.next;

        return head;
        // first is pointing to the nth node from the end
    }
}
