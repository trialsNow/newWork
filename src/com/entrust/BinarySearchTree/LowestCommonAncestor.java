package com.entrust.BinarySearchTree;

public class LowestCommonAncestor {
	

/* Class to represent Tree TreeNode */
private static class TreeNode {
 int key;
 TreeNode left, right;

 public TreeNode(int key) {
     this.key = key;
     left = null;
     right = null;
 }
 
}
	public static TreeNode LowestCommonAnchestorBST(TreeNode root, final TreeNode p, final TreeNode q) {
	    if (root == null) {
	        return null;
	    }

	    while (root != null) {
	        if (root.key > p.key && root.key > q.key) {
	            root = root.left;
	        } else if (root.key < p.key && root.key < q.key) {
	            root = root.right;
	        } else {
	            return root;
	        }
	    }
	    return null;
	}
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(10);
	     root.left = new TreeNode(6);
	      root.left.left = new TreeNode(5);
	      root.left.right = new TreeNode(9);
	      root.right = new TreeNode(12);
	      root.right.left= new TreeNode(11);
	      root.right.right= new TreeNode(14);
	      
	      System.out.println(LowestCommonAnchestorBST(root,new TreeNode(5),new TreeNode(9)).key);
	}

}
