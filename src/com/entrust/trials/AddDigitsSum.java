package com.entrust.trials;

/**
 * O(1) Algo for sum Of digits :

 Taking the modulo 9 of any number will return the sum of digits of that number until a single digit number is obtained.

 If the number is a multiple of 9, then the sum will will be 9
 */
public class AddDigitsSum {
    public int sumDigit(int n){

        int sum = n % 9;
        if(sum == 0){
            if(n > 0)
                return 9;
        }
        return sum;
    }
}
