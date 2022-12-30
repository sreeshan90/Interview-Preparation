package com.leetcode.lc75;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(null==root){
            return res;
        }
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> cq = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        pq.add(root);

        while(!pq.isEmpty()) {
            TreeNode parent = pq.remove();

            if(null!=parent){
                level.add(parent.val);
                if(null!=parent.left)  cq.add(parent.left);
                if(null!=parent.right) cq.add(parent.right);
            }

            if(pq.isEmpty()){
                pq = new LinkedList<>(cq);
                cq.clear();
                res.add(level);
                level = new ArrayList<>();
            }
        }

        return res;
    }
}
