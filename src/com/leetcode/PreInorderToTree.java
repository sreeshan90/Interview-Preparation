package com.sreesha.test;

import java.util.Arrays;

public class PreInorderToTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		System.out.println(" PRE "+Arrays.toString(preorder));
		
		System.out.println(" IN "+Arrays.toString(inorder));
		
		if (inorder == null || inorder.length == 0)
			return null;
		int val = preorder[0];
		PreInorderToTree t = new PreInorderToTree();
		TreeNode root = t. new TreeNode(val);
		if (inorder.length == 1)
			return root;
		int index = findRoot(inorder, val);
		System.out.println("ROOT "+index);
		int[] iLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] iRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] pLeft = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] pRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		root.left = buildTree(pLeft, iLeft);
		root.right = buildTree(pRight, iRight);
		return root;
	}

	public static int findRoot(int[] inorder, int target) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == target)
				return i;
		}
		return -1;

	}
	
	public static void  main(String args[]){
		
		int pre[] = {3,9,20,15,7};
		int in[] = {9,3,15,20,7};
		
		buildTree(pre,in);
	
	}
}
