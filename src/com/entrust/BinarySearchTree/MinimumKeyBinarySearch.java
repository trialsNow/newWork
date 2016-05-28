package com.entrust.BinarySearchTree;

	public class MinimumKeyBinarySearch<Key extends Comparable<Key>,Value>{
		   private Node root;
		private class Node {
		    private Key key;
		    private Value value;
		    private Node left;
		    private Node right;
		    
		    private Node(Key key,Value value) {
		        this.key = key;
		        this.value = value;
		    }
		}
		public MinimumKeyBinarySearch() {
		    
		}

		public void put(Key k,Value v){
		    root=put(root,k,v); 
		}

		public Node put(Node x,Key k,Value v){
		   if (x==null) {
		       x = new Node (k,v);
		   } else {
		       if (k.compareTo(x.key)<0){
		         x.left=  put(x.left,k,v);
		       } else if (k.compareTo(x.key)>0){
		           x.right= put(x.right,k,v);
		       } else {
		           x.value=v;
		       }
		   }
		   return x;
		}

		public void printAllKeys(){
		    printKeys(root);
		}

		public void printKeys(Node x){
		  if (x==null){return;}
		  System.out.println ("Nodes:"+ x.value);
		  printKeys(x.left);
		  printKeys(x.right);
		}

		public Key minKey(){
		   return min(root).key;
		}

		public Node min(Node x){
		    if (x.left== null) return x;
		    return min(x.left);
		    
		}

		public static void main (String[] args){
		  MinimumKeyBinarySearch<String,Integer> hi = new MinimumKeyBinarySearch<>();
		  hi.put("d",1);
		  hi.put("e",2);
		  hi.put("c",5);
		  hi.put("b",3);
		  hi.put("a",7);
		  hi.printAllKeys();
		  System.out.println (hi.minKey());
		  
		}
		    
		    
		}

