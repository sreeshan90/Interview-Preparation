package com.leetcode.revise;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class AllNodesAtDistanceK {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        buildAdjList(root);

        return bfs(target, K);
    }

    public List<Integer> bfs(TreeNode target, int K) {

        List<Integer> res = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList();

        q.offer(target.val);

        int level = 0;

        while(!q.isEmpty()) {

            //  process the current level - denoted by the queue contents
            int n = q.size();

            for(int i=0;i<n; i++) {

                Integer node = q.poll();
                // already seen - do nothing
                if(visited.contains(node)){
                    continue;
                }
                else{ // add this to visited to avoid infinite loop
                    visited.add(node);
                }
                // if the requesired level  - add to the result
                if(level == K) {
                    res.add(node);
                    continue;
                }

                // get the adjacency lsit of the current node
                List<Integer> adjacent = (List) map.get(node);
                // if empty continue with next iteration
                if(adjacent==null) {
                    continue;
                }
                // populate the queue with thew next levl elements
                for(Integer adjacentNodes : adjacent) {
                    q.offer(adjacentNodes);
                }
            }
            level++;
        }

        return res;
    }

    public  void buildAdjList(TreeNode root) {

        map.putIfAbsent(root.val, new LinkedList());

        if(root.left!=null) {
            map.putIfAbsent(root.left.val, new LinkedList());
            // add left child
            map.get(root.left.val).add(root.val);

            // add the parent
            map.get(root.val).add(root.left.val);
            buildAdjList(root.left);
        }

        if(root.right!=null) {
            map.putIfAbsent(root.right.val, new LinkedList());
            map.get(root.right.val).add(root.val);
            map.get(root.val).add(root.right.val);
            buildAdjList(root.right);
        }

    }
}
