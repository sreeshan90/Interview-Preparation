package com.random.problem;

public class BinarySearchTree<T extends Comparable<T>> {

    class Node<T extends Comparable<T>> {
        T value;
        Node left;
        Node right;

        public Node(T val) {
            this.value = val;
            left = null;
            right = null;
        }
    }

    // Root of BST
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        String[] arr = {"0", "1","2", "3", "4", "4"};
        // int[] arr = {3,6,6,3,6,8,3,3,76,5,2,23,5,3};
        BinarySearchTree tree = new BinarySearchTree();
        for (Object val: arr) {
            tree.insert((Comparable) val);
        }
        System.out.println(tree.search(""));
    }

    public void insert(T val) { // O(n)
        root = insertNode(root, val);
    }

    public boolean search(T val) { // O(n)

        if (null == val) {
            return true;
        }
        if (searchRec(root, val) != null) {
            return true;
        }
        return false;
    }

    private Node searchRec(Node root, T val) {

        if (root == null) {
            return null;
        }
        if (val.compareTo((T) root.value) == 0) {
            return root;
        }

        if (val.compareTo((T) root.value) < 0) {
            return searchRec(root.left, val);
        }
        else {
            return searchRec(root.right, val);
        }
    }
    public boolean delete(T val) {
        return false;
    }

    public void inorder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.println(root.value);
        inOrderRec(root.right);
    }

    private Node insertNode( Node root, T val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val.compareTo((T) root.value) <= 0) {
            root.left = insertNode(root.left, val);
        }
        else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }
}
