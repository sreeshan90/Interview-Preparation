package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Points_To_Origin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 3;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int[] dist = {2,4,1,4,7,2,6};
		
		for(int d : dist){
			maxHeap.add(d);
			if(maxHeap.size()>k){
				maxHeap.poll();
			}
		}
		
		System.out.println(Arrays.toString(maxHeap.toArray()));
		
	}
	
	 public int[][] kClosest(int[][] points, int K) {
	     
	        
	        PriorityQueue<int[]> heap = new PriorityQueue(new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					int[] a = (int[]) o1;
					int[] b = (int[]) o2;
					 return b[0]*b[0]+b[1]*b[1]-(a[0]*a[0]+a[1]*a[1]);
				}
	        	
	        });
	        
		// PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0]*b[0]+b[1]*b[1]-(a[0]*a[0]+a[1]*a[1])));
				 
	        for(int[] point : points){
	            heap.add(point);
	            
	            if(heap.size()>K){
	                heap.poll();
	            }
	        }
	        
	        int[][] res = new int[K][2];
	        
	        while(K>0){
	            res[K] = heap.poll();
	            K--;
	        }
	        
	        return res;
	        
	    }

}
