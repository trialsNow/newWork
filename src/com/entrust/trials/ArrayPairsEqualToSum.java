package com.entrust.trials;
//Java implementation using Hashing

import java.util.*;

public class ArrayPairsEqualToSum
{

 // Main to test the above function
 public static void main (String[] args)
 {
     int a[] = {5,4,7,8,1,2,12,10,12};  
     int n = 14;
     Map<Integer,Integer> map = new HashMap<>();
     for (Integer i=0; i <a.length;i++){
    	 //Key : 1; Value: 1-16:-15
    	 map.put(a[i],n-a[i]);
     }
     for (Integer i=0; i <a.length;i++){
    	if (map.containsValue(a[i])){
    		System.out.print(a[i]);
    		System.out.print(a[i]-n);
    	}
    	System.out.println();
     }
     
 }
}