package com.entrust.ScenarioBased;

/*
Starting from the above description, we can see that:
1. This problem requires the max sum.
2. Original index of any two elements in the subset cannot be adjacent.

So, from the two observation, we have some further observations:
1. Order is not important. (because we need the sum)
2. For each element (say ith element) in the original array,  i-1 element cannot be included (neither does the i+1 th element).
3. Since all numbers are non-negative, the max sum before ith element (say S[i]), is max(S[i-2], S[i-3]).
    Why not considering S[i-4] S[i-5]... but just the last 2 and last 3 elements?
    Because S[i-2] = max(S[i-4], S[i-5]) + A[i-2], all numbers are >=0
    So S[i-2] >= S[i-5]
4. Therefore, we can write down the DP transition function:

S[i] = max(S[i-2], S[i-3]) + A[i]

The initialization of this problem is pretty straightforward, we use S[i] denote the
 max sum before A[i+1],  so S[1] = A[0], S[2] = A[1].    The final results is max(S[N], S[N-1]),
 N is the number of elements in A.
 */

public class Robber {
	public static int rob(int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    if(nums.length==1)
	        return nums[0];
	 
	    int[] dp = new int[nums.length];
	    dp[0]=nums[0];
	    dp[1]=Math.max(nums[0], nums[1]);
	 
	    for(int i=2; i<nums.length; i++){
	        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
	    }
	 
	    return dp[nums.length-1];
	}
	public static int robIterative(int[] num) {  
	     if(num == null || num.length == 0) return 0;  
	     // base case  
	     int pre = 0;  
	     int cur = num[0];  
	     // iteration  
	     for(int i = 2;i <= num.length;i++){  
	       int temp = cur;  
	       cur = Math.max(cur, pre + num[i-1]);  
	       pre = temp;  
	     }  
	     return cur;  
	   }  
	
	public static void main(String[] args){
		System.out.println(rob(new int[] {7000,2000,10000,8000,3000}));
		System.out.println(robIterative(new int[] {7000,2000,10000,8000,3000}));
	}
}
