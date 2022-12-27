package com.leetcode.lc75;

public class MergeSortedLists {

    // https://leetcode.com/problems/merge-two-sorted-lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode (-1);
        ListNode dummy = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
            }
            else {
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            result.next = new ListNode(list1.val);
            result = result.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            result.next = new ListNode(list2.val);
            result = result.next;
            list2 = list2.next;
        }

        return dummy.next;
    }
}
