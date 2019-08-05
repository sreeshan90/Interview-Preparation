package com.random.problem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TreeProblems {

	long startTime, endTime, elapsedTime;
	long phase = 0;
	TreeNode root;

	TreeProblems() {
		root = new TreeNode(0);
	}

	/** binary tree node */
	public class TreeNode {
		long data;
		TreeNode left, right, parent;

		TreeNode(long x) {
			data = x;
			left = null;
			right = null;
			parent = null;
		}

		/**
		 * create a new node that is attached to par node as left child if
		 * goLeft is true; otherwise, the new node is attached to par as right
		 * child
		 */
		TreeNode(long x, TreeNode par, boolean goLeft) {
			data = x;
			left = null;
			right = null;
			parent = par;
			if (goLeft) {
				par.left = this;
			} else {
				par.right = this;
			}
		}
	} // end of TreeNode class

	public static void main(String[] args) {

		long depth = 3;

		TreeProblems x = new TreeProblems();

		// Create a tree composed of 2 long paths
		TreeNode last = x.root;

		last.data = 10;
		last.left = x.new TreeNode(5);
		last.right = x.new TreeNode(15);

		last.left.left = x.new TreeNode(2);
		last.left.right = x.new TreeNode(6);

		last.right.left = x.new TreeNode(12);
		last.right.right = x.new TreeNode(16);

		/*
		 * for (long i = 1; i <= depth; i++) { last = x.new TreeNode(i, last,
		 * true); }
		 * 
		 * last = x.root; for (long i = 1; i <= depth; i++) { last = x.new
		 * TreeNode(depth + i, last, false); }
		 */

		// printLevelOrder(x.root);
		System.out.println(isaBST(x.root));

	}

	public static TreeNode inverseTree(TreeNode root) {

		if (root == null)
			return root;

		if (root.left == null && root.right == null)
			return root;

		TreeNode temp = inverseTree(root.left);
		root.left = inverseTree(root.right);
		root.right = temp;

		return root;

	}

	public static void printLevelOrder(TreeNode tmpRoot) {

		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

		currentLevel.add(tmpRoot);
		int count = -1; // keep track of levels

		while (!currentLevel.isEmpty()) {
			count++;
			Iterator<TreeNode> iter = currentLevel.iterator();
			System.out.print("Nodes of level " + count + " are ");

			while (iter.hasNext()) {

				TreeNode currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				System.out.print(currentNode.data + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode>();

		}

	}

	
		public static boolean isaBST(TreeNode tmpRoot) {

		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();

		currentLevel.add(tmpRoot);

		while (!currentLevel.isEmpty()) {

			TreeNode currentNode = currentLevel.poll();
	
		
			if ( null != currentNode.left ){
				
				if (currentNode.data < currentNode.left.data) {

					return false;
				}

				currentLevel.add(currentNode.left);
			
			}
				
			if (null != currentNode.right){
				
				if (currentNode.data > currentNode.right.data) {

					return false;
				}

				currentLevel.add(currentNode.right);
			
			}
		}

		return true;

	}


}
