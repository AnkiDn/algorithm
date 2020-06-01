/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (41.69%)
 * Likes:    1630
 * Dislikes: 89
 * Total Accepted:    178.5K
 * Total Submissions: 421.9K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        
    }

    int n;
    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        n = board.length;
        dfs(board, 0, 0);
    }

    public boolean dfs (char[][] board, int row, int col) {
        if (col == n)  return dfs(board, row + 1, 0);
        if (row == n) return true;
        if (board[row][col] != '.') return dfs(board, row, col + 1);
        for (char c = '1'; c <= '9'; ++c) {
            if (!isValid(board, row, col, c)) continue;
            board[row][col] = c;
            if (dfs(board, row, col + 1)) return true;
            board[row][col] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) return false;
        }
        return true;
    }
}
// @lc code=end

