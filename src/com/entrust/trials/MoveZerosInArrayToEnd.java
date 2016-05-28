package com.entrust.trials;

import java.util.*;

public class MoveZerosInArrayToEnd {

	static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;  // Count of non-zero elements
 
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i]; // here count is
                                       // incremented
 
        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }
	
	public static void main(String[] args){
		/*List<Integer> intLst = new LinkedList<Integer>
								(Arrays.asList((new Integer[]{0,0,1,2,0,0,0,3,4,5})));
		
		Collections.sort(intLst,Collections.reverseOrder());*/
		
		int[] test={5,0,3,4};
		pushZerosToEnd(test,test.length);
		for (Integer entry:test){
			System.out.print(entry+"");
		}
	}
	
}
