package com.interview.string;

/**
 * Date 07/29/2015
 * @author Tushar Roy
 *
 * Given a string find longest palindromic substring in this string.
 *
 * References
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 * http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 * http://www.akalin.cx/longest-palindrome-linear-time
 * http://tarokuriyama.com/projects/palindrome2.php
 */
public class LongestPalindromeSubstring {

    public String longestPalindromeSubstringEasy(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean [][] dp = new boolean[len][len];

        String longest = null;
        for(int l=0; l<s.length(); l++){
            for(int i=0; i<len-l; i++){
                int j = i+l;
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;

                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        //System.out.println(lps.longestPalindromeSubstringEasy("abba"));
        System.out.println(lps.longestPalindrome("madames"));
       // System.out.println(lps.longestPalindromeSubstringEasy("babcbaabcbaccba".toCharArray()));
       // System.out.println(lps.longestPalindromeSubstringEasy("cdbabcbabdab".toCharArray()));
    }

}
