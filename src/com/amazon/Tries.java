package com.amazon;

import java.util.ArrayList;
import java.util.List;

public class Tries {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		
		list.add("pqrs");
		list.add("pprt");
		list.add("psst");
		list.add("qqrs");
		list.add("pqrs");
		list.add("pqr");
		
		Trie trie = new Trie();
		
		for(String s : list)
			trie.insert(s);
		
		System.out.println(trie.query("pqrqq"));
	}

}

class Trie {

	final TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public int query(String s) {

		TrieNode current = root.next(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {

			if (null == current) {
				return 0;
			}
			current = current.next(s.charAt(i));
		}

		return current.terminating;

	}

	public void insert(String s) {

		TrieNode current = root;

		for (int i = 0; i < s.length(); i++) {

			if (current.trieNodes[s.charAt(i)-'a'] == null) {
				current.trieNodes[s.charAt(i)-'a'] = new TrieNode();
			}

			current = current.next(s.charAt(i));
		}

		current.terminating++;

	}

	public void delete(String s) {

		TrieNode current = root;

		for (int i = 0; i < s.length(); i++) {

			if (current.trieNodes[s.charAt(i)-'a'] == null) {
				throw new RuntimeException("String doesnt exist");
			}

			current = current.next(s.charAt(i));
		}

		current.terminating--;

	}

	public void update(String oldString, String newString) {

		delete(oldString);
		insert(newString);

	}
}

class TrieNode {

	int terminating;
	TrieNode[] trieNodes = new TrieNode[26];

	TrieNode next(char c) {

		return trieNodes[c - 'a'];
	}

}