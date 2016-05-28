package com.entrust.BinarySearchTree;

import java.util.*;

/**
 * Created by rathna on 2016-05-26.
 */
public class BalancedBinaryTree{
    private Node root;

    private static class Node<Item extends Comparable>{
        Node left;
        Node right;
        Item data;

        public Node(Item data){
            this.data=data;
        }

    }

    public boolean isDepthConsistent(Node root){
        return height(root) == 1;
    }

    public int height(Node n){
        if (n==null) return 0;
        return 1+(Math.abs(height(n.left)-height(n.right)));
    }

    public static void main(String[] args){
        BalancedBinaryTree bst = new BalancedBinaryTree();
        bst.root = new Node(10);
        bst.root.left = new Node(6);
        bst.root.left.left = new Node(5);
        //bst.root.left.right= new Node(7);
        bst.root.right= new Node(13);
        bst.root.right.left = new Node(12);
        //bst.root.right.right= new Node(15);
        System.out.println(bst.isDepthConsistent(bst.root));
    }
}
