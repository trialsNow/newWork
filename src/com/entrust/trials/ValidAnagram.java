package com.entrust.trials;

/**
 * Created by rathna on 2016-05-30.
 */

import java.util.*;
public class ValidAnagram {
    public boolean isAnagramWithMap(String s, String t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        // iterate map
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramSort(String s, String t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = String.valueOf(chars);

        char[] chart = t.toCharArray();
        Arrays.sort(chart);
        t = String.valueOf(chart);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
