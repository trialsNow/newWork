package com.entrust.BinarySearchTree;

import java.util.HashMap;
/*
Logic: InOrder in hashmap for both cases..
InOrderPreOrder
Mid element is get(preOrd(0));. If mid > start build root left
If mid<end build righttree

InorderPost order
Mid element is get(postOrd(length-1))
Recurse post order r\backwards
 */

public class HashReconstructBinaryTree {

private static class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	private TreeNode(int data){
		this.data=data;
	}
}

public TreeNode buildPreOrderInOrderTree(int[] preorder, int[] inorder) {  
	   HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();  
	   int len = inorder.length;  
	   if (len < 1) return null;  
	   // map node value to its index in inorder results  
   for (int i=0; i<inorder.length; ++i) {  
     inorderMap.put(inorder[i], i);  
   }  
   return buildSubPreOrderInOrderTree(preorder, 0, inorderMap, 0, len-1);  
 }  

 private TreeNode buildSubPreOrderInOrderTree(int[] preorder, int cur,  
                HashMap<Integer, Integer> inorder, int start, int end) {  
   TreeNode root = new TreeNode(preorder[cur]);  
   if (start < end) { // if more than one node left  
     int mid = inorder.get(preorder[cur]);  
     if (mid > start) {  
       root.left = buildSubPreOrderInOrderTree(preorder, cur+1, inorder, start, mid-1);  
     }  
     if (mid < end) {  
       root.right = buildSubPreOrderInOrderTree(preorder, cur+mid-start+1, inorder, mid+1, end);  
     }  
   }  
   return root; // Base case: start==end, i.e. only one node, simply return it.  
 }  
 
 public TreeNode buildInOrderPostOrderTree(int[] inorder, int[] postorder) {  
	   int len = inorder.length;  
	   if (len == 0 || len != postorder.length) return null;  
	   // map inorder values to their indices  
	   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
	   for (int i=0; i<len; ++i) {  
	     map.put(inorder[i], i);  
	   }  
	   // build the tree  
	   // read postorder values backwards  
	   return buildInorderPostOrderSubTree(postorder, 0, len-1, len-1, map);  
	 }  
	   
	 private TreeNode buildInorderPostOrderSubTree(int[] postorder, int start, int end, int cur,  
	                HashMap<Integer, Integer> inorder) {  
	   if (start > end)  return null; // Base case: start > end, i.e. invalid index, return null

	   int val = postorder[cur];  
	   TreeNode root = new TreeNode(val);  
	   int mid = inorder.get(val);  
	   // read postorder values backwards  
	   root.left = buildInorderPostOrderSubTree(postorder, start, mid-1, cur-(end-mid)-1, inorder);  
	   root.right = buildInorderPostOrderSubTree(postorder, mid+1, end, cur-1, inorder);  

	   return root;  
	 } 
	 
	 public static void main (String[] args){
		 int[] pre = {1,2,4,5,3,6,7};
		 int[] in = {4,2,5,1,6,3,7};
		 HashReconstructBinaryTree h = new HashReconstructBinaryTree();
		 h.buildPreOrderInOrderTree(pre,in);
		 }
	 }
