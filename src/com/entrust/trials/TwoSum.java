package com.entrust.trials;

/**
 * Created by rathna on 2016-05-27.
 */
import java.util.*;
public class TwoSum {
    //Sorted Array
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return null;
    }

    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public void add(int number) {
        if (elements.containsKey(number)) {
            elements.put(number, elements.get(number) + 1);
        } else {
            elements.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Integer i : elements.keySet()) {
            int target = value - i;
            if (elements.containsKey(target)) {
                if (i == target && elements.get(target) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

}
