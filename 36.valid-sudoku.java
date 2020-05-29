/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (47.36%)
 * Likes:    1487
 * Dislikes: 438
 * Total Accepted:    346.5K
 * Total Submissions: 723.6K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */

// @lc code=start
class Solution {

    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            //对每个i分别验证每个i行， 每个i列和每个i宫是否是正确的。
            int row = 0, col = 0, block = 0;
            for (int j = 0; j < 9; ++j) {
                // r c s都是对应每个i，在每个i行、i列、i宫对0～9进行遍历
                int r = board[i][j] - '0'; 
                int c = board[j][i] - '0';
                int s = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] - '0';
                // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                if (r > 0)
                    row = sudokuer(r, row);
                if (c > 0)
                    col = sudokuer(c, col);
                if (s > 0)
                    block = sudokuer(s, block);
                if(row == -1 || col == -1 || block == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private int sudokuer(int n, int val){
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int bits = 0;
            for (int j = 0; j < 9; j++) {
                int r = board[i][j] - '0';
                int c = board[j][i] - '0';
                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - '0';
                int temp = 0;
                if (r > 0)
                    temp |= 1 << r;
                if (c > 0)
                    temp |= 1 << (c + 10);
                if (s > 0)
                    temp |= 1 << (s + 20);
                if ((temp & bits) > 0) {
                    return false;
                }
                bits = temp | bits;
            }
        }
        return true;
    }
}
// @lc code=end

