/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (36.78%)
 * Likes:    1948
 * Dislikes: 70
 * Total Accepted:    205.4K
 * Total Submissions: 557.8K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e.,
 * you must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are
 * engaging multiple transactions at the same time. You must sell before buying
 * again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 三维dp
     * 1.  定义dp数组：dp[i][j][k]。 其中i是经过的天数，j是拥有的交易次数，
     * k为拥有股票或者不拥有股票。那么最大收益就为dp[i][j][0],i和j都是取最大值，
     * 并且手上没有股票了。
     * 
       2.  转移方程：
       ```java
       //当天没有股票时：可能前一天也没有股票 或者 前一天有股票但是今天卖出。
       //那么收益就为其中最大值。
       dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
       //当天有股票时：可能前一天也有股票 或者 前一天没有股票但是今天买进。
       //那么收益就为其中最大值。
       dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
       ```
       3. 边界条件：
       ```java
       //当i == 0时，也就是第一天
       //第一天没有股票，那么收益自然为0
       dp[0][j][0] = 0;
       //第一天有股票，那么收益自然为负的当天股票价格
       dp[0][j][1] = -prices[i];
       ```
       ```java
       //当j == 0时，也就是没有了交易次数，这就相当于只有一次交易机会。
       //今天没有股票：可能前一天也没有股票 或者 前一天有股票但是今天卖出。与状态转移方程相同，可以不做考虑。
       dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
       //当j == 0，并且当天有股票时：可能前一天就买了股票 或者 之前没买今天买
       //前一天买了股票时：dp[i - 1][j][1]
       //之前没买今天买：-prices[i]
       //那么收益就为其中最大值。
       dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
       ```
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][2][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                if (j == 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][1][0];
    }

    /**
     * 三维dp优化
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][3][2];
        for (int j = 1; j < 3; ++j) dp[0][j][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < 3; ++j) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];
    }

    /**
     * 状态压缩 空间复杂度变为O(1)
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[3][2];
        //这里j从0开始耗时会减少很多，不知道为啥，明明这个值是取不到的。
        for (int j = 1; j < 3; ++j) dp[j][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < 3; ++j) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[2][0];
    }
}
// @lc code=end

