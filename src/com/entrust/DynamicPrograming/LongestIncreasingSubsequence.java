package com.entrust.DynamicPrograming;

import java.util.*;
/*
 * For example, given [10, 9, 2, 5, 3, 7, 101, 18], the longest increasing subsequence is [2, 3, 7, 101]. T
 * herefore the length is 4.
Let max[i] represent the length of the longest increasing subsequence so far.
If any element before i is smaller than nums[i], then max[i] = max(max[i], max[j]+1).


 */
public class LongestIncreasingSubsequence {
	public static int usingDp(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	 
	    for(int i=0; i<nums.length; i++){
	        max[i]=1;
	        for(int j=0; j<i;j++){
	            if(nums[i]>nums[j]){
	                max[i]=Math.max(max[i], max[j]+1);
	            }
	        }
	    }
	 
	   /* int result = 0;
	    for(int i=0; i<max.length; i++){
	        if(max[i]>result)
	            result = max[i];
	    }*/
		return max[max.length-1];
	}
	/*
	 * or each num in nums
     if(list.size()==0)
          add num to list
     else if(num > last element in list)
          add num to list
     else 
          replace the element in the list which is the smallest but bigger than num
	 */
	public static int usingList(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>(); 
	 
	    for(int num: nums){
	        if(list.size()==0){
	            list.add(num);
	        }else if(num>list.get(list.size()-1)){
	            list.add(num);
	        }else{
	            int i=0; 
	            int j=list.size()-1;
	 
	            while(i<j){
	                int mid = (i+j)/2;
	                if(list.get(mid) < num){
	                    i=mid+1;
	                }else{
	                    j=mid;
	                }
	            }
	 
	            list.set(j, num);
	        }
	    }
	 
	    return list.size();
	}

	public static void main(String[] args){
		System.out.println(usingList(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}
}
