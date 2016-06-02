package com.entrust.trials;

/**
 * Created by rathna on 2016-05-29.
 */
import java.util.*;
public class MissingNumberNonConsecutiveSorted {

    static class Pair{
        int diff;
        int index;

        Pair(int diff,int count){
            this.diff=diff;
            this.index=count;
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.diff- o2.diff;
        }
    });

    public static int findIndexOfClosestElement(int[] arr,int target){
        if (arr==null || arr.length==0 || target==0){
            return 0;
        }
        if (arr.length==1){
            return 1;
        }

        for (int i=0;i<arr.length;i++){
            if (arr[i]==target) { return i;}
            pq.offer(new Pair(Math.abs(target-arr[i]),i));
        }

        return (pq.poll().index+1);
    }

    public static void main(String args[]){
        System.out.println(findIndexOfClosestElement(new int[]{2,4,6,8,10},11));
    }
}
