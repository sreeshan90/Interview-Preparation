package com.leetcode;

import java.util.*;

public class DuplicatesInFS {

    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {

            // resolve paths
            if (paths.length == 0) {
                return null;
            }

            Map<String, List<String>> pathsMap = new HashMap<>();

            for (String path : paths) {

                String[] str = path.split(" ");

                String folderPath = str[0];

                for (int i = 1; i < str.length; i++) {
                    int index = str[i].indexOf("(");

                    String filePath = folderPath + "/" + str[i].substring(0, index);
                    String content = str[i].substring(index + 1, str[i].length() - 1);
                    pathsMap.putIfAbsent(content, new LinkedList());
                    pathsMap.get(content).add(filePath);
                }
            }


            List<List<String>> result = new ArrayList<>();

            for (Map.Entry<String, List<String>> entry : pathsMap.entrySet()) {

                if (entry.getValue().size() > 1) {
                    result.add(entry.getValue());
                }
            }

            return result;
        }
    }
}
