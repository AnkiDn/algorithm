#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#
# https://leetcode.com/problems/number-of-islands/description/
#
# algorithms
# Medium (45.70%)
# Likes:    4942
# Dislikes: 185
# Total Accepted:    668.3K
# Total Submissions: 1.5M
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# Given a 2d grid map of '1's (land) and '0's (water), count the number of
# islands. An island is surrounded by water and is formed by connecting
# adjacent lands horizontally or vertically. You may assume all four edges of
# the grid are all surrounded by water.
# 
# Example 1:
# 
# 
# Input:
# 11110
# 11010
# 11000
# 00000
# 
# Output: 1
# 
# 
# Example 2:
# 
# 
# Input:
# 11000
# 11000
# 00100
# 00011
# 
# Output: 3
# 
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # def bfs(i, j, row, col):
        #     grid[i][j] = '2'
        #     if i < row - 1 and grid[i + 1][j] == '1':
        #         bfs(i + 1, j, row, col)
        #     if i and grid[i - 1][j] == '1':
        #         bfs(i - 1, j, row, col)
        #     if j < col - 1 and grid[i][j + 1] == '1':
        #         bfs(i, j + 1, row, col)
        #     if j and grid[i][j - 1] == '1':
        #         bfs(i, j - 1, row, col)
        def bfs(i, j, vectors):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]):
                return
            if grid[i][j] != '1': return
            grid[i][j] = '2'
            for m, n in vectors:
                x = i + m
                y = j + n
                bfs(x, y, vectors)

        ans = 0
        row = len(grid)
        if not row: return ans
        col = len(grid[0])
        vectors = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    ans += 1
                    bfs(i, j, vectors)
        
        return ans
        
                        

# @lc code=end

