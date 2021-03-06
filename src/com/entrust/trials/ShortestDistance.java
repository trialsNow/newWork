package com.entrust.trials;

/**
 * Created by rathna on 2016-05-28.
 */
public class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int posA = -1;
        int posB = -1;

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                posA = i;
            }

            if (words[i].equals(word2)) {
                posB = i;
            }

            if (posA != -1 && posB != -1) {
                minDistance = Math.min(minDistance, Math.abs(posA - posB));
            }
        }

        return minDistance;
    }
}
