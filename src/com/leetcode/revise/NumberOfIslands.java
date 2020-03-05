package com.leetcode.revise;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        // for each postition check if u can find a land - if yes then recursively chcek for next possible land

        int count = 0;

        for(int i=0; i< grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                count += dfs(grid,i,j);
            }
        }

        return count;
    }

    public int dfs(char[][] grid, int i, int j) {

        if(i<0 || j<0 || i>grid.length-1 || j>grid[i].length-1 || grid[i][j] == '0') {
            return 0;
        }
        // reset to 0 to avoid revisiting
        grid[i][j] = '0';

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

        return 1;

    }
}
