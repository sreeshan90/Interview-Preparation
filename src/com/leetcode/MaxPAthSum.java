package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MaxPAthSum {

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);

			int ret = new MaxPAthSum().maxPathSum(root);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}

	public int maxPathSum(TreeNode root) {

		// for each node - find the sum of the subtree

		int res = Integer.MIN_VALUE / 2;

		Stack<TreeNode> st = new Stack<>();

		if (root == null) {
			return 0;
		}

		st.push(root);

		while (!st.isEmpty()) {

			TreeNode node = st.pop();

			res = Math.max(res, traverseSum(node));

			if (root.left != null) {
				st.push(root.left);
			}
			if (root.right != null) {
				st.push(root.right);
			}
		}

		return res;

	}

	public int traverseSum(TreeNode root) {

		if (null == root) {
			return 0;
		}

		return root.val + traverseSum(root.left) + traverseSum(root.right);

	}
}
