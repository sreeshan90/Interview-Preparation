package com.ctci.linkedLists;


import com.leetcode.ListNode;

public class DeleteMiddleNode {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
