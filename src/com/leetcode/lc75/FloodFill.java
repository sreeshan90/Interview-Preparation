package com.leetcode.lc75;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        return dfs(image,sr,sc,newColor, image[sr][sc]);
    }

    public int[][] dfs(int[][] img, int i, int j, int newColor, int prevColor){

        if(i<0 || j<0 || i > img.length-1 || j> img[i].length-1 || img[i][j]!=prevColor || newColor == prevColor){
            return img;
        }

        img[i][j] = newColor;

        dfs(img,i+1,j,newColor,prevColor);
        dfs(img,i-1,j,newColor,prevColor);
        dfs(img,i,j+1,newColor,prevColor);
        dfs(img,i,j-1,newColor,prevColor);

        return img;
    }
}
