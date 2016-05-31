package com.entrust.trials;

/**
 * Algorithm:
 * Save the first string in array to prefix
 * Compare each character in the second string in array with prefix char
 * If matches increment j.
 * Form the prefix string by substring (0,j)
 * Compare next with prefix again.
 * Returns only if there is a common prefix among all elements in an array
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() &&
                    j < prefix.length() &&
                    strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[]{"ABC DEFG", "ABC EFG", "ABC EFA"}));
    }
}
