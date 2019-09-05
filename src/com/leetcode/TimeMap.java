package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Value{

    public String value;
    public int timeStamp;

    public Value(String value, int timeStamp){
        this.value=value;
        this.timeStamp = timeStamp;
    }
}
public class TimeMap {

    /** Initialize your data structure here. */

    Map<String, List<Value>> map;

    public TimeMap() {

        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Value> list =  map.getOrDefault(key, new ArrayList<>());
        list.add(new Value(value,timestamp));
        map.put(key,list);
    }

    public String get(String key, int timestamp) {

        List<Value> list = map.get(key);

        if(list == null || list.isEmpty()){
            return "";
        }

        int i=0;

        while(list.get(i).timeStamp <= timestamp){
            i++;
        }

        return list.get(i).value;


    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */