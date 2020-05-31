/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (25.87%)
 * Likes:    1403
 * Dislikes: 596
 * Total Accepted:    203.4K
 * Total Submissions: 774.7K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */

// @lc code=start
class Solution {

    int row, col;
    char[][] board;
    int[][] vectors = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * dfs
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.board = board;
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    dfs (i, j);
                }
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j) {
        board[i][j] = '#';
        for (int k = 0; k < vectors.length; ++k) {
            int x = i + vectors[k][0];
            int y = j + vectors[k][1];
            if (!isValid(x, y)) continue;
            if (board[x][y] != 'O') continue;
            dfs(x, y);
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }


    UnionFind uf;
    int row, col;
    /**
     * 并查集
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        row = board.length; 
        col = board[0].length;
        uf = new UnionFind(row * col + 1);
        int dummy = row * col;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    uf.union(dummy, node(i, j));
                } else {
                     // 和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O')
                            uf.union(node(i, j), node(i - 1, j));
                        if (i < row - 1 && board[i + 1][j] == 'O')
                            uf.union(node(i, j), node(i + 1, j));
                        if (j > 0 && board[i][j - 1] == 'O')
                            uf.union(node(i, j), node(i, j - 1));
                        if (j < col - 1 && board[i][j + 1] == 'O')
                            uf.union(node(i, j), node(i, j + 1));
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (uf.connected(dummy, i * col + j)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return i * col + j;
    }
}

class UnionFind {
    int count;
    int[] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) return;
        parent[rootJ] = rootI;
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

