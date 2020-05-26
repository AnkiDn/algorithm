/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (42.84%)
 * Likes:    1776
 * Dislikes: 213
 * Total Accepted:    236.2K
 * Total Submissions: 547.6K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                if (i == triangle.size() - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                if (i == triangle.size() - 1) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
}
// @lc code=end

