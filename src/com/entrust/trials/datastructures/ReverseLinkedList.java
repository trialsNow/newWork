package com.entrust.trials.datastructures;

public class ReverseLinkedList{
   static Node head,tail =null;
   int N=0;
   
   public ReverseLinkedList(){
	   head = new Node();
	   tail= new Node();
	   head.next=tail;
	   head.previous=null;
	   tail.previous=head;
	   tail.next=null;
   }
   
	private static class Node {
		Node next;
		Node previous;
		int data;
		
		public Node(){
			
		}
		public Node(int data){
			this.data=data;
		}
	}
	
	public void add(int data){
		Node n = new Node(data);
		Node temp = tail.previous;
		temp.next=n;
		n.next=tail;
		n.previous=temp;
		tail.previous=n;
		N++;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void reverse(){
		while (head != null) {
	        Node temp = head.next;
	        head.next = head.previous;
	        head.previous = temp;
	        if (temp == null)
	            break;
	        head = temp;
	    }
		
	}
	
	public void print(Node n){
		while (n!=null){
			System.out.print(n.data+ "  ");
			n=n.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseLinkedList dbl = new ReverseLinkedList();
		dbl.add(10);
		dbl.add(9);
		dbl.add(8);
		dbl.add(7);
		dbl.print(head);
	    dbl.reverse();
		System.out.println();
		dbl.print(head);
	}

}
