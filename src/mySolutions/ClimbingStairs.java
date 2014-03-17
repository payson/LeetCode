package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2)
        if (n < 3) return n;
        int a = 1, b = 2, c, counter = 3;
        while (counter <= n) {
            c = a + b;
            a = b;
            b = c;
            counter++;
        }
        return b;
    }
}
