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
    int ans = Integer.MAX_VALUE;
    /**
     * 回溯超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
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
     * dp
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * bfs 超时
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
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

