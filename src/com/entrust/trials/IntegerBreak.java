package com.entrust.trials;

/**
 * We will check all the possible combination present, which is being accomplished by second loop.
 * So, we are looping from 1 till i and keep checking for the maximum value
 Example: i = 5 , so we will check for j = 1, 2, 3, 4
 Now, either we can pick the number itself or we can pick the maximum we can get from
 combinational products, which is accomplished by Math.max(j,dp[j]) Then we will left with a
 number which is equal to i - j, say we were looping for j =3 and i = 5, then we are picking j =3
 (and checking if we should pick 3 or its dp solution) then the other part of 5 will be (i-j = 5 - 3 = 2)
 so will check the same logic for 2 and then will get their product.
 */
public class IntegerBreak {

    public static int integerCheck(int n) {
    int[] dp = new int[n + 1];
    dp[1]=1;
    for(int i = 2;i<=n;i++) {
        for (int j = 1; j < i; j++) {
            dp[i] = Math.max(dp[i], (Math.max(j, dp[j]) * Math.max(i - j, dp[i - j])));
        }
    }
    return dp[n];
}
    public static void main(String[] args){
        System.out.println(integerCheck(5));
    }
}
