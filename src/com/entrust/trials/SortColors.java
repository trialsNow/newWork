package com.entrust.trials;

/**
 *Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
import java.util.*;
public class SortColors {
    public static PriorityQueue sortColors(int[] nums) {
        PriorityQueue<Integer> sortedPq = new PriorityQueue<>();

        for (Integer i : nums) {
            sortedPq.offer(i);
        }
        return sortedPq;
    }

       /* if(nums==null||nums.length<2){
            return nums;
        }

        int[] countArray = new int[3];
        for(int i=0; i<nums.length; i++){
            countArray[nums[i]]++;
        }

        int j = 0;
        int k = 0;
        while(j<=2){
            if(countArray[j]!=0){
                nums[k++]=j;
                countArray[j] = countArray[j]-1;
            }else{
                j++;
            }
        }
        return nums;
    }*/
    public static void main(String[] args){
     PriorityQueue<Integer> rslt = sortColors(new int[]{1,2,0,2,1,0,2,2,1});
        while(!rslt.isEmpty()) {
            System.out.println(rslt.poll());
        }

    }
}
