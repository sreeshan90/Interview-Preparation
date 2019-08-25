package com.leetcode;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String test = "aaabaaaa";


        System.out.println(test.lastIndexOf('a'));
    }

    public String longestPalindrome(String s) {

        if(s.length() == 0){
            return s;
        }

        if(s.length() == 1){
            return s;
        }

        int res = 0;
        char[] arr = s.toCharArray();
        String palin = ""+arr[0]+"";
        //String palin = "";

        for(int i=0;i<arr.length;i++){

            for(int j = s.lastIndexOf(""+arr[i]+"");j>=0;j--){

                if(isPalindrome(arr,i,j)){

                    if(j-i > res){
                        palin = s.substring(i,j+1);
                        res = j-i;
                    }

                }
            }


        }

        return palin;
    }

    public boolean isPalindrome(char[] arr, int i, int j){
        if(arr.length == 0 || arr.length == 1){
            return true;
        }

        while(i<j){

            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
