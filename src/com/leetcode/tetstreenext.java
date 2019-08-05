package com.sreesha.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tetstreenext {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}

		public Node connect(Node root) {

			List<List<Node>> res = new ArrayList<>();

			if (null == root) {
				return null;
			}
			Queue<Node> pq = new LinkedList<>();
			Queue<Node> cq = new LinkedList<>();

			List<Node> level = new ArrayList<>();
			pq.add(root);

			while (!pq.isEmpty()) {

				Node parent = pq.remove();

				if (null != parent) {

					level.add(parent);
					if (null != parent.left)
						cq.add(parent.left);
					if (null != parent.right)
						cq.add(parent.right);

				}

				if (pq.isEmpty()) {
					pq = new LinkedList<>(cq);
					cq.clear();
					res.add(level);
					level = new ArrayList<>();

				}

			}

			for (List<Node> list : res) {

				for (int i = 0; i < list.size(); i++) {
					if (i + 1 == list.size()) {
						list.get(i).next = null;
					} else {
						list.get(i).next = list.get(i + 1);
					}

				}
			}
			return root;
		}
	}
}
