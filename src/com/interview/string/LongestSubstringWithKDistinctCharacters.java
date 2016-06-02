package com.interview.string;

/**
 * Date 04/03/2016
 * @author Tushar Roy
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 *
 * Time complexity O(n)
 * Space complexity O(n)
 * Logic: Add each char to hashmap with count.
 * Until the map size becomes > K. The max
 */
import java.util.*;
public class LongestSubstringWithKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) {
            return 0;
        }
        int[] ascii = new int[256];
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (count < k) {
                if (ascii[ch] == 0) {
                    count++;
                }
            } else if (ascii[ch] == 0){
                while (start < i) {
                    char ch1 = s.charAt(start++);
                    ascii[ch1]--;
                    if (ascii[ch1] == 0) {
                        break;
                    }
                }
            }
            ascii[ch]++;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
    public static int longestSubstringKDistinct(String s, int k) {
        int max=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }

            if(map.size()>k){
                max = Math.max(max, i-start);

                while(map.size()>k){
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        max = Math.max(max, s.length()-start);

        return max;
    }


    public static void main(String[] args){
    	System.out.println(longestSubstringKDistinct("aabcde",2));
    }
}
