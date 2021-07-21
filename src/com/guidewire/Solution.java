package com.guidewire;

import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] A) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int res = -1;


        for (int i=0; i<A.length; i++) {
            max = A[i] > max ? A[i] : max;
        }

        for (int i =0 ;i < A.length; i++) {

            if (A[i] > secondMax && A[i] < max) {
                secondMax = A[i];
                res = i;
            }

        }

        return res;
    }

    static class Element {
        int value;
        int index;

        public Element(int val, int idx) {
            this.value = val;
            this.index = idx;
        }
    }
    public static int solution_Heap(int[] A) {
        PriorityQueue<Element> heap = new PriorityQueue<>( (a, b) -> {
            return b.value - a.value;
        });

        for (int i=0; i<A.length; i++) {
            heap.offer(new Element(A[i], i));
        }

        heap.poll();
        return heap.poll().index;

    }
    public static void main(String[] args) {
        System.out.println(solution_Heap(new int[]{9,1,2,-1,3,5,6}));
    }


}
//that, given an array A consisting of N integers, returns the index of the second highest integer.
  //       Example: solution([-1, 1, 4, 3]) returns 2.

