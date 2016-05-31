package com.entrust.BinarySearchTree;

public class RotatedBinarySearch {
	
	int rotated_binary_search(int A[], int N, int key) {
		  int L = 0;
		  int R = N - 1;
		 
		  while (L <= R) {
		    // Avoid overflow, same as M=(L+R)/2
		    int M = L + ((R - L) / 2);
		    if (A[M] == key) return M;
		 
		    // the bottom half is sorted
		    if (A[L] <= A[M]) {
		      if (A[L] <= key && key < A[M])
		        R = M - 1;
		      else
		        L = M + 1;
		    }
		    // the upper half is sorted
		    else {
		      if (A[M] < key && key <= A[R])
		        L = M + 1;
		      else
		        R = M - 1;
		    }
		  }return -1;
		}
	
//How much rotated in ascending order or find minimum element.
//If the middle element is greater than the right most element, 
//then the pivot must be to the right; if it is not, the pivot must 
//be to the left
	
	int FindSortedArrayRotation(int A[], int N) {
	  int L = 0;
	  int R = N - 1;
	  
	  while (A[L] > A[R]) {
	    int M = L + (R - L) / 2;
	    if (A[M] > A[R])
	      L = M + 1;
	    else
	      R = M;
	  }
	  return L;
	}

	public static int searchTargetinRotatedSortedArray(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
	}

	public static int binarySearch(int[] nums, int left, int right, int target){
		if(left>right)
			return -1;

		int mid = left + (right-left)/2;

		if(target == nums[mid])
			return mid;

		if(nums[left] <= nums[mid]){
			if(nums[left]<=target && target<nums[mid]){
				return binarySearch(nums,left, mid-1, target);
			}else{
				return  binarySearch(nums, mid+1, right, target);
			}
		}else {
			if(nums[mid]<target&& target<=nums[right]){
				return  binarySearch(nums,mid+1, right, target);
			}else{
				return  binarySearch(nums, left, mid-1, target);
			}
		}
	}
	   public static void main(String[] args){
		   System.out.println(searchTargetinRotatedSortedArray(new int[]{2,3,3,0,1},1));
	   }
}
