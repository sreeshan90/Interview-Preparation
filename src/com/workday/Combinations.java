package com.workday;

import java.util.*;

public class Combinations {

        //Return all possible Lists containing one element from each input list
        // {{1, 2, 3}, {4, 5}, {6}}
        // {{1, 4, 6}, {1, 5, 6}, {2, 4, 6}, {2, 5, 6}, {3, 4, 6}, {3, 5, 6}}

        // [0, 0, 0]
        // {{}}

        public static void main(String args[]) {

            List l1 = Arrays.asList(new int[]{1, 2, 3});
            List l2 = Arrays.asList(new int[]{4, 5});
            List l3 = Arrays.asList(new int[]{6});

            List master = new ArrayList<>();
            master.add(l1);
            master.add(l2);
            master.add(l3);
            List<List<Integer>> res = getAllCombinations(master);

            for (List<Integer> list : res) {
                for (Integer i : list) {
                    System.out.print(i + " ");

                }
                System.out.println();
            }
        }

        public static List<List<Integer>> getAllCombinations(List<List<Integer>> input) {

            if (null == input) {
                return null;
            }

            int n = input.size();

            int[] indices = new int[n];

            for (int i=0; i< n; i++) {
                indices[i] = 0;
            }

            List<List<Integer>> result = new LinkedList<>();

            while (true) {

                for (int i=0; i< n; i++) {
                    List l = new LinkedList();
                    l.add(input.get(i).get(indices[i]));
                    result.add(l);
                }

                int nextIndex = n-1;

                while (nextIndex >= 0 && input.get(nextIndex).size() <= indices[nextIndex] + 1) {
                    nextIndex--;
                }

                if (nextIndex < 0) {
                    break;
                }

                indices[nextIndex]++;

                for (int i = nextIndex; i< n; i++) {
                    indices[i] = 0;
                }
            }


            return result;
        }
}
