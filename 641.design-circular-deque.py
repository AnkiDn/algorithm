#
# @lc app=leetcode id=641 lang=python3
#
# [641] Design Circular Deque
#
# https://leetcode.com/problems/design-circular-deque/description/
#
# algorithms
# Medium (51.37%)
# Likes:    193
# Dislikes: 38
# Total Accepted:    13.9K
# Total Submissions: 27K
# Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
#
# Design your implementation of the circular double-ended queue (deque).
# 
# Your implementation should support following operations:
# 
# 
# MyCircularDeque(k): Constructor, set the size of the deque to be k.
# insertFront(): Adds an item at the front of Deque. Return true if the
# operation is successful.
# insertLast(): Adds an item at the rear of Deque. Return true if the operation
# is successful.
# deleteFront(): Deletes an item from the front of Deque. Return true if the
# operation is successful.
# deleteLast(): Deletes an item from the rear of Deque. Return true if the
# operation is successful.
# getFront(): Gets the front item from the Deque. If the deque is empty, return
# -1.
# getRear(): Gets the last item from Deque. If the deque is empty, return
# -1.
# isEmpty(): Checks whether Deque is empty or not. 
# isFull(): Checks whether Deque is full or not.
# 
# 
# 
# 
# Example:
# 
# 
# MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be
# 3
# circularDeque.insertLast(1);            // return true
# circularDeque.insertLast(2);            // return true
# circularDeque.insertFront(3);            // return true
# circularDeque.insertFront(4);            // return false, the queue is full
# circularDeque.getRear();              // return 2
# circularDeque.isFull();                // return true
# circularDeque.deleteLast();            // return true
# circularDeque.insertFront(4);            // return true
# circularDeque.getFront();            // return 4
# 
# 
# 
# 
# Note:
# 
# 
# All values will be in the range of [0, 1000].
# The number of operations will be in the range of [1, 1000].
# Please do not use the built-in Deque library.
# 
# 
#

# @lc code=start
class MyCircularDeque:
    def __init__(self, k: int):
        self.capacity = k + 1
        self.arr = [0 for i in range(self.capacity)]
        self.front = 0
        self.tail_next = 0
        

    def insertFront(self, value: int) -> bool:
        if self.isFull(): 
            return False
        self.front = (self.capacity - 1 + self.front) % self.capacity
        self.arr[self.front] = value
        return True
        

    def insertLast(self, value: int) -> bool:
        if self.isFull():
            return False
        self.arr[self.tail_next] = value
        self.tail_next = (self.tail_next + 1) % self.capacity
        return True
        

    def deleteFront(self) -> bool:
        if self.isEmpty(): 
            return False
        self.front = (self.front + 1) % self.capacity
        return True
        

    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False
        self.tail_next = (self.tail_next - 1 + self.capacity) % self.capacity
        return True
        

    def getFront(self) -> int:
        if self.isEmpty():
            return -1
        return self.arr[self.front]
        

    def getRear(self) -> int:
        if self.isEmpty():
            return -1
        return self.arr[(self.tail_next - 1 + self.capacity) % self.capacity]
        

    def isEmpty(self) -> bool:
        return self.front == self.tail_next
        

    def isFull(self) -> bool:
        return (self.tail_next + 1) % self.capacity == self.front
        


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
# @lc code=end

