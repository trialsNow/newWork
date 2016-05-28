package com.entrust.concurrency;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumArrayParallel extends RecursiveTask<Long> {
    static final int SEQUENTIAL_THRESHOLD = 5000;

    int low;
    int high;
    int[] array;

    ForkJoinSumArrayParallel(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }

    protected Long compute() {
		 
        if(high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for(int i=low; i < high; ++i) 
                sum += array[i];
            return sum;
         } else {
            int mid = low + (high - low) / 2;
            ForkJoinSumArrayParallel left  = new ForkJoinSumArrayParallel(array, low, mid);
            ForkJoinSumArrayParallel right = new ForkJoinSumArrayParallel(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
         }
        
     }

     static long sumArray(int[] array) {
         return ForkJoinPool.commonPool().invoke(new ForkJoinSumArrayParallel(array,0,array.length));
     }
     
     static class SingleThread{
    	 static int sumArraySingle(int arr[]){
    		 int sum=0;
    		 for (int i=0;i<arr.length;i++){
    			 sum+=arr[i];
    		 }
    		 return sum;
    	 }
     }
     
     public static void main(String[] args){
    	 int[] n = new int[99999999];
    	 NumberFormat formatter = new DecimalFormat("#0.00000");
    	 for (int i=1;i<n.length;i++){
    		 n[i] =i;
    		 if (i%2!=0){
    			 n[i]=n[i]+12998945;
    		 }
    	 }
    	 long start = System.currentTimeMillis();
    	 ForkJoinSumArrayParallel.SingleThread.sumArraySingle(n);
    	 long end = System.currentTimeMillis();
    	 System.out.println("Single Thread Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    	 
    	 start = System.currentTimeMillis();
    	 sumArray(n);
    	 end = System.currentTimeMillis();
    	 
    	 System.out.print("Parallel Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
     }
}

