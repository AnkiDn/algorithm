import java.util.Queue;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (34.15%)
 * Likes:    3533
 * Dislikes: 128
 * Total Accepted:    368.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

// @lc code=start
class Solution {
    
    /**
     * dp暴力
     */
    public int coinChange(int[] coins, int amount) {
        int count = coins.length;
        if (count == 0 || amount == 0) return 0;
        int[][] dp = new int[count + 1][amount + 1];
        for (int i = 0; i <= count; ++i) {
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 0; i <= count; ++i) dp[i][0] = 0;
        for (int i = 1; i <= count; ++i) {
            for (int j = 1; j <= amount; ++j) {
                for (int k = 0; k * coins[i - 1] <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                }
            }
        }
        return dp[count][amount] > amount ? -1 : dp[count][amount];
    }

    /**
     * 暴力优化
     */
    public int coinChange2(int[] coins, int amount) {
        int count = coins.length;
        if (count == 0 || amount == 0) return 0;
        int[][] dp = new int[count + 1][amount + 1];
        for (int i = 0; i <= count; ++i) {
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 0; i <= count; ++i) dp[i][0] = 0;
        
        for (int i = 1; i <= count; ++i) {
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[count][amount] > amount ? -1 : dp[count][amount];
    }

    /**
     * 优化 状态压缩dp
     */
    public int coinChange(int[] coins, int amount) {
        int count = coins.length;
        if (count == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; ++j) dp[j] = amount + 1;
        for (int i = 1; i <= count; ++i) {
            for (int j = coins[i - 1]; j <= amount; ++j) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    int ans = Integer.MAX_VALUE;
    /**
     * 回溯超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        dfs(coins, amount, ans);
        return ans;
    }

    public void dfs(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) {
            ans = Math.min(ans, count);
        }
        for (int i = 0; i < coins.length; ++i) {
            dfs(coins, amount - coins[i], count + 1);
        }
    }

    /**
     * bfs 超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++ans;
            for (int i = 0; i < size; ++i) {
                money = queue.poll();
                for (int j = 0; j < coins.length; ++j) {
                    if (money == coins[j]) {
                        return ans + 1;
                    }
                    if (money > coins[j]) {
                        queue.offer(money - coins[j]);
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

