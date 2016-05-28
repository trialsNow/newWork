package com.entrust.trials;

/**
 * Created by rathna on 2016-05-26.
 */
public class ReverseVowel {
        public String reverseVowels(String s) {
            if (s == null) {
                throw new IllegalArgumentException();
            }
            if (s.length() <= 1) {
                return s;
            }
            char[] str = s.toCharArray();
            for (int i = 0, j = str.length - 1; i < j; i++, j--) {
                while (i < j && !isVowel(str[i])) i++;
                while (i < j && !isVowel(str[j])) j--;
                if (i <= j) swap(str, i, j);
            }
            return new String(str);
        }
        private boolean isVowel(char ch) {
            char c = Character.toLowerCase(ch);
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
        private void swap(char[] str, int i, int j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }

    public static void main(String[] args){
        ReverseVowel r = new ReverseVowel();
        System.out.println(r.reverseVowels("aseiou"));
    }
}
