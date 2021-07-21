package com.random.problem;

import java.util.Arrays;
import java.util.*;

public class StringExercise {
    public static void main(String[] args) {
        int[] arr = new int[26];

        String str = "aab";

        for (char c : str.toCharArray()) {
            arr[c - 'a'] = 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("sdf".compareTo("zazaa"));

        System.out.println("abcd".substring(1,2));

        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());

        heap.offer(1);
        heap.offer(2);
        heap.offer(3);
        heap.offer(5);


        System.out.println(heap.poll());

        Map map = new HashMap();

        Set entry = map.entrySet();


    }
}
