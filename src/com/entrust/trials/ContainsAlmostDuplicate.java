package com.entrust.trials;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such
 * that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k
 * The naive solution is to maintain a sliding window with size k, when we add an element nums[i], compare the nums[i]
 * with each element in the window. If it is less or equal to t, return true. We return true because the distance between
 * i and each element in the window must be less or equal to k. The complexity of this solution would be O(nk).
 We could use a treeSet to improve the complexity. The treeSet is essentially a balanced binary search tree.
 We put k elements in the treeSet, which is a sliding window. So when we insert an element to the treeSet,
 we need to remove one from the end.
 So the basic idea is for each element nums[i], we check if there is any element between [nums[i] - t, nums[i] + t]. If yes, return true.
 floor(E e):Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
 cieling: Returns the least element in this set greater than or equal to the given element, or null if there is no such element
 */

import java.util.*;
public class ContainsAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer floor = treeSet.floor(nums[i] + t);
            Integer ceil = treeSet.ceiling(nums[i] - t);

            if ((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            treeSet.add(nums[i]);

            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,5,4},4,3));
    }
}
