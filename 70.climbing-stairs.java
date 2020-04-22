/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    // 递归
    public int climbStairs1(int n) {
        return climb(n);
    }

    private Integer climb(int rank) {
        if (rank == 1 || rank == 2)
            return rank;
        return climb(rank - 1) + climb(rank - 2);
    }

    // 动态规划 空间O(n)
    public int climbStairs2(int n) {
        if (n <= 2)
            return n;
        int memo[] = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; ++i) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    // 动态规划 空间O(1)
    public int climbStairs3(int n) {
        if (n <= 2)
            return n;
        int one_step_before = 2;
        int two_step_before = 1;
        int all_ways = 0;
        for (int i = 3; i <= n; ++i) {
            all_ways = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
// @lc code=end
