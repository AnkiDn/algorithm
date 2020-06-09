/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (27.70%)
 * Likes:    1354
 * Dislikes: 86
 * Total Accepted:    123.5K
 * Total Submissions: 445.5K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * Say you have an array for which the i-th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 =
 * 3.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 三维dp
     *  1.  定义dp数组：dp[i][j][k]。 其中i是经过的天数，j是拥有的交易次数，k为拥有股票或者不拥有股票。那么最大收益就为dp[i][j][0],i和j都是取最大值，并且手上没有股票了。
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
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        // 交易次数最多为n/2 所以当k >= n / 2时，交易次数限制没有意义。当然也为了避免tle
        if (k > n / 2) return maxProfit_k_any(prices);
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
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
        return dp[n - 1][k - 1][0];
    }

    /**
     * 三维dp优化
     */
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        // 交易次数最多为n/2 所以当k >= n / 2时，交易次数限制没有意义。当然也为了避免tle
        if (k > n / 2) return maxProfit_k_any(prices);
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 1; j <= k; ++j) dp[0][j][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    /**
     * 状态压缩dp
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit3(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        // 交易次数最多为n/2 所以当k >= n / 2时，交易次数限制没有意义。当然也为了避免tle
        if (k > n / 2) return maxProfit_k_any(prices);
        int[][] dp = new int[k + 1][2];
        for (int j = 1; j <= k; ++j) dp[j][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }


    public int maxProfit_k_any(int[] prices) {
        //直接使用第二题
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i <= n; ++i) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i - 1]);
        }
        return dp[0];
    }
}
// @lc code=end

