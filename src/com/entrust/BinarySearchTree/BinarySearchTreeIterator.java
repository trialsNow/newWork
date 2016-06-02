package com.entrust.BinarySearchTree;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

import java.util.*;
public class BinarySearchTreeIterator<Integer> implements Iterable{
    TreeNode root;

    @Override
    public Iterator iterator(){

        return new BSTIterator(root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


        public class BSTIterator implements Iterator<java.lang.Integer> {
            Stack<TreeNode> stack;

            public BSTIterator(TreeNode root) {
                stack = new Stack<TreeNode>();
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public java.lang.Integer next() {
                TreeNode node = stack.pop();
                int result = node.val;
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
                return result;
            }
        }
    }

