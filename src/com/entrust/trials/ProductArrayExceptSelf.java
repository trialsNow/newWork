package com.entrust.trials;

/**
 * One solution is to maintain to arrays, to maintain the product before a[i] and after a[i].
 i.e, for a[i], we have product of a[0] * a[1] * ... * a[i - 1], and a[n - 1] * ... * a[i + 1].
 Therefore we can iterate the nums array forward and backward order, respectively.
 And for result[i] = before[i] * after[i].
 The only difference is we do the in-place. First of all, we iterate the nums array in forward and update the partial result.
 Then iterate the nums array again backward the update the final result. Instead of maintaining a after array,
 we only need one variable to maintain the after_i.
 */
import java.util.*;
public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--){
            result[i]=result[i+1]*nums[i+1];
        }

        int left=1;
        for(int i=0; i<nums.length; i++){
            result[i]=result[i]*left;
            left = left*nums[i];
        }

        return result;
    }

    public static int[] productExceptSelfNotEfficient(int[] nums) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            int len = nums.length;
            int[] result = new int[len];
            int[] before = new int[len];
            int[] after = new int[len];

            before[0] = 1;
            for (int i = 1; i < len; i++) {
                before[i] = before[i - 1] * nums[i - 1];
            }

            after[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                after[i] = after[i + 1] * nums[i + 1];
            }

            for (int i = 0; i < len; i++) {
                result[i] = before[i] * after[i];
            }

            return result;
        }

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelfNotEfficient(new int[] {1,2,3,4})));
    }
}
