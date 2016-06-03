package com.entrust.ScenarioBased;

/**
 * We can easily find recursive nature in above problem. The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair.
 * Let the total number of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’ can be written as following.

 ways(n) = ways(n-1) + ways(n-2)
 The above expression is actually the expression for Fibonacci numbers,
 but there is one thing to notice, the value of ways(n) is equal to fibonacci(n+1).

 ways(1) = fib(2) = 1
 ways(2) = fib(3) = 2
 ways(3) = fib(4) = 3
 */
public class ClimbStairs {

    public static int stepsCount(int n){
        int n1 = 0, n2 = 1;
        int sum;

        if (n == n1 || n == n2) {
            return n;
        }

        for(int i=2; i <= n; i++){
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;
    }

    public static void main(String[] args){
        int stepsToReachTop = 4;
        System.out.println("Steps:"+stepsCount(stepsToReachTop+1));
    }
}
