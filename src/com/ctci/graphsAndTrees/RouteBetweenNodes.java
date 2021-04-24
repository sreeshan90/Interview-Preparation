package com.ctci.graphsAndTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        if (s.equals(t)) {
            return true;
        }

        for(DirectedGraphNode neighbor : s.neighbors) {
            queue.offer(neighbor);
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();

            if (node == t) {
                return true;
            }

            for(DirectedGraphNode neighbor : node.neighbors) {
                queue.offer(neighbor);
            }

        }

        return false;


    }
}
