package com.leetcode;

import java.util.*;

public class NodesAtDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Map<TreeNode, TreeNode> map = new HashMap<>();

        populateMap(root,map,null);


        Queue<TreeNode> q = new LinkedList<>();

        Set<TreeNode> set = new HashSet<>();

        q.offer(target);
        set.add(target);

        int level = 0;

        while(!q.isEmpty()){


            if(level == K){
                break;
            }

            int n = q.size();

            //process all nodes in the level

            for(int i = 0; i<n ; i++){

                TreeNode node = q.poll();

                if(node.left!=null && !set.contains(node.left)){

                    set.add(node.left);
                    q.offer(node.left);

                }
                if(node.right!=null && !set.contains(node.right)){

                    set.add(node.right);
                    q.offer(node.right);

                }

                if(map.get(node) != null && !set.contains(map.get(node))){

                    set.add(map.get(node));
                    q.offer(map.get(node));

                }
            }

            level++;

        }

        //the q will have the nodes at level K

        return getListOfVals(q);

    }

    private List<Integer> getListOfVals(Queue<TreeNode> q){

        List<Integer> list = new ArrayList<>();

        if(q.isEmpty()){
            return list;
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }

        return list;

    }
    private void populateMap(TreeNode node, Map<TreeNode, TreeNode> map, TreeNode parent) {


        if(node == null){
            return;
        }


        map.put(node, parent);


        populateMap(node.left,map, node);
        populateMap(node.right,map, node);

    }

}
