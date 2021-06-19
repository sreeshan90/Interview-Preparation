package com.ctci.graphsAndTrees;

/**
 * intuition : tou just need to keep track of the parent you've seen so far
 */
public class ValidateBST {

    TreeNode prev = null;

    public boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // left sub tree must satisfy and also value must be increasing from the node seen previously
        if (validateBST(root.left) && (prev == null || prev.val < root.val)) {
            prev = root;
            return validateBST(root.right);
        }
        return false;
    }
}
