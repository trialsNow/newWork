package com.entrust.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

/*PreOrder , In Order*/
public class ReconstructBinaryTree {
	
private class Node {
	int data;
	 Node left;
	 Node right;
	 
	 public Node(int data){
		 this.data=data;
	 }
	
}
	/*From the pre-order array, we know that first element is the root.
	We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.
    Using the length of left sub-tree, we can identify left and right sub-trees in pre-order array. Recursively, we can build up the tree*/
public Node buildTreeFromPreAndInOrder(int[] preorder, int[] inorder) {
    int preStart = 0;
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;
 
    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
}
 
public Node construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
        return null;
    }
 
    int rootVal = preorder[preStart];
    Node root = new Node(rootVal);
 
    //find parent element index from inorder
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(rootVal == inorder[i]){
            k=i;
            break;
        }
    }
 
    root.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
    root.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
    return root;
}

public Node buildTree(int[] inorder, int[] postorder) {
	int inStart = 0;
	int inEnd = inorder.length - 1;
	int postStart = 0;
	int postEnd = postorder.length - 1;
 
	return buildTreeFromInPostOrder(inorder, inStart, inEnd, postorder, postStart, postEnd);
}
 
public Node buildTreeFromInPostOrder(int[] inorder, int inStart, int inEnd,
		int[] postorder, int postStart, int postEnd) {
	if (inStart > inEnd || postStart > postEnd)
		return null;
 
	int rootValue = postorder[postEnd];
	Node root = new Node(rootValue);
 
	int k = 0;
	for (int i = 0; i < inorder.length; i++) {
		if (inorder[i] == rootValue) {
			k = i;
			break;
		}
	}
 // k-1 means items before root value
	root.left = buildTreeFromInPostOrder(inorder, inStart, k - 1, postorder, postStart,postStart + k - (inStart + 1));
	// Becuase k is not the length, it it need to -(inStart+1) to get the length
	root.right = buildTreeFromInPostOrder(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
	// postStart+k-inStart = postStart+k-(inStart+1) +1
 
	return root;
}


}
