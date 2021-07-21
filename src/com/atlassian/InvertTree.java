package com.atlassian;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        swap(root);
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

    private TreeNode swap(TreeNode root) {

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }
}
