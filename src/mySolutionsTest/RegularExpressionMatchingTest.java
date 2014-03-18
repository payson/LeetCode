package mySolutionsTest;

import mySolutions.RegularExpressionMatching;

import org.junit.Assert;

/**
 * Created by Payson Wu on 17/03/14.
 */
public class RegularExpressionMatchingTest {
    @org.junit.Test
    public void testIsMatch() throws Exception {
        Assert.assertTrue(RegularExpressionMatching.isMatch("aab", "aabb*"));
    }
}
