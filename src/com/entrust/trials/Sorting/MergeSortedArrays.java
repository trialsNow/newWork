package com.entrust.trials.Sorting;

import java.util.Arrays;

public class MergeSortedArrays {
	
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = 0, j =0, k = 0;

	    while (k < answer.length) {
			if ( j>=b.length || (i<a.length && a[i] <= b[j])){
				answer[k] =a[i];
				i++;
				k++;
			} else {
				answer[k] =b[j];
				j++;
				k++;
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
