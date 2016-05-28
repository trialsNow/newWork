package com.entrust.ScenarioBased;

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
