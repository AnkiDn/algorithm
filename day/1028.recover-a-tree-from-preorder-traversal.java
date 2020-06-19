/*
 * @lc app=leetcode id=1028 lang=java
 *
 * [1028] Recover a Tree From Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String s) {
        if (s == null) return null;
        char[] ca = s.toCharArray();
        int index = 0, len = ca.length;
        Deque<TreeNode> stack = new ArrayDeque();
        while (index < len) {
            int level = 0, value = 0;
            while (index < len && ca[index] == '-') {
                ++level; 
                ++index;
            }
            while (index < len && Character.isDigit(ca[index])) {
                value = value * 10 + ca[index] - '0';
                ++index;
            }
            TreeNode node = new TreeNode(value);
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }
            if (level == stack.size()) {
                stack.peek().left = node;
            } else {
                while (level != stack.size()) stack.pop();
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) stack.pop();
        return stack.peek();
    }
}
// @lc code=end

