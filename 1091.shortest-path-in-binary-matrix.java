/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (37.45%)
 * Likes:    323
 * Dislikes: 34
 * Total Accepted:    25.6K
 * Total Submissions: 67.7K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * 
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 * 
 * 
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
 * different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] ==
 * 0).
 * 
 * 
 * Return the length of the shortest such clear path from top-left to
 * bottom-right.  If such a path does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,1],[1,0]]
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * 
 * 
 * Output: 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) return -1;
        row = grid.length; 
        col = grid[0].length;
        int ans = 0;
        if (grid[row - 1][col - 1] == 1) return -1;
        boolean[][] memo = new boolean[row][col];
        int[][] vectors = new int[][]{{1, 1}, {-1, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {0, 1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        memo[0][0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            ++ans;
            for (int i = 0; i < size; ++i) {
                Point p = queue.poll();
                if (p.x == row - 1 && p.y == col - 1) return ans;
                for (int m = 0; m < vectors.length; ++m) {
                    int x = p.x + vectors[m][0];
                    int y = p.y + vectors[m][1];
                    if (!isValid(grid, x, y)) continue;
                    if (grid[x][y] != 0) continue;
                    if (memo[x][y]) continue;
                    queue.offer(new Point(x, y));
                    memo[x][y] = true;
                }
            }
        }
        return -1;
    }

    int row, col;
    /**
     * A*
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) return -1;
        row = grid.length; 
        col = grid[0].length;
        int ans = 0;
        if (grid[row - 1][col - 1] == 1) return -1;
        int[][] vectors = new int[][]{{1, 1}, {-1, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {0, 1}, {0, -1}};
        Queue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(0, 0, grid[0][0] = 1));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            ans = grid[p.x][p.y];
            System.out.println(String.format("ans: %s, (%s, %s), distance: %s", ans, p.x, p.y, p.distance));
            if (p.x == row - 1 && p.y == col - 1) return ans;
            for (int m = 0; m < vectors.length; ++m) {
                int x = p.x + vectors[m][0];
                int y = p.y + vectors[m][1];
                if (!isValid(grid, x, y)) continue;
                // 当grid[x][y]已经不是0了 有两种可能一种是障碍物，另一种是已经在队列里了
                //障碍物没加进队列 所以跳过就行，剩下一种可能就是已经在队列里了
                //在队列里，如果小于等于ans + 1说明 这个是之前加进去的而且用的步骤少 也就不用更新
                //如果大于 ans + 1 说明在之前的位置走到这一步的步骤太大了，在现在的位置走到这一步所用步骤较小，所以更新这个值。
                if (grid[x][y] != 0 && grid[x][y] <= ans + 1) continue;
                grid[x][y] = ans + 1;
                //这里不能用曼哈顿距离来算 会陷入局部贪心
                queue.offer(new Point(x, y, Math.max(row - 1 - x, col - 1 - y) + grid[x][y]));
            }
        }
        return -1;
    }

    public boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;
    
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    
        @Override
        public int compareTo(Point p) {
            return this.distance - p.distance;
        }
    }
}

/**
 * 用例
 * 
[
[0,0,0,0,1,1,1,1,0],
[0,1,1,0,0,0,0,1,0],
[0,0,1,0,0,0,0,0,0],
[1,1,0,0,1,0,0,1,1],
[0,0,1,1,1,0,1,0,1],
[0,1,0,1,0,0,0,0,0],
[0,0,0,1,0,1,0,0,0],
[0,1,0,1,1,0,0,0,0],
[0,0,0,0,0,1,0,1,0]
]

heuristic函数和打印
Math.abs(row - 1 - x)                         Math.abs(row - 1 - x)                         
+ Math.abs(col - 1 - y)                         + Math.abs(col - 1 - y)
                                                + step        

ans: 1, (0, 0), distance: 1                     ans: 1, (0, 0), distance: 1                            
ans: 2, (1, 0), distance: 15                    ans: 2, (1, 0), distance: 17
ans: 3, (2, 1), distance: 13                    ans: 3, (2, 1), distance: 16
ans: 4, (3, 2), distance: 11                    ans: 4, (3, 2), distance: 15
ans: 5, (3, 3), distance: 10                    ans: 5, (3, 3), distance: 15
ans: 6, (2, 4), distance: 10                    ans: 5, (2, 3), distance: 16
ans: 7, (3, 5), distance: 8                     ans: 6, (2, 4), distance: 16
ans: 8, (4, 5), distance: 7                     ans: 7, (3, 5), distance: 15
ans: 9, (5, 6), distance: 5                     ans: 8, (4, 5), distance: 15
ans: 10, (6, 7), distance: 3                    ans: 9, (5, 6), distance: 14
ans: 11, (7, 8), distance: 1                    ans: 10, (6, 7), distance: 13
ans: 12, (8, 8), distance: 0  					ans: 11, (7, 8), distance: 12
						                        ans: 12, (8, 8), distance: 12

Math.max(row - 1 - x, col - 1 - y) + step

ans: 1, (0, 0), distance: 1
ans: 2, (1, 0), distance: 10
ans: 2, (0, 1), distance: 10
ans: 3, (2, 1), distance: 10
ans: 4, (3, 2), distance: 10
ans: 5, (3, 3), distance: 10
ans: 3, (2, 0), distance: 11
ans: 3, (0, 2), distance: 11
ans: 5, (2, 3), distance: 11
ans: 4, (1, 3), distance: 11
ans: 5, (2, 4), distance: 11
ans: 6, (3, 5), distance: 11
ans: 7, (4, 5), distance: 11
ans: 8, (5, 6), distance: 11
ans: 8, (5, 5), distance: 11
ans: 9, (6, 7), distance: 11
ans: 9, (6, 6), distance: 11
ans: 10, (7, 7), distance: 11
ans: 10, (7, 8), distance: 11
ans: 11, (8, 8), distance: 11                  
 */
// @lc code=end

