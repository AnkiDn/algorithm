/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (46.05%)
 * Likes:    2207
 * Dislikes: 78
 * Total Accepted:    133.1K
 * Total Submissions: 288.8K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
 * day)
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 */

// @lc code=start
class Solution {
    /**
     * dp
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i == 1) {
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    /**
     * dp简化
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        return dp[n][0];
    }

    /**
     * 状态压缩 dp
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        int pre = 0; // 代表 dp[i-2][0]
        for (int i = 1; i < n; ++i) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], pre - prices[i]);
            pre = temp;
        }
        return dp[0];
    }
}
// @lc code=end

