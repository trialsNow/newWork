package com.entrust.BinarySearchTree;

/**
 * Created by rathna on 2016-05-26.
 */
public class InvertBinaryTree {
    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        private TreeNode(int data){
            this.data = data;
        }

    }
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            helper(root);
        }

        return root;
    }

    public void helper(TreeNode p){

        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left!=null)
            helper(p.left);

        if(p.right!=null)
            helper(p.right);
    }

}
