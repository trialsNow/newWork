package com.entrust.trials;

import java.util.*;


public class SerializeBinaryTree {

	TreeNode root;


	/* Class to represent Tree node */
	private static class TreeNode {
	 int val;
	 TreeNode left, right;

	 public TreeNode(int item) {
	     val = item;
	     left = null;
	     right = null;
	 }
	 
	}
	
	public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

private static void serialize(TreeNode node, StringBuilder sb){
    if (node == null) {
        sb.append("# ");
    } else {
        sb.append(node.val + " ");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}

public static TreeNode deserialize(String s){
    if (s == null || s.length() == 0) return null;
    StringTokenizer st = new StringTokenizer(s, " ");
    return deserialize(st);
}

private static TreeNode deserialize(StringTokenizer st){
    if (!st.hasMoreTokens())
        return null;
    String val = st.nextToken();
    if (val.equals("#"))
        return null;
    TreeNode root = new TreeNode(Integer.parseInt(val));
    System.out.println(root.val);
    root.left = deserialize(st);
    root.right = deserialize(st);
    return root;
} 


public static void main(String args[]) 
{
    /* creating a binary tree and entering 
     the nodes */
	SerializeBinaryTree tree_level = new SerializeBinaryTree();
    tree_level.root = new TreeNode(1);
    tree_level.root.left = new TreeNode(2);
    tree_level.root.right = new TreeNode(3);
    tree_level.root.left.left = new TreeNode(4);
    tree_level.root.left.right = new TreeNode(5);
    tree_level.root.left.left.left = new TreeNode(8);
    String ser =serialize(tree_level.root);
    System.out.println(ser);
    deserialize(ser);
    
}
}
