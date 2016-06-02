package com.entrust.trials;

/**
 * Created by rathna on 2016-05-26.
 */
import java.util.*;
public class RemoveDuplicatesSortedArray {

    public static int shiftElements(int[] arr, int n){
        int k=0;
        int m=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==n){
                k++;
                continue;
            }  else {
                arr[m]= arr[k];
                m++;
                k++;
            }
        }
        return  m;
    }

    public int removeDuplicatesOnlyTwiceallowed(int[] A) {
        if (A.length <= 2)
            return A.length;

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }

    public static void main(String[] args){
        System.out.println(shiftElements(new int[]{1,2,3,3,3,6},3));
    }
}
