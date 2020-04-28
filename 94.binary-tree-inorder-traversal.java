import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StateNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (61.58%)
 * Likes:    2707
 * Dislikes: 117
 * Total Accepted:    673.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        return list;
    }

    private void recur(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            recur(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            recur(node.right, list);
        }
    }

    /**
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<StatusNode> stack = new Stack<>();
        stack.push(new StatusNode(StatusNode.WHITE, root));
        while (!stack.isEmpty()) {
            StatusNode statusNode = stack.pop();
            if (statusNode.node == null) continue;
            switch (statusNode.color) {
                case StatusNode.WHITE:
                    stack.push(new StatusNode(StatusNode.WHITE, statusNode.node.right));
                    stack.push(new StatusNode(StatusNode.GRAY, statusNode.node));
                    stack.push(new StatusNode(StatusNode.WHITE, statusNode.node.left));
                    break;
                default:
                    list.add(statusNode.node.val); 
                    break;
            }
        }
        return list;
    }

    class StatusNode {
        final static int WHITE = 0, GRAY = 1;
        int color;
        TreeNode node;
        StatusNode(int color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
// @lc code=end
