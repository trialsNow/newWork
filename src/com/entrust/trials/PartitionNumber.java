package com.entrust.trials;

import java.util.*;

/******************************************************************************
 *  Compilation:  javac Partition
 *  Execution:    java Partition N
 *
 *  Print out all partitions of a positive integer N. In number theory,
 *  a partition of N is a way to write it as a sum of positive integers.
 *  Two sums that differ only in the order of their terms are considered
 *  the same partition.
 *
 *  % java Partition 4
 *  4
 *  3 1
 *  2 2
 *  2 1 1
 *  1 1 1 1
 *
 *  % java Partition 6
 *  6
 *  5 1
 *  4 2
 *  4 1 1
 *  3 3
 *  3 2 1
 *  3 1 1 1
 *  2 2 2
 *  2 2 1 1
 *  2 1 1 1 1
 *  1 1 1 1 1 1
 *
 ******************************************************************************/

public class PartitionNumber { 

    public static void partition(int n) {
        partition(n, n, "");
    }
    // Recursive Algorithm
    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }
  
        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, prefix + " " + i);
        }
    }

    // Bottom up DP
    public static void bottomUpDp(int n){
    	Map<Integer,String> mem = new HashMap<Integer,String>();
    	mem.put(1,""+1);
    	for (int i=2;i<n;i++){
    		mem.put(i,mem.get(i-1)+1);
    	}
    	for (Map.Entry<Integer, String> e: mem.entrySet()){
    		System.out.println(e.getValue());
    	}
    	/*while (n!=0){
    		n = n-(n-1);
    	}*/
    	
    }

    public static void main(String[] args) { 
        int N = 15;
       partition(N);
       //bottomUpDp(25);
    }

}
