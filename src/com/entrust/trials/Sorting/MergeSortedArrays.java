package com.entrust.trials.Sorting;

import java.util.Arrays;

public class MergeSortedArrays {
	
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = a.length - 1, j = b.length - 1, k = answer.length;

	    while (k > 0) {
			if ( j<0 || (i>=0 && a[i]>=b[j])){
				answer[--k] =a[i--];
			} else {
				answer[--k] =b[j--];
			}
	        //answer[--k] =
	          //  (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
	    }
	    return answer;
	}
	
	public static void main(String[] args){
		int[] a = {1,5,8,10};
		int[] b= {2,3,4,7};
		System.out.println(Arrays.toString(merge(a,b)));
	}
	
}
