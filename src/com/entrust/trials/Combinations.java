package com.entrust.trials;

/**
 *
 * k Combinations of 1..n
 * Combinations formula n!/(n-1)!* k!
 */
import java.util.*;
public class Combinations {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (n <= 0 || n < k)
            return result;

        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1

        return result;
    }

    private static void dfs(int n, int k, int start, ArrayList<Integer> item,
                     ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> ds = Combinations.combine(3,2);
        for (ArrayList a: ds){
            System.out.println(Arrays.toString(a.toArray()));
        }
    }
}
