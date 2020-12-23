package com.leetcode;

public class FriendCircles {
    public int findCircleNum(int[][] M) {

        //keep track of visited nodes
        int[] visited = new int[M.length];
        int count = 0;
        // for each node - perform dfs and mark as visited

        for(int i=0;i<M.length;i++) {

            if(visited[i] != 1) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int[] visited, int i) {

        for(int j=0; j< grid.length; j++) {
            if(visited[j]!=1 && grid[i][j] == 1) {
                visited[j] = 1;
                dfs(grid, visited, j);
            }
        }
    }
}
