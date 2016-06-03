package com.entrust.trials;

/**
 * Two Sum II Sorted Array : Scan from both sides of Array
 * If Sum of first and last element is > target move rite pointer to left (j--)
 * If < target move to right.(i++)
 * If equal return the indexes
 */
import java.util.*;
public class TwoSum {
    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }
    public int[] twoSumInputArrSorted(int[] numbers, int target) {
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

 class twoSumIIIAddAndFindMethods {
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

}
