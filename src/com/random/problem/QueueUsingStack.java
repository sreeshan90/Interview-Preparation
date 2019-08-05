package com.random.problem;

import java.util.Stack;

public class QueueUsingStack {



	
	public static void main(String  args[])
	{

		 Stack<Integer> st1 = new Stack<>();
		 Stack<Integer> st2 = new Stack<>();

	insert(5,st1);
	insert(6,st1);
	insert(7,st1);
	insert(8,st1);
	System.out.println(delete(st1,st2));
	System.out.println(delete(st1,st2));
	insert(9,st1);
	System.out.println(delete(st1,st2));

	}

	public static void insert(Integer val, Stack st1){

	if(null != st1)
	st1.push(val);


	}                  

	public static int delete (Stack st1, Stack st2){


	if(st1.isEmpty()){
	return -1;
	}
	//delete

	while(!st1.isEmpty()){

	st2.push(st1.pop());

	}

	int retValue = (int) st2.pop();
	
	while(!st2.isEmpty()){

		st1.push(st2.pop());

		}

	return retValue;

	}                                          
}
