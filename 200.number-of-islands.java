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
    UnionFind uf;
    int row, col;
    int[][] vectors = new int[][]{{1, 0}, {0, 1}};
    /**
     * 并查集
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        row = grid.length;
        col = grid[0].length;
        uf = new UnionFind(grid);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '0') continue;
                for (int k = 0; k < vectors.length; ++k) {
                    int new_x = i + vectors[k][0];
                    int new_y = j + vectors[k][1];
                    if (new_x == row || new_y == col || grid[new_x][new_y] == '0') continue;
                    uf.union(i * col + j, new_x * col + new_y);
                }
            }
        }
        return uf.count();
    }
}

class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    this.count++;
                    int index = i * n + j;
                    parent[index] = index;
                }
            }
        }
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) return;
        parent[rootI] = rootJ;
        this.count--;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public int count() {
        return this.count;
    }

    public int find(int i) {
        while(parent[i] != i) {
            parent[i] = find(parent[i]);
            i = parent[i];
        }
        return i;
    }
}
// @lc code=end

