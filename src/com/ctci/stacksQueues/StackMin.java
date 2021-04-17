package com.ctci.stacksQueues;

import java.util.Stack;


public class StackMin extends Stack<Integer> {

    private Stack<Integer> min;

    public StackMin() {
        min = new Stack();
    }

    @Override
    public Integer push(Integer item) {
        // if incoming is new min, update min stack

        if (item <= getMin()) {
            min.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        // if the top id the min, pop the min stack as well

        int value = super.pop();

        if (value == getMin()) {
            min.pop();
        }
        return value;
    }

    private Integer getMin() {
        if (min.isEmpty()) {
            return null;
        }
        return min.peek();
    }

}
