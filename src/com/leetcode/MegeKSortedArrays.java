package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MegeKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arrs = {{1,2,4},{1,4,7},{5,7,8}};
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<arrs.length;i++){
			for(int j = 0 ;j<arrs[i].length;j++){
				heap.add(arrs[i][j]);
			}
		}

		System.out.println(Arrays.toString(heap.toArray()));
	}

}
