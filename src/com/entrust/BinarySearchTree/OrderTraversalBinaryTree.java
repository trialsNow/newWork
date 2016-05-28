package com.entrust.BinarySearchTree;
/*Level Order traversal(Breadth first) is like this by level
              5
           4        6
        3    7     2  8
                     1  
 so output shud be 5,4,6,3,7,2,8,1
 
 Pre Order (Depth First) is Parent nodes go first and then the child nodes.
 Root first left sub tree and then right subtree
 
 Post Order ==> Left Child --> Right Child --> Parent --> Root
 Inorder ==> Left tree --> root --> Right tree
 
 Pre-order[edit]
Display the data part of the root (or current node).
Traverse the left subtree by recursively calling the pre-order function.
Traverse the right subtree by recursively calling the pre-order function.

In-order[edit]
Traverse the left subtree by recursively calling the in-order function.
Display the data part of the root (or current node).
Traverse the right subtree by recursively calling the in-order function.
In a search tree, in-order traversal retrieves data in sorted order.[4]

Post-order[edit]
Traverse the left subtree by recursively calling the post-order function.
Traverse the right subtree by recursively calling the post-order function.
Display the data part of the root (or current node).
*/
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


/* Class to print Level Order Traversal */
public class OrderTraversalBinaryTree {

 Node root;


/* Class to represent Tree node */
private static class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = null;
     right = null;
 }
 
}


 /* Given a binary tree. Print its nodes in level order
  using array for implementing queue  */
 void printLevelOrder(Node root) 
 {
     Queue<Node> queue = new LinkedList<Node>();
     queue.add(root);
     while (!queue.isEmpty()) 
     {

         /* poll() removes the present head.
         For more information on poll() visit 
         http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
         Node tempNode = queue.poll();
         System.out.print(tempNode.data + " ");

         /*Enqueue left child */
         if (tempNode.left != null) {
             queue.add(tempNode.left);
         }

         /*Enqueue right child */
         if (tempNode.right != null) {
             queue.add(tempNode.right);
         }
     }
 }
 
void preOrder(Node root){
	 if (root==null) return;
	 System.out.print(root.data+" ");
	 preOrder(root.left);
	 preOrder(root.right);
 }

public void preorderTraversalNonRecursive(Node root) {
    if(root == null)
        return;

    Stack<Node> stack = new Stack<Node>();
    stack.push(root);

    while(!stack.empty()){
        Node n = stack.pop();
        System.out.print(n.data+" ");

        if(n.right != null){
            stack.push(n.right);
        }
        if(n.left != null){
            stack.push(n.left);
        }

    }
}

public void postOrderTraversalUsingStack (Node root){
	if (root==null){
		return;
	} 
	Stack<Node> stack = new Stack<> ();
	stack.push(root);
	while (!stack.isEmpty()){
		Node inter = stack.peek();
		if (inter.left==null && inter.right==null){
			System.out.print(stack.pop().data+"");
		}
		else  {
			if (inter.right !=null){
		stack.push(inter.right);
		inter.right=null;
		}
		if (inter.left !=null){
			stack.push(inter.left);
			inter.left=null;
		}
	}
	}
	
}

public void inOrderTraversal(Node root){
	if (root==null) return;
	Node prev =null;// To check if BST
	Stack<Node> stack = new Stack<>();
	Node p = root;
	while (!stack.isEmpty() || p!=null){
		if (p!=null){
			stack.push(p);
			p = p.left;
		} else {
			Node poppedNode = stack.pop();
			System.out.print(poppedNode.data+" ");
			if (prev!=null && prev.data>poppedNode.data){
				System.out.println("Not a BST");
			}
			else {
				prev=poppedNode;
			}
			p = poppedNode.right;
		}
	}
	
	
}

 public static void main(String args[]) 
 {
     /* creating a binary tree and entering 
      the nodes */
	 OrderTraversalBinaryTree tree_level = new OrderTraversalBinaryTree();
    /* tree_level.root = new Node(1);
     tree_level.root.left = new Node(2);
     tree_level.root.right = new Node(3);
     tree_level.root.left.left = new Node(4);
     tree_level.root.left.right = new Node(5);
     tree_level.root.left.left.left = new Node(8);*/
	 tree_level.root = new Node(10);
     tree_level.root.left = new Node(6);
     tree_level.root.left.left = new Node(5);
     tree_level.root.left.right = new Node(9);
     tree_level.root.right = new Node(12);
     tree_level.root.right.left= new Node(11);
     tree_level.root.right.right= new Node(14);
     
     System.out.print("In order traversal of binary tree using Queue - ");
     tree_level.inOrderTraversal(tree_level.root);
     System.out.println("");
     System.out.println("Level order traversal of binary tree is - ");
     tree_level.printLevelOrder(tree_level.root);
     System.out.println("");
     System.out.print("Pre order traversal of binary tree is - ");
     tree_level.preOrder(tree_level.root);
     System.out.println("");
     System.out.print("Pre order traversal of binary tree using Stack - ");
     tree_level.preorderTraversalNonRecursive(tree_level.root);
     System.out.println("");
     System.out.print("Post order traversal of binary tree using Stack - ");
     tree_level.postOrderTraversalUsingStack(tree_level.root);
     System.out.println("");
     
 }
}