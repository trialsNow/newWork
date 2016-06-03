package com.entrust.trials;

/**
 * null or empty string
 2. white spaces
 3. +/- sign
 4. calculate real value
 5. handle min & max
 */
import java.lang.Character;
public class StringToInteger {
    public static int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            char c=str.charAt(i);
            int n = Character.getNumericValue(c);
            result = result * 10 + n;
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
    public static void main(String[] args){
        System.out.println(atoi("-15-6"));

    }
}
