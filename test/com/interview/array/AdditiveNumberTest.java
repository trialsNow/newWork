package com.interview.array;

import org.junit.Assert;
import org.junit.*;

public class AdditiveNumberTest {

    @Test
    public void testVariousCases() {
        AdditiveNumber additiveNumber = new AdditiveNumber();
        Assert.assertTrue(additiveNumber.isAdditiveNumber("12351174"));
        Assert.assertFalse(additiveNumber.isAdditiveNumber("1023"));
        Assert.assertTrue(additiveNumber.isAdditiveNumber("198019823962"));

    }
}
