/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (56.80%)
 * Likes:    469
 * Dislikes: 144
 * Total Accepted:    129.4K
 * Total Submissions: 227.6K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    private int ans, size;
    /**
     * 回溯 位运算
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        ans = 0;
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int row, int ld, int rd) {
        if (row == size) {
            ++ans;
            return;
        }
        int valid = size & (~(row | ld | rd));
        while (valid != 0) {
            int p = valid & -valid;
            valid = valid & (valid - 1);
            dfs((row | p), (ld | p) << 1, (rd | p) >>> 1);
        }
    }
}
// @lc code=end

