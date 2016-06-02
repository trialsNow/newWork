package com.entrust.trials;

/**
 * Algorithm: Keep subtracting target from each array element
 * until the target is less than the aray element itself.
 * Comb Set 1: Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Comb sum2: Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used ONCE in the combination.
 * Comb Set 3: Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 Ensure that numbers within the set are sorted in ascending order.
 Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
 Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
import java.util.*;
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return result;

        Arrays.sort(num);

        ArrayList<Integer> temp = new ArrayList<Integer>();
        combinationSum(num, 0, target, temp, result);

        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);

        //remove duplicate lists
        result.clear();
        result.addAll(set);

        return result;
    }


    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr,
                               ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++){
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, 1, n, list, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, int start, int target, List<Integer> list, int k){
        if(target==0 && list.size()==k){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
        }

        for(int i=start; i<=9; i++){
            if(target-i<0) break;
            if(list.size()>k) break;

            list.add(i);
            dfs(result, i+1, target-i, list, k);
            list.remove(list.size()-1);
        }
    }

    public static void main(String args[]){
        int input[] = {2,3,5,7};
        CombinationSum msa = new CombinationSum();
        System.out.println(Arrays.toString(msa.combinationSum(input, 7).toArray()));
    }
}

