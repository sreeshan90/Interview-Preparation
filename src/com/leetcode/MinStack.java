package com.leetcode;

import java.util.LinkedList;

public class MinStack {

	/** initialize your data structure here. */

	LinkedList<Integer> list;
	LinkedList<Integer> minList;

	public MinStack() {

		this.list = new LinkedList<>();
		this.minList = new LinkedList<>();
	}

	public void push(int x) {
		list.addLast(x);
		
		if(minList.isEmpty()){
			minList.addLast(x);
		}
		else if (minList.getLast() > x) {
			minList.addLast(x);
		}
	}

	public void pop() {

		if (list.getLast() == minList.getLast()) {
			list.removeLast();
			minList.removeLast();

		} else {
			list.removeLast();
		}

	}

	public int top() {
		return list.getLast();
	}

	public int getMin() {
		return minList.getLast();
	}

	public static void main(String args[]) {
		MinStack minStack = new MinStack();
		
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());  // --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());    //  --> Returns 0.
		System.out.println(minStack.getMin());
		
	}
}
