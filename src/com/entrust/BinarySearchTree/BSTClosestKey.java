package com.entrust.BinarySearchTree;

public class BSTClosestKey {
  private static Node root;
  
	private static class Node{
		int data;
		Node left;
		Node right;	
		private Node(int data){
			this.data = data;
		}
	
	}
	
	private static Node findClosest(int k){
		if (root.data == k) return root;
		return find (root,root,k,100);
	}
	
	private static Node find(Node closest,Node x,int k,int diff){
		int oldDiff = diff;
		Node oldClosest = closest;
		if (x==null || x.data==k) return closest;
		if (k<x.data) {	
			Node curr = x.left;
			if (curr==null) return closest;
			int newDiff = Math.abs(curr.data-k);
			if (newDiff>oldDiff){
			curr = oldClosest;
			} 
			return find(curr,x.left,k,newDiff);
		} else {
			Node curr = x.right;
			if (curr==null) return closest;
			int newDiff = Math.abs(curr.data-k);
			if (newDiff>oldDiff){
			curr = oldClosest;
			} 
			return find(curr,x.right,k,newDiff);
		}
	}
	
	
	public static void main (String[] args){
		root = new Node(10);
		root.left = new Node(8);
		root.left.left= new Node(7);
		root.left.right=new Node(9);
		root.right= new Node(12);
		root.right.left = new Node(11);
		root.right.right = new Node(13);
		System.out.println(findClosest(1).data);
		
	}
}
