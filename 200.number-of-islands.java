import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.70%)
 * Likes:    4942
 * Dislikes: 185
 * Total Accepted:    668.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */

// @lc code=start
class Solution {
    /**
     * dfs
     */
    private static final int[][] vectors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands_dfs(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, colums = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < colums; ++j) {
                if(grid[i][j] == '1') { //当是岛屿并且没有被访问过 就进行dfs
                    ++ans; //每次访问就+1
                    dfs(grid, i ,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int x, int y) {
        //判断base case
        if (!inArea(grid, x , y)) return; //不在网格中 return
        if (grid[x][y] != '1') return;//当不是岛屿或者被访问过 return
        grid[x][y] = '2'; //标记为已访问

        for (int i = 0; i < vectors.length; ++i) {
            int new_x = x + vectors[i][0];
            int new_y = y + vectors[i][1];
            dfs(grid, new_x, new_y);
        }
        // dfs(grid, x - 1, y);
        // dfs(grid, x + 1, y);
        // dfs(grid, x, y - 1);
        // dfs(grid, x, y + 1);
    }

    private boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    /**
     * bfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, colums = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < colums; ++j) {
                if(grid[i][j] == '1') { //当是岛屿并且没有被访问过 就进行bfs
                    ++ans; //每次访问就+1
                    queue.add(i * colums + j); //把坐标转换为 数字
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int row = cur / colums;
                        int col = cur % colums;
                        for (int k = 0; k < vectors.length; ++k) {
                            int new_row = row + vectors[k][0];
                            int new_col = col + vectors[k][1];
                            if(inArea(grid, new_row, new_col) && grid[new_row][new_col] == '1') {
                                grid[new_row][new_col] = '2';
                                queue.add(new_row * colums + new_col);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

