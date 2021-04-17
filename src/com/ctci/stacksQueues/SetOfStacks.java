package com.ctci.stacksQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    private int STACK_CAPACITY;
    private List<Stack> stackList;
    private int topStackIndex;

    public SetOfStacks(int capacity) {
        stackList = new ArrayList<>();
        stackList.add(new Stack());
        topStackIndex = 0;
    }

    private Stack<Integer> getTopStack() {
        return stackList.get(topStackIndex);
    }

    public void push(int val) {
        if (getTopStack().size() < STACK_CAPACITY) {
            getTopStack().push(val);
        }
        else {
            // add new stack
            Stack st = new Stack();
            st.push(val);
            stackList.add(st);
        }
    }

    public int pop() {
        Stack<Integer> st = getTopStack();
        int val = st.pop();
        if (st.isEmpty()) {
            stackList.remove(topStackIndex--);
        }

        return val;
    }
}
