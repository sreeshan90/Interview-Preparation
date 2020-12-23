package com.leetcode;
import java.util.*;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];

        // build adj list

        if(n == 1) {
            return 1;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for(int i=0; i<n; i++) {

            if(!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adj, int index, boolean[] visited) {

        visited[index] = true;

        for(Integer i : adj.get(index)) {
            if(!visited[i]) {
                dfs(adj, i, visited);
            }
        }
    }
}
