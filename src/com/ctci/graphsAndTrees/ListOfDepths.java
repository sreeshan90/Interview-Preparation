package com.ctci.graphsAndTrees;

import com.leetcode.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    public List<ListNode> binaryTreeToLists(TreeNode root) {

        if (root == null) {
            return new LinkedList<ListNode>();
        }

        List<ListNode> res = new LinkedList<>();

        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        curr.offer(root);

        ListNode currentLevel = new ListNode(0);
        ListNode temp = currentLevel;

        while (!curr.isEmpty()) {

            TreeNode node = curr.poll();
            temp.next = new ListNode(node.val);
            temp = temp.next;

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (curr.isEmpty()) {

                curr = next;
                res.add(currentLevel.next);
                currentLevel = new ListNode(0);
                temp = currentLevel;
                next = new LinkedList<>();
            }
        }

        return res;
    }
}
