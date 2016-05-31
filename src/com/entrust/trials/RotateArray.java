package com.entrust.trials;

/**
 * CRotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 How many different ways do you know to solve this problem?
 */
import java.util.*;
public class RotateArray {
    public static void rotate(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
    /*
    Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:

1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4
     */
    public static int[] rotateUsingReverse(int[] arr, int order) {
        if (arr == null || arr.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        if(order > arr.length){
            order = order %arr.length;
        }

        //length of first part
        int a = arr.length - order;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);
        return arr;
    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(rotateUsingReverse(new int[]{1,2,3,4,5,6},4)));
    }
}
