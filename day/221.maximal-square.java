/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (35.74%)
 * Likes:    2721
 * Dislikes: 68
 * Total Accepted:    243.4K
 * Total Submissions: 657K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 * 
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     */
    public int maximalSquare1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return maxSide;
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if(matrix[i][j] == '0') continue;
                if (matrix[i][j] == '1') maxSide = Math.max(maxSide, 1);
                //在当前左顶点下 可能的最大边长
                int canValidMaxSide = Math.min(rows - i, columns - j);
                for (int k = 1; k < canValidMaxSide; ++k) {
                    if (matrix[i + k][j + k] == '0') break;
                    boolean flag = true;
                    for (int l = 0; l < k; ++l) {
                        if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                            flag = false; 
                            break;
                        }
                    }
                    if (!flag) break;
                    maxSide = Math.max(maxSide, k + 1);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * dp
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return maxSide;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] == '0')  continue;
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        //右下顶点所占的面积 取决于左上和左斜上的值 然后 + 1
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
// @lc code=end

