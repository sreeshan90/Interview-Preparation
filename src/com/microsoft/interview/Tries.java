package com.microsoft.interview;

import java.util.*;

public class Tries {

	public static void main(String[] args) {
		final List<String> setOfStrings = new ArrayList<>();
		setOfStrings.add("pqrs");
		setOfStrings.add("pprt");
		setOfStrings.add("psst");
		setOfStrings.add("qqrs");
		setOfStrings.add("pqrs");
		final Trie trie = new Trie();
		setOfStrings.forEach(trie::insert);
		System.out.println(trie.query("psst"));
		System.out.println(trie.query("psstq"));
		trie.update("qqrs", "psst");
		System.out.println(trie.query("qqrs"));
		System.out.println(trie.query("psst"));
	}
}

class Trie {
	final Node start;

	public Trie() {
		this.start = new Node();
	}

	public int query(final String s) {

		Node current = start;
		for (int i = 0; i < s.length(); i++) {

			if (current==null || current.next(s.charAt(i))==null) {
				return 0;
			}
			else {
				current = current.next(s.charAt(i));
			}
		}
		return current.ending;
	}

	public void insert(final String s) {
		Node current = start;
		for (int i = 0; i < s.length(); i++) {
			if (current.nodes[s.charAt(i) - 'a'] == null) {
				current.nodes[s.charAt(i) - 'a'] = new Node();
			}
			current = current.next(s.charAt(i));
		}
		current.ending++;
	}

	public void delete(final String s) {
		Node current = start;
		for (int i = 0; i < s.length(); i++) {
			if (current == null) {
				throw new RuntimeException();
			}
			current = current.next(s.charAt(i));
		}
		if (current.ending != 0) {
			current.ending--;
		} else {
			throw new RuntimeException();
		}
	}

	public void update(final String old, final String newString) {
		delete(old);
		insert(newString);
	}
}

class Node {
	int ending;
	final Node[] nodes = new Node[26];
	public Node next(final char c) {
		return nodes[c - 'a'];
	}
}

