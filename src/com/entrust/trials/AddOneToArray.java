package com.entrust.trials;

/**
 * Created by rathna on 2016-05-25.
 */

import java.util.*;

public class AddOneToArray {
    public static final int[] addOne(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(addOne(new int[]{})));
        System.out.println(Arrays.toString(addOne(new int[]{1})));
        System.out.println(Arrays.toString(addOne(new int[]{9})));
        System.out.println(Arrays.toString(addOne(new int[]{3, 9, 9})));
        System.out.println(Arrays.toString(addOne(new int[]{3, 9, 9, 9})));
        System.out.println(Arrays.toString(addOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(addOne(new int[]{9, 9, 9, 8})));
    }
}
