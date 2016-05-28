package com.entrust.trials;

/**
 * 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 */
import java.util.*;
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(set.add(n)){
            n = sum(getDigits(n));
            if (n == 1)
                return true;
        }

        return false;
    }

    public int sum(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum = (int) (sum + Math.pow(i,2));
        }
        return sum;
    }

    public int[] getDigits(int n){
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int i=0;

        while(n>0){
            int m = n%10;
            result[i++] = m;
            n = n/10;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(new HappyNumber().isHappy(11));
    }
}
