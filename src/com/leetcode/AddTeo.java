package com.leetcode;
public class AddTeo {

	 public static ListNode addTwo(ListNode l1, ListNode l2){
	        //init result
	        ListNode l1Head = l1;
	        ListNode l2Head = l2;
	 
	        ListNode res = new ListNode(0);
	        //result sum
	        ListNode resHead = res;
	        //traverse both the lists
	            while(l1 != null && l2 != null){
	                int sum = l1.val+l2.val+res.val;
	                int carry = sum/10;
	                //holds sum for current digit processing
	                res.val = sum%10; 
	                //create new node holding the carry over of previous sum
	                res.next = new ListNode(carry);
	                res = res.next;
	                l1=l1.next;
	                l2=l2.next;
	            }

	            //lenghts of input list differ - check which is left out and add
	            if(l1!=null){
	                while(l1!=null){
	                    int sum = l1.val+res.val;
	                    int carry = sum/10;

	                    res.val = sum%10;
	                    res.next = new ListNode(carry);
	                    res = res.next;
	                    l1 = l1.next;

	                }
	            }
	            else if(l2 != null){
	                while(l2!=null){
	                    int sum = l2.val+res.val;
	                    int carry = sum/10;

	                    res.val = sum%10;
	                    res.next = new ListNode(carry);
	                    res = res.next;
	                    l2 = l2.next;

	                }
	            }

	        ListNode head = resHead;

	        //to return result head, move to the beginning of result linked list
	        int maxLength = Integer.max(getHop(l1Head), getHop(l2Head));

	            while(maxLength>1){
	                maxLength--;
	                head=head.next;
	            }

	            if(head.next.val==0){
	                head.next = null;
	            }

	                return resHead;
	    }

	    //function that tells how many hops i need to make to reach head
	    public static int getHop(ListNode node){
	        int hops = 0;

	        while(node!=null){
	            hops++;
	            node = node.next;
	        }

	        return hops;
	    }
}