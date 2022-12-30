package com.leetcode.lc75;

import java.util.LinkedList;
import java.util.List;

public class NAryPreOrderTreeTraversal {
    List<Integer> result = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        helper(root);
        return result;
    }

    public void helper (Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);

        for (Node n : root.children) {
            helper(n);
        }
    }
}
