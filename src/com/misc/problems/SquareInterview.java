package com.misc.problems;


import java.io.*;
import java.util.*;

/*


ABSOLUTE URL:
CURRENT: http://a.com/b/c/d.html
LINK:    https://b.com/e/f/g.html
RESULT:  https://b.com/e/f/g.html
ABSOLUTE PATH:
CURRENT: http://a.com/b/c/d.html
LINK:    /e/f/g.html
RESULT:  http://a.com/e/f/g.html
RELATIVE PATH:
CURRENT: http://a.com/b/c/d.html
LINK:    e/f/g.html
RESULT:  http://a.com/b/c/e/f/g.html
RELATIVE PATH #2:
CURRENT: http://a.com/b/c/d.html
LINK:    ../../e/f/g.html
RESULT:  http://a.com/e/f/g.html
RELATIVE PATH #3:
CURRENT: http://a.com/b/c/d.html
LINK:    ../../e/f/../g.html
RESULT:  http://a.com/e/g.html
SCHEME:  a-z characters followed by a ':'.
https:  http:   ftp:  gopher:  mailto:  abcdefg:
AUTHORITY:  '//' followed by non-'/' characters
//squareup.com  //localhost  //127.0.0.1:8080
PATH: everything else
/register/items/index.html  ../../e/f/g.html
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 * 
 * If you need more classes, simply define them inline.
 */

class SquareInterview {
  public static void main(String[] args) {
   
     System.out.println("Output 1 "+whateverYouCallIt("http://a.com/b/c/d.html", "https://b.com/e/f/g.html"));
        //https://b.com/e/f/g.html

        System.out.println("Output 2 "+whateverYouCallIt("http://a.com/b/c/d.html", "/e/f/g.html"));
        //http://a.com/e/f/g.html

        System.out.println("Output 3 "+whateverYouCallIt("http://a.com/b/c/d.html", "e/f/g.html"));
        // http://a.com/b/c/e/f/g.html
        //done
        
        System.out.println("Output 4 "+whateverYouCallIt("http://a.com/b/c/d.html", "../../e/f/g.html"));
        // http://a.com/e/f/g.html
        
        System.out.println("Output 5 "+whateverYouCallIt("http://a.com/b/c/d.html", "../../e/f/../g.html"));
        // http://a.com/e/g.html
        
        System.out.println("Output 6 "+whateverYouCallIt("http://a.com/b/c/d.html", "https://b.com/e/f:///g.html"));
        // https://b.com/e/f:///g.html
        
        System.out.println("Output 7 "+whateverYouCallIt("http://a.com/b/c/d.html", "/e/f:///g.html"));
        // http://a.com/e/f:///g.html
    
  }
  
   public static String whateverYouCallIt(String currentURL,String linkURL){
        
        String output = "";
        String curProtocol = currentURL.split(":")[0];
        String linkProtocol = linkURL.split(":")[0];
     
     if(linkProtocol == ""){
       linkProtocol = curProtocol;
     }
        else  if(curProtocol.equals(linkProtocol)){
           output +=linkProtocol+"://";
         }
        else{
          output +=linkProtocol+"://";
        }
     
     String curServer = "";
     String linkServer = "";
     String curPath = "";
     String linkPath = "";
     
     if( currentURL.split("://").length>1){
       curServer = currentURL.split("://")[1].split("/")[0];
       curPath =  currentURL.substring(output.toCharArray().length);
     }
     
     if( linkURL.split("://").length>1){
       linkServer = linkURL.split("://")[1].split("/")[0];
        curPath =  currentURL.substring(output.toCharArray().length);
        linkPath = linkURL.substring(output.toCharArray().length);
     }
     
     if(linkServer == ""){
       output+=curPath;
     }
     else{
       output+=linkPath;
     }

        return output;
   
   }
  
}
