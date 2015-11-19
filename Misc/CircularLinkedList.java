package com.misc.practice;


/*
 *Circular LinkedList class implementation
 *  
 *  @author - sreesha nagaraj
 *  */


public class CircularLinkedList {

	    class Node{
		
		private int elem;
		private Node next;
		
		public Node(int elem) {
			// TODO Auto-generated constructor stub
			
			this.elem = elem;
			this.next = null;
		}
		
		public int getElem() {
			return elem;
		}
		public void setElem(int elem) {
			this.elem = elem;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	    
		protected Node head ;
	    protected Node tail ;
	    public int size ;
	    
	    
	    public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}

		public Node getTail() {
			return tail;
		}

		public void setTail(Node tail) {
			this.tail = tail;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
		
		    
	
	public void insertHead(int val){
		
		Node newNode = new Node(val);
		
		if(null==head){
			head = newNode;
			newNode.setNext(head);
			tail =  head;
		}
		else{
			newNode.setNext(head);
			head = newNode;
			tail.next =  head;
		}
		
		size++;
		
		
	}
	
	public   void  insertTail(int val){
		
		Node newNode = new Node(val);
		
		if(null==tail){
			tail = newNode;
			newNode.setNext(tail);
			head =  tail;
		}
		else{
			tail.setNext(newNode);
			tail = newNode;
			tail.next =  head;
		}
		
		size++;
	}
	
	
	
	
}

