#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#
# https://leetcode.com/problems/n-queens/description/
#
# algorithms
# Hard (44.61%)
# Likes:    1605
# Dislikes: 66
# Total Accepted:    189.7K
# Total Submissions: 423.3K
# Testcase Example:  '4'
#
# The n-queens puzzle is the problem of placing n queens on an n×n chessboard
# such that no two queens attack each other.
# 
# 
# 
# Given an integer n, return all distinct solutions to the n-queens puzzle.
# 
# Each solution contains a distinct board configuration of the n-queens'
# placement, where 'Q' and '.' both indicate a queen and an empty space
# respectively.
# 
# Example:
# 
# 
# Input: 4
# Output: [
# ⁠[".Q..",  // Solution 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
# 
# ⁠["..Q.",  // Solution 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# Explanation: There exist two distinct solutions to the 4-queens puzzle as
# shown above.
# 
# 
#

# @lc code=start
class Solution:
    def __init__(self):
        self.ans = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.cols = [False] * n
        self.master = [False] * n * 2
        self.slave = [False] * n * 2
        result = [['.'] * n for i in range(n)]        
        self.dfs(0, result)
        return self.ans
    
    def dfs(self, row, result):
        if row == len(result):
            list_1 = []
            for i in range(row):
                list_1.append(''.join(result[i]))
            self.ans.append(list_1)
            return
        for col in range(len(result[row])):
            if self.is_valid(row, col, result):
                self.add_q(row, col, result)
                self.dfs(row + 1, result)
                self.remove_q(row, col, result)
            
    def is_valid(self, row, col, result):
        if self.cols[col] or self.master[row + col] or self.slave[row - col + len(result)]:
            return False
        else:
            return True
    
    def add_q(self, row, col, result):
        result[row][col] = 'Q'
        self.cols[col] = True
        self.master[row + col] = True
        self.slave[row - col + len(result)] = True

    def remove_q(self, row, col, result):
        result[row][col] = '.'
        self.cols[col] = False
        self.master[row + col] = False
        self.slave[row - col + len(result)] = False
# @lc code=end

