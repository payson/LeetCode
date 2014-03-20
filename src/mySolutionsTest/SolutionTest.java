package mySolutionsTest;

import junit.framework.Assert;
import mySolutions.Solution;

import org.junit.Test;

/**
 * Created by Payson Wu on 19/03/14.
 */
public class SolutionTest {
    @Test
    public void testSolution() throws Exception {
        int[] A = {0, 0, 1, 1, 3, 3, 3, 3, 5, 6, 6, 6, 6, 6};
        int result = Solution.solution(6, A);
        Assert.assertEquals(result, 40);
    }
    @Test
    public void testSolution2() throws Exception {
        int[] A = {0, 0, 0, 0};
        int result = Solution.solution(0, A);
        Assert.assertEquals(result, 16);
    }
    @Test
    public void testSolution3() throws Exception {
        int[] A = {0};
        int result = Solution.solution(0, A);
        Assert.assertEquals(result, 1);
    }
    @Test
    public void testSolution4() throws Exception {
        int[] A = new int[1000];
        java.util.Arrays.fill(A, 0);
        int result = Solution.solution(0, A);
        Assert.assertEquals(result, 1000 * 999 + 1000);
    }
    @Test
     public void testSolution5() throws Exception {
        int[] A = {0, 1, 2, 4, 5, 6};
        int result = Solution.solution(6, A);
        Assert.assertEquals(result, 6);
    }
    @Test
    public void testSolution6() throws Exception {
        int[] A = new int[0];
        int result = Solution.solution(0, A);
        Assert.assertEquals(result, 0);
    }
}
