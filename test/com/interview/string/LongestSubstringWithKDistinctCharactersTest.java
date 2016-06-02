package com.interview.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithKDistinctCharactersTest {

    @Test
    public void testDifferenceCases() {
        LongestSubstringWithKDistinctCharacters longestSubstringWithKDistinctCharacters = new LongestSubstringWithKDistinctCharacters();
        Assert.assertEquals(3, longestSubstringWithKDistinctCharacters.longestSubstringKDistinct("eceba", 2));
        Assert.assertEquals(1, longestSubstringWithKDistinctCharacters.longestSubstringKDistinct("aba", 1));
        Assert.assertEquals(5, longestSubstringWithKDistinctCharacters.longestSubstringKDistinct("caebegcle", 4));
        Assert.assertEquals(0, longestSubstringWithKDistinctCharacters.longestSubstringKDistinct("eceba", 0));
    }
}
