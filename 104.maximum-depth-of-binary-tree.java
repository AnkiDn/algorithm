import java.util.LinkedList;
import java.util.Stack;

import javafx.util.Pair;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (64.67%)
 * Likes:    2186
 * Dislikes: 66
 * Total Accepted:    754.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
 * 
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
    int deep = 0;
    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        recur(deep, root);
        return ++deep;
    }

    private void recur(int level, TreeNode node) {
        if (node == null) return;
        recur(level + 1, node.left);
        if(level > deep) {
            deep = level;
        }
        recur(level + 1, node.right);
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int deep = 1;
        LinkedList<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        deque.push(new Pair<TreeNode,Integer>(root, deep));
        while (!deque.isEmpty()) {
            Pair pair = deque.pop();
            // int current_deep = pair.getValue();
            TreeNode node = (TreeNode)pair.getKey();
            if (node != null) {
                deep = (Integer)pair.getValue();
                // deep = Math.max(deep, current_deep);
                deque.addLast(new Pair<TreeNode,Integer>(node.left, deep + 1));
                deque.addLast(new Pair<TreeNode,Integer>(node.right, deep + 1));
            }
        }
        return deep;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=end

