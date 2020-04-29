import java.util.LinkedList;

import javafx.util.Pair;

/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (36.83%)
 * Likes:    1174
 * Dislikes: 632
 * Total Accepted:    387.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
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
    /**
     * BFS
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int minDepth = 1;
        LinkedList<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        deque.addLast(new Pair<TreeNode, Integer>(root, minDepth));
        while (!deque.isEmpty()) {
            Pair pair = deque.pop();
            TreeNode current = (TreeNode)pair.getKey();
            minDepth = (Integer)pair.getValue();
            if (current.left == null && current.right == null) {
                break;
            }
            if (current.left != null) {
                deque.addLast(new Pair<TreeNode, Integer>(current.left, minDepth + 1));
            }
            if (current.right != null) {
                deque.addLast(new Pair<TreeNode, Integer>(current.right, minDepth + 1));
            }
        }
        return minDepth;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度        
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;
        
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1; 
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

