package com.amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructIternary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   public List<String> findItinerary(List<List<String>> tickets) {
	        
	        List<String> res = new LinkedList<>();
	        
	        Collections.sort(tickets, (List l1, List l2) -> {
	           
	            String str1 = (String) l1.get(1);
	            String str2 = (String) l2.get(1);
	            
	           return str1.compareTo(str2);
	            
	        });
	        
	        if(tickets.isEmpty() || tickets == null){
	            return res;
	        }
	        
	        res.add("JFK");
	        
	        Map<String, LinkedList<List<String>>> map = new HashMap<>();
	        
	        for(List<String> ticket : tickets){
	          
	            String src = ticket.get(0);
	     
	            
	            LinkedList<List<String>> list = map.getOrDefault(src,new LinkedList<>());
	            list.addLast(ticket);
	            map.put(src, list);
	            
	        }
	        
	        System.out.println(tickets);
	        System.out.println(map);
	        
	        LinkedList<List<String>> list = map.get("JFK");
	        
	        if(list == null){
	            return res;
	        }
	        
	        while(!list.isEmpty()){
	            String dest = list.removeFirst().get(1);
	            res.add(dest);
	            list = map.get(dest);
	        }
	        
	        return res;
	    }

}
