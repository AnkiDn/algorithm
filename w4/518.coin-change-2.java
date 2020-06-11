/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 *
 * https://leetcode.com/problems/coin-change-2/description/
 *
 * algorithms
 * Medium (46.89%)
 * Likes:    1434
 * Dislikes: 54
 * Total Accepted:    86.6K
 * Total Submissions: 183.3K
 * Testcase Example:  '5\n[1,2,5]'
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of
 * coin.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: amount = 10, coins = [10] 
 * Output: 1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * You can assume that
 * 
 * 
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
    暴力 dp
     */
    public int change(int amount, int[] coins) {
        int count = coins.length;
        int[][] dp = new int[count + 1][amount + 1];
        //题目说明当amount = 0时 组合数为1
        for (int i = 0; i <= count; ++i) dp[i][0] = 1;
        for (int i = 1; i <= count; ++i) {
            for (int j = 1; j <= amount; ++j) {
                for (int k = 0; k * coins[i - 1] <= j; ++k) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[count][amount];
    }

    /**
    暴力优化 dp
     */
    public int change2(int amount, int[] coins) {
        int count = coins.length;
        int[][] dp = new int[count + 1][amount + 1];
        //题目说明当amount = 0时 组合数为1
        for (int i = 0; i <= count; ++i) dp[i][0] = 1;
        for (int i = 1; i <= count; ++i) {
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[count][amount];
    }

    /**
    状态压缩 滚动数组dp
     */
    public int change3(int amount, int[] coins) {
        int count = coins.length;
        int[] dp = new int[amount + 1];
        //题目说明当amount = 0时 组合数为1
        dp[0] = 1;
        for (int i = 1; i <= count; ++i) {
            for (int j = coins[i - 1]; j <= amount; ++j) {
                dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

