package com.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {

	}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int res = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            
           for(int i=0;i<queue.size();i++){
               String word = queue.poll();
               
               if(word.equals(endWord)){
                   return res+1;
               }
               
                 char[] cArr = word.toCharArray();
               
                   for(int k=0;k<cArr.length;k++){

                     for(char ch = 'a'; ch!='z';ch++){
                         
                         cArr[k] = ch;
                         
                         String s = new String(cArr);
                         
                         if(set.contains(s) && !s.equals(word)){
                             queue.offer(s);
                             set.remove(s);
                         }
                   }  
               }
               
           } 
            
            res++;
           
          }
        
        return 0;
            
        }  

}
