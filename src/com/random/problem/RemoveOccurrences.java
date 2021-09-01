package com.random.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ListNode {

    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
        this.next = null;
    }

}

public class RemoveOccurrences {

    public static void main(String[] args) {

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;

        int[] arr = new int[] {3,2,4,2,1,4,6,2,1,4,1,2,2,3,3};

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        ListNode node = removeOccurrence(dummyHead.next);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static ListNode removeOccurrence(ListNode head) {

        ListNode dummyHead = head;

        Map<Integer, Integer> map = new HashMap<>();

        while (dummyHead != null) {
            map.put(dummyHead.val, map.getOrDefault(dummyHead.val, 0) + 1);
            dummyHead = dummyHead.next;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));

        for (int c : map.keySet()) {
            heap.offer(c);
        }

        int max_value = heap.poll(); // max freq

        return removeElements(head, max_value);
    }

    private static ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;

        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
