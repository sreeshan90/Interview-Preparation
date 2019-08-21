package com.amazon;

public class FindShortestPathToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = {
							{0,0,0,0,0},
							{0,1,1,1,0},
							{0,1,0,0,0},
							{0,0,0,1,0}
						};
		
/*		int[][] grid = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,0,1,0,0,1,1},
				{0,1,0,0,0,0,1,1,1,1},
				{0,0,0,1,0,0,0,0,0,0}
			};*/
		
		
		System.out.println(findMinPath(grid));
	}
	
	public static int findMinPath(int[][] grid){
		
		if(grid.length == 0 || grid.length == 1){
			return 0;
		}
		
		return dfs(grid,0,0,0);
	}

	public static int dfs(int[][] grid, int i, int j, int count){
		
		if(i<0 || j< 0 || i>=grid.length || j>=grid[i].length || grid[i][j] != 0){
			
			return Integer.MAX_VALUE;
		}
		
		if(i == grid.length-1 && j == grid[i].length-1){
			return count;
		}
		
		int temp = grid[i][j];
		
		grid[i][j] = 1;
		
		int a = dfs(grid, i+1, j, count+1);
		int b = dfs(grid, i-1, j, count+1);
		int c = dfs(grid, i, j+1, count+1);
		int d = dfs(grid, i, j-1, count+1);
		
		grid[i][j] = temp;
		
		return Math.min((Math.min(a, b)), Math.min(c, d));
	}
}
