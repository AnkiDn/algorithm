/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (34.08%)
 * Likes:    3333
 * Dislikes: 165
 * Total Accepted:    440.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {
    int[][] vectors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (chars[0] == board[i][j]) {
                    if (dfs(board, i , j, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs (char[][] board, int i, int j, char[] chars, int start) {
        if (start == chars.length - 1) {
            return board[i][j] == chars[start];
        }
        if (visited[i][j]) return false;
        if (board[i][j] == chars[start]) {
            visited[i][j] = true;
            for (int k = 0; k < vectors.length; ++k) {
                int new_x = i + vectors[k][0];
                int new_y = j + vectors[k][1];
                if (!isValid(board, new_x, new_y)) continue;
                if (visited[new_x][new_y]) continue;
                if (dfs(board, new_x, new_y, chars, start + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        return true;
    }
}
// @lc code=end

