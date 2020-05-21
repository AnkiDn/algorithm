/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (45.08%)
 * Likes:    2460
 * Dislikes: 177
 * Total Accepted:    268.5K
 * Total Submissions: 590.4K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
    /**
     * dp
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
            for (int j = 0; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * bfs
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        queue.offer(n);
        visited.add(n);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ++ans;
            for (int i = 0; i < size; ++i) {
                int temp = queue.poll();
                for (int j = 1; j * j <= temp; ++j) {
                    int tempChild = temp - j * j;
                    if (tempChild == 0) {
                        return ans;
                    }
                    if (visited.contains(tempChild)) continue;
                    queue.offer(tempChild);
                    visited.add(tempChild);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

