#
# @lc app=leetcode id=155 lang=python3
#
# [155] Min Stack
#
# https://leetcode.com/problems/min-stack/description/
#
# algorithms
# Easy (43.16%)
# Likes:    3024
# Dislikes: 296
# Total Accepted:    508.9K
# Total Submissions: 1.2M
# Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
#
# Design a stack that supports push, pop, top, and retrieving the minimum
# element in constant time.
# 
# 
# push(x) -- Push element x onto stack.
# pop() -- Removes the element on top of the stack.
# top() -- Get the top element.
# getMin() -- Retrieve the minimum element in the stack.
# 
# 
# 
# Example 1:
# 
# 
# Input
# ["MinStack","push","push","push","getMin","pop","top","getMin"]
# [[],[-2],[0],[-3],[],[],[],[]]
# 
# Output
# [null,null,null,null,-3,null,0,-2]
# 
# Explanation
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin(); // return -3
# minStack.pop();
# minStack.top();    // return 0
# minStack.getMin(); // return -2
# 
# 
# 
# Constraints:
# 
# 
# Methods pop, top and getMin operations will always be called on non-empty
# stacks.
# 
# 
#

# @lc code=start
class MinStack:
    # 单调辅助栈
    # def __init__(self):
    #    self.stack = []
    #    self.min_stack = []
        
    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack) == 0 or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self) -> None:
        top = self.stack.pop()
        if top == self.min_stack[-1]:
            self.min_stack.pop()
        return top

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]

    # 单栈保存
    def __init__(self):
        self.stack = []
        self.min = sys.maxsize
        
    def push(self, x: int) -> None:
        if  x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:
        top = self.stack.pop()
        if top == self.min:
            self.min = self.stack.pop()
        return top

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

