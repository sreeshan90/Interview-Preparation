package com.ctci.graphsAndTrees;

/**
 *
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class MiminalTree {
    int[] nums;

    public TreeNode helper (int leftIndex, int rightIndex) {

        if (leftIndex > rightIndex) {
            return null;
        }

        int mid = (leftIndex + rightIndex) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(leftIndex, mid-1);
        root.right = helper(mid+1, rightIndex);


        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        this.nums = nums;
        return helper(0, nums.length-1);
    }
}
