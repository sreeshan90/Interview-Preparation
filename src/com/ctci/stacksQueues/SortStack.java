package com.ctci.stacksQueues;

import java.util.Stack;

public class SortStack {

     static class SortedStack {

        private Stack<Integer> st = new Stack<>();
        private Stack<Integer> auxSt = new Stack<>();

        public int pop() {
            return st.pop();
        }

        public void push(int val) {
            if (st.isEmpty()) {
                st.push(val);
                return;
            }
            while(!st.isEmpty() && st.peek() < val) {
                auxSt.push(st.pop());
            }
            st.push(val);

            while(!auxSt.isEmpty()) {
                st.push(auxSt.pop());
            }
        }

        public int peek() {
            return st.peek();
        }

        public boolean isEmpty(){
            return st.isEmpty();
        }

         @Override
         public String toString() {
             return "SortedStack{" +
                     "st=" + st +
                     '}';
         }
     }

    public static void main(String[] args) {
        SortedStack sorted = new SortedStack();
        sorted.push(1);
        sorted.push(2);
        sorted.push(3);
        sorted.push(4);
        sorted.push(5);

        System.out.println(sorted.peek());
        sorted.pop();
        System.out.println(sorted);
        System.out.println(sorted.peek());
        sorted.push(-1);
        System.out.println(sorted.peek());

    }
}
