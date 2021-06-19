package com.ctci.graphsAndTrees;

public class CheckBalanced {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left) - height(root.right)) < 2);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left) , height(root.right));
    }
}
