package com.leetcode;

public class Stack {

	int top = -1;
	int[] stack;
	int SIZE;

	public Stack(int count) {
		stack = new int[count];
		SIZE = count;
	}

	public void push(int item) {
		// if stack overflow conditino
		if (top == SIZE) {
			try {
				throw new Exception("Overflow");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stack[top] = item;
		top++;

	}

	public int pop() {

		if (top <= 0) {
			try {
				throw new Exception("Empty Stack");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stack[top--];

	}

	public boolean isEmpty() {

		if (top <= 0)
			return true;
		else
			return false;
	}
	
	
	public static void main(String args[]){
		
		Stack st = new Stack(3);
		
		st.push(1);
		st.push(2);
	}
	
	
	
}