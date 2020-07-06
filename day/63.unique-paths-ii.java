/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    //dp
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; ++i) {
            if (grid[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        for (int j = 0; j < col; ++j) {
            if (grid[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (grid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    //使用滚动数组优化
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[col - 1];
    }
}
// @lc code=end

