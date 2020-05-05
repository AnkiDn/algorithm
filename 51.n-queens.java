import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (44.61%)
 * Likes:    1605
 * Dislikes: 66
 * Total Accepted:    189.7K
 * Total Submissions: 423.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<String>> ans = new ArrayList<>();
    /**
     * 超时
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] ansChar = new char[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(ansChar[i], '.');
        backTrack(0, ansChar);
        return ans;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backTrack (int row, char[][] ansChar) {
        // 触发结束条件
        if (ansChar.length == row) {
            ans.add(charToString(ansChar));
            return; 
        }
        int cols = ansChar[row].length;
        for (int col = 0; col < cols; ++col) {
            // 排除不合法选择
            if (!isValid(row, col, ansChar)) continue;
            // 做选择
            ansChar[row][col] = 'Q';
            // 进入下一行决策
            backTrack(row + 1, ansChar);
            // 撤销选择
            ansChar[row][col] = '.';
        }
    }

    private List<String> charToString (char[][] ansChar) {
        List<String> temp = new ArrayList<>();
        for (char[] chars: ansChar) {
            temp.add(String.valueOf(chars));
        }
        return temp;
    }

    //是否可以在 board[row][col] 放置皇后
    private boolean isValid (int row, int col, char[][] ansChar) {
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < row; ++i) {
            if (ansChar[i][col] == 'Q') return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --row, --col) {
            if (ansChar[i][j] == 'Q') return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < ansChar.length; --row, ++col) {
            if (ansChar[i][j] == 'Q') return false;
        }
        return true;
    }

    /**
     * 优化版
     * colSave，master和salve分别存能攻击到 列 右对角线和左对角线
     * 右对角线：就是y=x的方程 所以 y-x=0也就是 row - col = 0 恒等于一个常量
     * 左对角线：就是y+x=1的方程， 所以也就是row + col =1
     */
    List<List<String>> result = new ArrayList<>();
    int[] colSave;
    int[] master;
    int[] slave;
    public List<List<String>> solveNQueens2(int n) {
        colSave = new int[n];
        master = new int[2 * n];
        slave = new int[2 * n];
        char[][] ansChar = new char[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(ansChar[i], '.');
        backTrack2(0, ansChar);
        return result;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backTrack2 (int row, char[][] ansChar) {
        // 触发结束条件
        if (ansChar.length == row) {
            result.add(charToString(ansChar));
            return; 
        }
        int cols = ansChar[row].length;
        for (int col = 0; col < cols; ++col) {
            // 排除不合法选择
            if (!isValid2(row, col, ansChar)) continue;
            // 做选择
            addQ(row, col, ansChar);
            // 进入下一行决策
            backTrack2(row + 1, ansChar);
            // 撤销选择
            removeQ(row, col, ansChar);
        }
    }
    
    private void addQ(int row, int col, char[][] ansChar) {
        ansChar[row][col] = 'Q';
        colSave[col] = 1;
        master[row -col + ansChar.length] = 1;
        slave[row + col] = 1;
    }

    //是否可以在 board[row][col] 放置皇后
    private boolean isValid2 (int row, int col, char[][] ansChar) {
        return ((colSave[col] | master[row - col + ansChar.length] | slave[row + col]) != 1);
    }

    private void removeQ(int row, int col, char[][] ansChar) {
        ansChar[row][col] = '.';
        colSave[col] = 0;
        master[row - col + ansChar.length] = 0;
        slave[row + col] = 0;
    }
}
// @lc code=end

