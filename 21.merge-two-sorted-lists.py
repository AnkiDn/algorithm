#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#
# https://leetcode.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (52.03%)
# Likes:    3686
# Dislikes: 543
# Total Accepted:    915.5K
# Total Submissions: 1.8M
# Testcase Example:  '[1,2,4]\n[1,3,4]'
#
# Merge two sorted linked lists and return it as a new list. The new list
# should be made by splicing together the nodes of the first two lists.
# 
# Example:
# 
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    #递归
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

    # 迭代
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        newNode = ListNode(0)
        tempNode = newNode
        while l1 and l2:
            if l1.val < l2.val:
                tempNode.next = l1
                l1 = l1.next
            else:
                tempNode.next = l2
                l2 = l2.next
            tempNode = tempNode.next
        tempNode.next = l1 if l1 is not None else l2
        return newNode.next
# @lc code=end

