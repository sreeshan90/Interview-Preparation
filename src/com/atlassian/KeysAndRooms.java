package com.atlassian;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean visited[] = new boolean[rooms.size()];

        Stack<Integer> st = new Stack<>();
        visited[0] = true;
        st.push(0);

        while(!st.isEmpty()) {

            int node = st.pop();

            List<Integer> keys = rooms.get(node);

            for (int key : keys) {

                if (!visited[key]) {
                    visited[key] = true;
                    st.push(key);
                }
            }

        }

        for (boolean v : visited ) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}
