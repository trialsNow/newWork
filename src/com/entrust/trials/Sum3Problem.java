package com.entrust.trials;

import java.util.*;

public class Sum3Problem {

			public int threeSumSmaller(int[] nums, int target) {
				if (nums == null || nums.length == 0) {
					return 0;
				}
				Arrays.sort(nums);
				int count = 0;
				for (int i = 0; i < nums.length - 2; i++) {
					int left = i + 1;
					int right = nums.length - 1;
					while (left < right) {
						if (nums[i] + nums[left] + nums[right] < target) {
							count+= right - left;
							left++;
						}
						if (nums[i] + nums[left] + nums[right] >= target) {
							right--;
						}
					}
				}
				return count;
			}

	public static void main(String[] args){
		int[] a = {1,2,3,4,-2,-1,-5};
		Map<String,Integer> map = new HashMap<>();
		
		for (int i=0;i<a.length;i++){
			for (int k=i+1;k<a.length;k++){
				//System.out.println(a[i]+a[k]);
				map.put(a[i]+"  "+a[k],a[i]+a[k]);
			}
		}
		 
		
		for (int j=0;j<a.length;j++){
			int temp = -a[j];
			for (Map.Entry<String, Integer> entry:map.entrySet()){
				if (entry.getValue()==temp){
					System.out.println(entry.getKey()+"  "+temp);
				}
			}
		}
	}


}
