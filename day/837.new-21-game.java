/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 *
 * https://leetcode.com/problems/new-21-game/description/
 *
 * algorithms
 * Medium (33.99%)
 * Likes:    535
 * Dislikes: 301
 * Total Accepted:    16.3K
 * Total Submissions: 47.9K
 * Testcase Example:  '10\n1\n10'
 *
 * Alice plays the following game, loosely based on the card game "21".
 * 
 * Alice starts with 0 points, and draws numbers while she has less than K
 * points.  During each draw, she gains an integer number of points randomly
 * from the range [1, W], where W is an integer.  Each draw is independent and
 * the outcomes have equal probabilities.
 * 
 * Alice stops drawing numbers when she gets K or more points.  What is the
 * probability that she has N or less points?
 * 
 * Example 1:
 * 
 * 
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * 
 * Note:
 * 
 * 
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct
 * answer.
 * The judging time limit has been reduced for this question.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * dp
     * 参考：https://leetcode-cn.com/problems/new-21-game/solution/huan-you-bi-zhe-geng-jian-dan-de-ti-jie-ma-tian-ge/
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double range = 0;
        for (int i = K; i < K + W; ++i) {
            if (i > N) break;
            dp[i] = 1;
            range += dp[i];
        }
        for (int i = K - 1; i >= 0; --i) {
            dp[i] = range / W;
            range = range - dp[i + W] + dp[i];
        }
        return dp[0];
    }
}
// @lc code=end

