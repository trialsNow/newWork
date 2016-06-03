package com.entrust.trials;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * The key to solve this problem is bit manipulation. XOR will return 1 only on two different bits.
 * So if two numbers are the same, XOR will return 0. Finally only one number left.
 */

import java.util.*;
public class SingleNumber {
    public static int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }

    public static int[] singleNumberTwoElementsNotSame(int[] A) {
        int K = 0;
        int B = 0;
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }

        x = (x & (x - 1)) ^ x; //find the different bit
        for(int i = 0; i<A.length; i++){
            if((x & A[i]) == 0)
                K ^= A[i];
            else
                B ^= A[i];
        }
        return new int[]{K, B};
    }

    public static void main(String[] args){
     System.out.println(singleNumber(new int[] {1,2,3,4,1,2,3,4,5}));
        System.out.println(Arrays.toString(singleNumberTwoElementsNotSame(new int[] {1,2,3,4,1,2,3,4,5,6})));
        System.out.println(112&333);
        System.out.println(9|8);
        System.out.println(9^8);
        System.out.println(8^9);
    }
}
