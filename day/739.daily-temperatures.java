/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (62.73%)
 * Likes:    2640
 * Dislikes: 82
 * Total Accepted:    151.1K
 * Total Submissions: 240.6K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * 
 */

// @lc code=start
class Solution {

    /**
     * 暴力
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        if (n == 0)  return new int[]{0};
        int[] ans = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                } 
            }
        }
        return ans;
    }

    /**
     * 暴力优化
     */
    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        if (n == 0)  return new int[]{0};
        int[] ans = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures3(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

