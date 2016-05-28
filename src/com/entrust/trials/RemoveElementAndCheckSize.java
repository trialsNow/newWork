package com.entrust.trials;

/**
 * Created by rathna on 2016-05-26.
 */
import java.util.*;
public class RemoveElementAndCheckSize {

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


    public static void main(String[] args){
        System.out.println(shiftElements(new int[]{1,2,3,3,3,6},3));
    }
}
