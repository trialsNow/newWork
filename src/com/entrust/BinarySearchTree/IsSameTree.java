package com.entrust.BinarySearchTree;

/**
 * Created by rathna on 2016-05-30.
 */
public class IsSameTree {
    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        private TreeNode(int data){
            this.data = data;
        }

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }

        if(p.data==q.data){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }

}
